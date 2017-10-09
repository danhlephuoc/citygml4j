package org.citygml4j.builder.json.objects.feature;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public abstract class AbstractAttributes {
	private Date creationDate;
	private Date terminationDate;
	private transient Map<String, Object> genericAttributes;
	private transient List<String> attributeNames;
	
	public boolean isSetCreationDate() {
		return creationDate != null;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}
	
	public Date getTerminationDate() {
		return terminationDate;
	}
	
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public boolean isSetGenericAttributes() {
		return genericAttributes != null;
	}

	public void addGenericAttribute(String name, Object value) {
		if (genericAttributes == null)
			genericAttributes = new HashMap<>();

		genericAttributes.put(name, value);
	}

	public Map<String, Object> getGenericAttributes() {
		return genericAttributes;
	}

	public void setGenericAttributes(Map<String, Object> genericAttributes) {
		this.genericAttributes = genericAttributes;
	}
	
	public boolean hasAttributes() {
		return genericAttributes != null
				|| creationDate != null
				|| terminationDate != null;
	}

	protected List<String> getAttributeNames() {
		if (attributeNames == null) {
			attributeNames = new ArrayList<>();
			
			Class<?> clazz = this.getClass();
			do {
				for (Field field : clazz.getDeclaredFields()) {
					if (Modifier.isTransient(field.getModifiers()))
						continue;
					
					SerializedName name = field.getAnnotation(SerializedName.class);
					attributeNames.add(name != null ? name.value() : field.getName());
				}
			} while ((clazz = clazz.getSuperclass()) != null);
		}

		return attributeNames;
	}

}