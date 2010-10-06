package org.citygml4j.model.gml.feature;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.gml.base.AbstractGML;

public interface AbstractFeature extends AbstractGML {
	public BoundingShape calcBoundedBy(boolean setBoundedBy);
	public BoundingShape getBoundedBy();
	public LocationProperty getLocation();
	public List<ADEComponent> getGenericADEComponent();
	public boolean isSetBoundedBy();
	public boolean isSetLocation();
	public boolean isSetGenericADEComponent();

	public void setBoundedBy(BoundingShape boundingShape);
	public void setLocation(LocationProperty location);
	public void addGenericADEComponent(ADEComponent ade);
	public void setGenericADEComponent(List<ADEComponent> ade);
	public void unsetBoundedBy();
	public void unsetLocation();
	public void unsetGenericADEComponent();
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent);
	
	public void accept(FeatureVisitor visitor);
	public <T> T accept(FeatureFunctor<T> visitor);
}