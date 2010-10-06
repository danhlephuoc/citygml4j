package org.citygml4j.impl.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRep;

public abstract class AssociationByRepImpl<T extends Associable & Child> implements AssociationByRep<T> {
	private T object;
	private ModelObject parent;

	public T getObject() {
		return object;
	}

	public boolean isSetObject() {
		return object != null;
	}

	public void setObject(T object) {
		if (object != null)
			object.setParent(this);
		
		this.object = object;
	}

	public void unsetObject() {
		if (isSetObject())
			object.unsetParent();
		
		object = null;
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ASSOCIATION_BY_REP;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AssociationByRep<T> copy = (AssociationByRep<T>)target;
        
		if (isSetObject()) {
			copy.setObject((T)copyBuilder.copy(object));
			if (copy.getObject() == object)
				object.setParent(this);
		}
		
		copy.unsetParent();
		
        return copy;
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

}