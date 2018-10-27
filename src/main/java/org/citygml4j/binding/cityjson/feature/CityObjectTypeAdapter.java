/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.citygml4j.binding.cityjson.CityJSONRegistry;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityObjectTypeAdapter implements JsonSerializer<AbstractCityObjectType>, JsonDeserializer<AbstractCityObjectType> {
	private CityObjectTypeFilter typeFilter;

	public CityObjectTypeAdapter withTypeFilter(CityObjectTypeFilter inputFilter) {
		this.typeFilter = inputFilter;
		return this;
	}
	
	@Override
	public JsonElement serialize(AbstractCityObjectType cityObject, Type typeOfSrc, JsonSerializationContext context) {
		return (typeFilter == null || typeFilter.accept(cityObject.getType())) ? context.serialize(cityObject) : null;
	}

	@Override
	public AbstractCityObjectType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractCityObjectType cityObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			Class<?> typeClass = CityJSONRegistry.getInstance().getCityObjectClass(type.getAsString());
			if (typeClass != null && (typeFilter == null || typeFilter.accept(type.getAsString()))) {
				cityObject = context.deserialize(object, typeClass);
				cityObject.type = type.getAsString();

				// deserialize unknown properties
				if (cityObject.isSetAttributes() && cityObject.getAttributes().unknownProperties != null) {
					CityJSONRegistry registry = CityJSONRegistry.getInstance();
					for (Map.Entry<String, JsonElement> property : cityObject.getAttributes().unknownProperties.entrySet()) {
						String key = property.getKey();

						// check whether we have an extension to deal with the property
						Class<?> propertyClass = registry.getGenericApplicationPropertyClass(key, type.getAsString());
						if (propertyClass != null) {
							Object value = context.deserialize(property.getValue(), propertyClass);
							if (value != null)
								cityObject.getAttributes().addGenericApplicationProperty(key, value);
						}

						// if not, then we try and map it to a generic attribute
						else {
							Object value = deserialize(property.getValue(), context);
							if (value != null)
								cityObject.getAttributes().addGenericAttribute(key, value);
						}
					}

					cityObject.getAttributes().unknownProperties = null;
				}
			}
		}
		
		return cityObject;
	}

	private Object deserialize(JsonElement element, JsonDeserializationContext context) {
		if (element.isJsonPrimitive()) {
			JsonPrimitive primitive = element.getAsJsonPrimitive();
			if (primitive.isBoolean())
				return primitive.getAsBoolean();
			else if (primitive.isNumber()) {
				Number value = primitive.getAsNumber();
				if (value.intValue() == value.doubleValue())
					return value.intValue();
				else
					return value.doubleValue();
			} else if (primitive.isString()) {
				String value = primitive.getAsString();
				try {
					return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
				} catch (DateTimeParseException e) {
					return value;
				}
			} else
				return context.deserialize(primitive, Object.class);
		} else if (element.isJsonObject()) {
			JsonObject object = element.getAsJsonObject();
			Map<String, Object> attributeSet = new HashMap<>();

			for (Map.Entry<String, JsonElement> nested : object.entrySet()) {
				Object value = deserialize(nested.getValue(), context);
				if (value != null)
					attributeSet.put(nested.getKey(), value);
			}

			if (!attributeSet.isEmpty())
				return attributeSet;
		} else if (element.isJsonArray()) {
			JsonArray array = element.getAsJsonArray();
			List<Object> items = new ArrayList<>();

			for (int i = 0; i < array.size(); i++) {
				Object value = deserialize(array.get(i), context);
				if (value != null)
					items.add(value);
			}

			if (!items.isEmpty())
				return items;
		}

		return null;
	}
}
