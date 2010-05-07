package org.citygml4j.impl.jaxb.citygml.generics._1;

import org.citygml4j.jaxb.citygml.gen._1.UriAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.GenericUriAttribute;

public class GenericUriAttributeImpl extends GenericAttributeImpl implements GenericUriAttribute {
	private UriAttributeType uriAttributeType;

	public GenericUriAttributeImpl() {
		this(new UriAttributeType());
	}

	public GenericUriAttributeImpl(UriAttributeType uriAttributeType) {
		super(uriAttributeType);
		this.uriAttributeType = uriAttributeType;
	}

	@Override
	public UriAttributeType getJAXBObject() {
		return uriAttributeType;
	}

	public String getValue() {
		return uriAttributeType.getValue();
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.URIATTRIBUTE;
	}

	public void setValue(String value) {
		uriAttributeType.setValue(value);
	}

	public boolean isSetValue() {
		return uriAttributeType.isSetValue();
	}

	public void unsetValue() {
		uriAttributeType.setValue(null);
	}
}