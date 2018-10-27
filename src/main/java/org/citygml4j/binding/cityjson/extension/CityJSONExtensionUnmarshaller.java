package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.citygml.ade.ADEUnmarshallerHelper;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

import java.util.List;

public interface CityJSONExtensionUnmarshaller {
    void setADEUnmarshallerHelper(ADEUnmarshallerHelper helper);
    void unmarshalCityObject(AbstractCityObjectType src, CityJSON cityJSON, AbstractFeature parent);
    void unmarshalSemanticSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent);
    void unmarshalGenericApplicationProperty(String name, Object value, AbstractCityObject dest);
}