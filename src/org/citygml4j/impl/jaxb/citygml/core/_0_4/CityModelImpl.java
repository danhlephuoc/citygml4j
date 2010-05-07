package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.appearance._0_4.AppearanceMemberImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureCollectionImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.FeaturePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType;
import org.citygml4j.jaxb.citygml._0_4.CityModelType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.FeatureProperty;

public class CityModelImpl extends AbstractFeatureCollectionImpl implements CityModel {
	private CityModelType cityModelType;

	public CityModelImpl() {
		this(new CityModelType());
	}

	public CityModelImpl(CityModelType cityModelType) {
		super(cityModelType);
		this.cityModelType = cityModelType;
	}

	@Override
	public CityModelType getJAXBObject() {
		return cityModelType;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYMODEL;
	}

	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}

	public List<FeatureProperty> getFeatureMember() {
		List<FeatureProperty> featurePropertyList = new ArrayList<FeatureProperty>();

		for (JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem : cityModelType.getFeatureMember()) {
			if (featurePropertyTypeElem.getValue() != null) {
				if (!isCityObjectMemberElement(featurePropertyTypeElem) &&
						!(featurePropertyTypeElem.getValue() instanceof AppearancePropertyType))
					featurePropertyList.add(new FeaturePropertyImpl(featurePropertyTypeElem.getValue()));
			}
		}

		return featurePropertyList;
	}

	public FeatureArrayProperty getFeatureMembers() {
		// well, there is no other way but returning null
		return null;
	}

	public void setFeatureMember(List<FeatureProperty> featureMember) {
		unsetFeatureMember();
		List<JAXBElement<? extends FeaturePropertyType>> featurePropertyTypeList = new ArrayList<JAXBElement<? extends FeaturePropertyType>>();

		for (FeatureProperty featureProperty : featureMember)
			if (!(featureProperty instanceof CityObjectMember) && 
					!(featureProperty instanceof AppearanceMember))
				featurePropertyTypeList.add(ObjectFactory.GML.createFeatureMember(((FeaturePropertyImpl)featureProperty).getJAXBObject()));

		cityModelType.getFeatureMember().addAll(featurePropertyTypeList);
	}

	public void setAppearanceMember(List<AppearanceMember> appearanceMember) {
		unsetAppearanceMember();
		List<JAXBElement<? extends FeaturePropertyType>> featurePropertyTypeList = new ArrayList<JAXBElement<? extends FeaturePropertyType>>();

		for (FeatureProperty featureProperty : appearanceMember)
			featurePropertyTypeList.add(ObjectFactory.CITYGML_0_4.createAppearanceMember(((AppearanceMemberImpl)featureProperty).getJAXBObject()));

		cityModelType.getFeatureMember().addAll(featurePropertyTypeList);
	}

	public void setCityObjectMember(List<CityObjectMember> cityObjectMember) {
		unsetCityObjectMember();
		List<JAXBElement<? extends FeaturePropertyType>> featurePropertyTypeList = new ArrayList<JAXBElement<? extends FeaturePropertyType>>();

		for (FeatureProperty featureProperty : cityObjectMember)
			featurePropertyTypeList.add(ObjectFactory.CITYGML_0_4.createCityObjectMember(((CityObjectMemberImpl)featureProperty).getJAXBObject()));

		cityModelType.getFeatureMember().addAll(featurePropertyTypeList);
	}

	public void addFeatureMember(FeatureProperty featureMember) {
		if (!(featureMember instanceof CityObjectMember) &&
				!(featureMember instanceof AppearanceMember))
			cityModelType.getFeatureMember().add(ObjectFactory.GML.createFeatureMember(((FeaturePropertyImpl)featureMember).getJAXBObject()));
	}

	public void setFeatureMembers(FeatureArrayProperty featureMembers) {
		// where should we put this?
	}

	public void addCityObjectMember(CityObjectMember cityObjectMember) {
		cityModelType.getFeatureMember().add(ObjectFactory.CITYGML_0_4.createCityObjectMember(((CityObjectMemberImpl)cityObjectMember).getJAXBObject()));
	}

	public List<CityObjectMember> getCityObjectMember() {
		List<CityObjectMember> featurePropertyList = new ArrayList<CityObjectMember>();

		for (JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem : cityModelType.getFeatureMember())
			if (featurePropertyTypeElem.getValue() != null)
				if (isCityObjectMemberElement(featurePropertyTypeElem))
					featurePropertyList.add(new CityObjectMemberImpl(featurePropertyTypeElem.getValue()));

		return featurePropertyList;
	}

	public void addAppearanceMember(AppearanceMember appearanceMember) {
		cityModelType.getFeatureMember().add(ObjectFactory.CITYGML_0_4.createAppearanceMember(((AppearanceMemberImpl)appearanceMember).getJAXBObject()));
	}

	public List<AppearanceMember> getAppearanceMember() {
		List<AppearanceMember> featurePropertyList = new ArrayList<AppearanceMember>();

		for (JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem : cityModelType.getFeatureMember())
			if (featurePropertyTypeElem.getValue() != null)
				if (featurePropertyTypeElem.getValue() instanceof AppearancePropertyType)
					featurePropertyList.add(new AppearanceMemberImpl((AppearancePropertyType)featurePropertyTypeElem.getValue()));

		return featurePropertyList;
	}

	@Override
	public void calcBoundedBy() {
		List<FeatureProperty> featurePropertyList = new ArrayList<FeatureProperty>();
		featurePropertyList.addAll(getCityObjectMember());
		featurePropertyList.addAll(getFeatureMember());

		for (FeatureProperty featureProperty : featurePropertyList) {
			AbstractFeature abstractFeature = featureProperty.getFeature();
			if (abstractFeature != null)
				calcBoundedBy(abstractFeature);
		}
	}

	public void addGenericApplicationPropertyOfCityModel(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			cityModelType.get_GenericApplicationPropertyOfCityModel().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityModel() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : cityModelType.get_GenericApplicationPropertyOfCityModel()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfCityModel(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			cityModelType.unset_GenericApplicationPropertyOfCityModel();
			cityModelType.get_GenericApplicationPropertyOfCityModel().addAll(elemList);
		}
	}

	private boolean isCityObjectMemberElement(JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem) {
		return ((featurePropertyTypeElem.getName().getNamespaceURI().equals(CoreModule.v0_4_0.getNamespaceUri()) ||
				featurePropertyTypeElem.getName().getNamespaceURI().equals(CoreModule.v1_0_0.getNamespaceUri())) &&
				featurePropertyTypeElem.getName().getLocalPart().equals("cityObjectMember"));
	}

	public boolean isSetAppearanceMember() {
		if (cityModelType.isSetFeatureMember()) {
			for (JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem : cityModelType.getFeatureMember())
				if (featurePropertyTypeElem.getValue() != null && 
						featurePropertyTypeElem.getValue() instanceof AppearancePropertyType)
					return true;
		}

		return false;
	}

	public boolean isSetCityObjectMember() {
		if (cityModelType.isSetFeatureMember()) {
			for (JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem : cityModelType.getFeatureMember())
				if (featurePropertyTypeElem.getValue() != null && 
						isCityObjectMemberElement(featurePropertyTypeElem))
					return true;
		}

		return false;
	}

	@Override
	public boolean isSetFeatureMember() {
		if (cityModelType.isSetFeatureMember()) {
			for (JAXBElement<? extends FeaturePropertyType> featurePropertyTypeElem : cityModelType.getFeatureMember())
				if (featurePropertyTypeElem.getValue() != null &&
						!(featurePropertyTypeElem.getValue() instanceof AppearancePropertyType) && 
						!isCityObjectMemberElement(featurePropertyTypeElem))
					return true;
		}

		return false;
	}

	public boolean isSetGenericApplicationPropertyOfCityModel() {
		return cityModelType.isSet_GenericApplicationPropertyOfCityModel();
	}

	public void unsetAppearanceMember() {
		if (cityModelType.isSetFeatureMember()) {
			Iterator<JAXBElement<? extends FeaturePropertyType>> iter = cityModelType.getFeatureMember().iterator();

			while (iter.hasNext()) {
				JAXBElement<? extends FeaturePropertyType> jaxbElem = iter.next();				
				if (jaxbElem.getValue() != null)
					if (jaxbElem.getValue() instanceof AppearancePropertyType)
						iter.remove();						
			}
		}
	}

	public void unsetCityObjectMember() {
		if (cityModelType.isSetFeatureMember()) {
			Iterator<JAXBElement<? extends FeaturePropertyType>> iter = cityModelType.getFeatureMember().iterator();

			while (iter.hasNext()) {
				JAXBElement<? extends FeaturePropertyType> jaxbElem = iter.next();				
				if (jaxbElem.getValue() != null)
					if (isCityObjectMemberElement(jaxbElem))
						iter.remove();						
			}
		}
	}

	@Override
	public void unsetFeatureMember() {
		if (cityModelType.isSetFeatureMember()) {
			Iterator<JAXBElement<? extends FeaturePropertyType>> iter = cityModelType.getFeatureMember().iterator();

			while (iter.hasNext()) {
				JAXBElement<? extends FeaturePropertyType> jaxbElem = iter.next();				
				if (jaxbElem.getValue() != null)
					if (!(jaxbElem.getValue() instanceof AppearancePropertyType) &&
							!isCityObjectMemberElement(jaxbElem))
						iter.remove();						
			}
		}
	}

	public void unsetGenericApplicationPropertyOfCityModel() {
		cityModelType.unset_GenericApplicationPropertyOfCityModel();
	}

	public boolean unsetAppearanceMember(AppearanceMember appearanceMember) {
		if (cityModelType.isSetFeatureMember()) {
			Iterator<JAXBElement<? extends FeaturePropertyType>> iter = cityModelType.getFeatureMember().iterator();

			while (iter.hasNext()) {
				JAXBElement<? extends FeaturePropertyType> jaxbElem = iter.next();				
				if (jaxbElem.getValue() != null && jaxbElem.getValue().equals(((AppearanceMemberImpl)appearanceMember).getJAXBObject())) {
					iter.remove();
					return true;
				}
			}
		}

		return false;
	}

	public boolean unsetCityObjectMember(CityObjectMember cityObjectMember) {
		if (cityModelType.isSetFeatureMember()) {
			Iterator<JAXBElement<? extends FeaturePropertyType>> iter = cityModelType.getFeatureMember().iterator();

			while (iter.hasNext()) {
				JAXBElement<? extends FeaturePropertyType> jaxbElem = iter.next();				
				if (jaxbElem.getValue() != null && jaxbElem.getValue().equals(((CityObjectMemberImpl)cityObjectMember).getJAXBObject())) {
					iter.remove();
					return true;
				}
			}
		}

		return false;
	}

	public boolean unsetGenericApplicationPropertyOfCityModel(ADEComponent adeObject) {
		if (cityModelType.isSet_GenericApplicationPropertyOfCityModel()) {
			Iterator<JAXBElement<?>> iter = cityModelType.get_GenericApplicationPropertyOfCityModel().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

	public boolean unsetFeatureMember(FeatureProperty featureMember) {
		if (cityModelType.isSetFeatureMember()) {
			Iterator<JAXBElement<? extends FeaturePropertyType>> iter = cityModelType.getFeatureMember().iterator();

			while (iter.hasNext()) {
				JAXBElement<? extends FeaturePropertyType> jaxbElem = iter.next();				
				if (jaxbElem.getValue() != null && jaxbElem.getValue().equals(((FeaturePropertyImpl)featureMember).getJAXBObject())) {
					iter.remove();
					return true;
				}
			}
		}

		return false;
	}

}