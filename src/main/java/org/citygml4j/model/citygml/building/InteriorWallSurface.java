/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class InteriorWallSurface extends AbstractBoundarySurface {
	private List<ADEComponent> ade;

	public InteriorWallSurface() {
		
	}
	
	public InteriorWallSurface(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfInteriorWallSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfInteriorWallSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfInteriorWallSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfInteriorWallSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfInteriorWallSurface() {
		if (isSetGenericApplicationPropertyOfInteriorWallSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfInteriorWallSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfInteriorWallSurface() ? this.ade.remove(ade) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_BUILDING_WALL_SURFACE;
	}
	
	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfInteriorWallSurface()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorWallSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorWallSurface copy = (target == null) ? new InteriorWallSurface() : (InteriorWallSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfInteriorWallSurface(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
}
