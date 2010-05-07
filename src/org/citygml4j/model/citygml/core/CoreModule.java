package org.citygml4j.model.citygml.core;

import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.CityGMLModuleDependencies;
import org.citygml4j.model.citygml.CityGMLModuleType;
import org.citygml4j.model.citygml.CityGMLModuleVersion;

public enum CoreModule implements CityGMLModule {
	v0_4_0 {
		public String getNamespaceUri() { return "http://www.citygml.org/citygml/1/0/0"; }		
		public String getNamespacePrefix() { return "citygml"; }
		public String getSchemaLocation() { return "http://www.citygml.org/citygml/0/4/0/CityGML.xsd"; }		
		public CityGMLModuleVersion getModuleVersion() { return CityGMLModuleVersion.v0_4_0; }
	},
	v1_0_0 {	
		public String getNamespaceUri() { return "http://www.opengis.net/citygml/1.0"; }
		public String getNamespacePrefix() { return "core"; }
		public String getSchemaLocation() { return null; }
		public CityGMLModuleVersion getModuleVersion() { return CityGMLModuleVersion.v1_0_0; }
	};
	
	private final CityGMLModuleDependencies dependencies;
	
	CoreModule(CityGMLModule... dependencies) {
		this.dependencies = new CityGMLModuleDependencies(dependencies);
	}
	
	public abstract String getNamespaceUri();
	
	public abstract String getNamespacePrefix();
	
	public abstract String getSchemaLocation();
	
	public abstract CityGMLModuleVersion getModuleVersion();
	
	public CityGMLModuleType getModuleType() {
		return CityGMLModuleType.CORE;
	}
	
	public CityGMLModuleDependencies getModuleDependencies() {
		return dependencies;
	}
}