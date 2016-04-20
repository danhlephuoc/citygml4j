/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.primitives.Envelope;

public class BoundingShape implements GML, Child, Copyable {
	private Envelope envelope;
	private Null _null;
	private ModelObject parent;
	
	public BoundingShape() {
		
	}

	public BoundingShape(Envelope envelope) {
		setEnvelope(envelope);
	}
	
	public BoundingShape(BoundingBox boundingBox) {
		setEnvelope(boundingBox);
	}
	
	public Envelope getEnvelope() {
		return envelope;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetEnvelope() {
		return envelope != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setEnvelope(Envelope envelope) {
		if (envelope != null)
			envelope.setParent(this);

		this.envelope = envelope;
	}

	public void setEnvelope(BoundingBox boundingBox) {
		if (boundingBox != null) {
			if (!isSetEnvelope())
				setEnvelope(new Envelope());
			else {
				envelope.unsetPos();
				envelope.unsetCoord();
				envelope.unsetCoordinates();
			}

			envelope.setLowerCorner(boundingBox.getLowerCorner());
			envelope.setUpperCorner(boundingBox.getUpperCorner());
			envelope.setSrsDimension(3);
		}
	}

	public void updateEnvelope(BoundingBox boundingBox) {
		if (boundingBox != null) {
			if (!isSetEnvelope())
				setEnvelope(boundingBox);
			else {
				BoundingBox bbox = envelope.toBoundingBox();
				if (bbox != null) {
					bbox.update(boundingBox);
					setEnvelope(bbox);
				} else
					setEnvelope(boundingBox);
			}
		}
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);

		this._null = _null;
	}

	public void unsetEnvelope() {
		if (isSetEnvelope())
			envelope.unsetParent();

		envelope = null;
	}

	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();

		_null = null;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.BOUNDING_SHAPE;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundingShape(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundingShape copy = (target == null) ? new BoundingShape() : (BoundingShape)target;

		if (isSetEnvelope()) {
			copy.setEnvelope((Envelope)copyBuilder.copy(envelope));
			if (copy.getEnvelope() == envelope)
				envelope.setParent(this);
		}

		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

}
