/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.CoreModule;

public class CityObjectMember extends FeatureProperty<AbstractCityObject> implements CoreModuleComponent {
	private CoreModule module;
	
	public CityObjectMember() {
		
	}
	
	public CityObjectMember(AbstractCityObject abstractCityObject) {
		super(abstractCityObject);
	}
	
	public CityObjectMember(String href) {
		super(href);
	}
	
	public CityObjectMember(CoreModule module) {
		this.module = module;
	}
	
	public AbstractCityObject getCityObject() {
		return super.getFeature();
	}

	public boolean isSetCityObject() {
		return super.isSetFeature();
	}

	public void setCityObject(AbstractCityObject cityObject) {
		super.setFeature(cityObject);
	}

	public void unsetCityObject() {
		super.unsetFeature();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITY_OBJECT_MEMBER;
	}

	public CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractCityObject> getAssociableClass() {
		return AbstractCityObject.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectMember(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectMember copy = (target == null) ? new CityObjectMember() : (CityObjectMember)target;
		return super.copyTo(copy, copyBuilder);
	}

}
