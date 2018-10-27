package org.citygml4j.binding.cityjson.extension;

import java.util.List;

public interface CityJSONExtensionContext {
    List<CityJSONExtensionModule> getExtensionModules();
    CityJSONExtensionUnmarshaller getExtensionUnmarshaller();
}
