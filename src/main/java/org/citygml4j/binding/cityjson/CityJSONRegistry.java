package org.citygml4j.binding.cityjson;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.BridgeConstructionElementType;
import org.citygml4j.binding.cityjson.feature.BridgeInstallationType;
import org.citygml4j.binding.cityjson.feature.BridgePartType;
import org.citygml4j.binding.cityjson.feature.BridgeType;
import org.citygml4j.binding.cityjson.feature.BuildingInstallationType;
import org.citygml4j.binding.cityjson.feature.BuildingPartType;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.feature.CityFurnitureType;
import org.citygml4j.binding.cityjson.feature.CityObjectGroupType;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.feature.LandUseType;
import org.citygml4j.binding.cityjson.feature.PlantCoverType;
import org.citygml4j.binding.cityjson.feature.RailwayType;
import org.citygml4j.binding.cityjson.feature.RoadType;
import org.citygml4j.binding.cityjson.feature.SolitaryVegetationObjectType;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.feature.TransportSquareType;
import org.citygml4j.binding.cityjson.feature.TunnelInstallationType;
import org.citygml4j.binding.cityjson.feature.TunnelPartType;
import org.citygml4j.binding.cityjson.feature.TunnelType;
import org.citygml4j.binding.cityjson.feature.WaterBodyType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.ADEException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CityJSONRegistry {
    private static CityJSONRegistry instance;

    private final Map<String, Class<? extends AbstractCityObjectType>> typeToClass;
    private final Map<Class<? extends AbstractCityObjectType>, String> classToType;
    private final Map<String, Class<? extends SemanticsType>> surfaceToClass;
    private final Map<String, Map<String, Class<?>>> properties;

    private CityJSONRegistry() {
        typeToClass = new ConcurrentHashMap<>();
        classToType = new ConcurrentHashMap<>();
        surfaceToClass = new ConcurrentHashMap<>();
        properties = new ConcurrentHashMap<>();

        registerType("Building", BuildingType.class);
        registerType("BuildingPart", BuildingPartType.class);
        registerType("BuildingInstallation", BuildingInstallationType.class);
        registerType("Bridge", BridgeType.class);
        registerType("BridgePart", BridgePartType.class);
        registerType("BridgeInstallation", BridgeInstallationType.class);
        registerType("BridgeConstructionElement", BridgeConstructionElementType.class);
        registerType("TINRelief", TINReliefType.class);
        registerType("WaterBody", WaterBodyType.class);
        registerType("PlantCover", PlantCoverType.class);
        registerType("SolitaryVegetationObject", SolitaryVegetationObjectType.class);
        registerType("LandUse", LandUseType.class);
        registerType("CityFurniture", CityFurnitureType.class);
        registerType("GenericCityObject", GenericCityObjectType.class);
        registerType("Road", RoadType.class);
        registerType("Railway", RailwayType.class);
        registerType("TransportSquare", TransportSquareType.class);
        registerType("Tunnel", TunnelType.class);
        registerType("TunnelPart", TunnelPartType.class);
        registerType("TunnelInstallation", TunnelInstallationType.class);
        registerType("CityObjectGroup", CityObjectGroupType.class);
    }

    public static synchronized CityJSONRegistry getInstance() {
        if (instance == null)
            instance = new CityJSONRegistry();

        return instance;
    }

    public String getCityObjectType(AbstractCityObjectType cityObject) {
        String type = classToType.get(cityObject.getClass());
        if (type == null)
            type = cityObject.getClass().getTypeName();

        return type;
    }

    public Class<?> getCityObjectClass(String type) {
        Class<?> typeClass = typeToClass.get(type);
        if (typeClass == null) {
            try {
                Class<?> tmp = Class.forName(type);
                if (AbstractCityObjectType.class.isAssignableFrom(tmp))
                    typeClass = tmp;
            } catch (ClassNotFoundException e) {
                //
            }
        }

        return typeClass;
    }

    public void registerCityObject(String type, Class<? extends AbstractCityObjectType> cityObjectClass) throws ADEException {
        if (type == null)
            throw new ADEException("The city object type must not be null.");

        if (!type.startsWith("+"))
            throw new ADEException("The city object type '" + type + " must start with a '+'.");

        if (cityObjectClass == null)
            throw new ADEException("The city object class must not be null.");

        if (typeToClass.containsKey(type))
            throw new ADEException("The city object type '" + type + "' is already registered.");

        if (classToType.containsKey(cityObjectClass))
            throw new ADEException("The city object class '" + cityObjectClass.getTypeName() + "' is already registered.");

        registerType(type, cityObjectClass);
    }

    public void unregisterCityObject(String type) throws ADEException {
        if (type == null)
            throw new ADEException("The city object type must not be null.");

        if (!type.startsWith("+"))
            throw new ADEException("The city object type '" + type + " must start with a '+'.");

        Class<? extends AbstractCityObjectType> typeClass = typeToClass.get(type);
        if (typeClass != null) {
            typeToClass.remove(type);
            classToType.remove(typeClass);
        }
    }

    private void registerType(String type, Class<? extends AbstractCityObjectType> typeClass) {
        typeToClass.put(type, typeClass);
        classToType.put(typeClass, type);
    }

    public Class<?> getSemanticSurfaceClass(String type) {
        Class<?> typeClass = surfaceToClass.get(type);
        if (typeClass == null) {
            try {
                Class<?> tmp = Class.forName(type);
                if (SemanticsType.class.isAssignableFrom(tmp))
                    typeClass = tmp;
            } catch (ClassNotFoundException e) {
                //
            }
        }

        return typeClass;
    }

    public void registerSemanticSurface(String type, Class<? extends SemanticsType> semanticSurfaceClass) throws ADEException {
        if (type == null)
            throw new ADEException("The semantic surface type must not be null.");

        if (!type.startsWith("+"))
            throw new ADEException("The semantic surface type '" + type + " must start with a '+'.");

        if (semanticSurfaceClass == null)
            throw new ADEException("The semantic surface class must not be null.");

        if (typeToClass.containsKey(type))
            throw new ADEException("The semantic surface type '" + type + "' is already registered.");

        //if (classToType.containsKey(semanticSurfaceClass))
        //    throw new ADEException("The semantic surface class '" + semanticSurfaceClass.getTypeName() + "' is already registered.");

        surfaceToClass.put(type, semanticSurfaceClass);
    }

    public void unregisterSemanticSurface(String type) throws ADEException {
        if (type == null)
            throw new ADEException("The semantic surface type must not be null.");

        if (!type.startsWith("+"))
            throw new ADEException("The semantic surface type '" + type + " must start with a '+'.");

        Class<? extends AbstractCityObjectType> typeClass = typeToClass.get(type);
        if (typeClass != null)
            surfaceToClass.remove(type);
    }

    public Class<?> getGenericApplicationPropertyClass(String propertyName, String parentType) {
        Map<String, Class<?>> property = properties.get(parentType);
        return property != null ? property.get(propertyName) : null;
    }

    public void registerGenericApplicationProperty(String propertyName, Class<?> propertyClass, String parentType) throws ADEException {
        if (propertyName == null)
            throw new ADEException("The property name must not be null.");

        if (propertyClass == null)
            throw new ADEException("The property class must not be null.");

        if (parentType == null)
            throw new ADEException("The parent type must not be null.");

        if (parentType.startsWith("+"))
            throw new ADEException("Generic application properties cannot be registered for extensions. Register a city object extension instead.");

        Class<? extends AbstractCityObjectType> parentClass = typeToClass.get(parentType);
        if (parentClass == null)
            throw new ADEException("Unkown parent type '"+ parentType + "'.");

        Map<String, Class<?>> property = properties.computeIfAbsent(parentType, v -> new ConcurrentHashMap<>());
        if (property.putIfAbsent(propertyName, propertyClass) != null)
            throw new ADEException("The property '" + propertyName + "' is already registered for the type '" + parentType + "'.");
    }

    public void unregisterGenericApplicationProperty(String propertyName, String parentType) throws ADEException {
        if (propertyName == null)
            throw new ADEException("The property name must not be null.");

        if (parentType == null)
            throw new ADEException("The parent type must not be null.");

        Map<String, Class<?>> property = properties.get(parentType);
        if (property != null)
            property.remove(propertyName);
    }

}
