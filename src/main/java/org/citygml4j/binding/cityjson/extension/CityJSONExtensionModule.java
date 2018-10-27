package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;

import java.net.URL;
import java.util.Map;

public interface CityJSONExtensionModule {
    String getSchemaURI();
    URL getSchemaResource();
    Map<String, Class<? extends AbstractCityObjectType>> getCityObjects();
    Map<String, Class<? extends SemanticsType>> getSemanticSurfaces();
    Map<String, Map<String, Class<?>>> getGenericApplicationProperties();
}