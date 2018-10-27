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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractAttributesAdapter<T extends Attributes> implements JsonSerializer<T>, JsonDeserializer<T> {
	private final Class<T> type;
	
	protected AbstractAttributesAdapter(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public JsonElement serialize(T cityGMLAttributes, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = context.serialize(cityGMLAttributes).getAsJsonObject();
		
		// serialize generic attributes
		if (cityGMLAttributes.isSetGenericAttributes()) {
			JsonObject properties = context.serialize(cityGMLAttributes.getGenericAttributes()).getAsJsonObject();
			for (Entry<String, JsonElement> entry : properties.entrySet())
				object.add(entry.getKey(), entry.getValue());
		}
		
		return object;
	}
	
	@Override
	public T deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		T attributes = context.deserialize(json, type);

		// copy unknown properties
		Map<String, JsonElement> unknown = new HashMap<>();
		List<String> predefined = attributes.getAttributeNames();

		for (Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
			String key = entry.getKey();
			if (predefined.contains(key))
				continue;

			unknown.put(key, entry.getValue());
		}

		if (!unknown.isEmpty())
			attributes.unknownProperties = unknown;
		
		return attributes;
	}

}
