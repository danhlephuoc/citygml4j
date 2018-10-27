package org.citygml4j.builder.cityjson.unmarshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADEUnmarshaller {
    private Map<String, CityJSONExtensionContext> extensionContexts;

    public ADEUnmarshaller(CityJSONUnmarshaller json) {
        CityGMLContext context = CityGMLContext.getInstance();
        if (context.hasCityJSONExtensionContexts()) {
            extensionContexts = new HashMap<>();
            ADEUnmarshallerHelper helper = new ADEUnmarshallerHelper(json);

            for (CityJSONExtensionContext extensionContext : context.getCityJSONExtensionContexts()) {
                extensionContext.getExtensionUnmarshaller().setADEUnmarshallerHelper(helper);
                for (CityJSONExtensionModule module : extensionContext.getExtensionModules()) {
                    if (module.getCityObjects() != null) {
                        for (String type : module.getCityObjects().keySet())
                            extensionContexts.put(type, extensionContext);
                    }

                    if (module.getSemanticSurfaces() != null) {
                        for (String type : module.getSemanticSurfaces().keySet())
                            extensionContexts.put(type + "_{surface}", extensionContext);
                    }

                    if (module.getGenericApplicationProperties() != null) {
                        for (Map.Entry<String, Map<String, Class<?>>> entry : module.getGenericApplicationProperties().entrySet()) {
                            if (entry.getValue() != null) {
                                for (Map.Entry<String, Class<?>> property : entry.getValue().entrySet())
                                    extensionContexts.put(entry.getKey() + "_{" + property.getKey() + "}", extensionContext);
                            }
                        }
                    }
                }
            }
        }
    }

    public void unmarshalCityObject(AbstractCityObjectType src, CityJSON cityJSON, AbstractFeature parent) {
        if (extensionContexts != null) {
            CityJSONExtensionContext extensionContext = extensionContexts.get(src.getType());
            if (extensionContext != null)
                extensionContext.getExtensionUnmarshaller().unmarshalCityObject(src, cityJSON, parent);
        }
    }

    public void unmarshalSemanticSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
        if (extensionContexts != null) {
            CityJSONExtensionContext extensionContext = extensionContexts.get(src.getType() + "_{surface}");
            if (extensionContext != null)
                extensionContext.getExtensionUnmarshaller().unmarshalSemanticSurface(src, surfaces, lod, parent);
        }
    }

    public void unmarshalGenericApplicationProperty(String name, Object value, String type, AbstractCityObject dest) {
        if (extensionContexts != null) {
            CityJSONExtensionContext extensionContext = extensionContexts.get(type + "_{" + name + "}");
            if (extensionContext != null)
                extensionContext.getExtensionUnmarshaller().unmarshalGenericApplicationProperty(name, value, dest);
        }
    }

}