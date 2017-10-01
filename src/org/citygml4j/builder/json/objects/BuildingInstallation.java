package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class BuildingInstallation extends AbstractCityObject {
	private final CityObjectType type = CityObjectType.BUILDING_INSTALLATION;
	@JsonAdapter(DefaultAttributesAdapter.class)
	private DefaultAttributes attributes;
	
	@Override
	public CityObjectType getType() {
		return type;
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public DefaultAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(DefaultAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryObjectType type) {
		return true;
	}

}
