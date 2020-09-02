package com.github.idozahavy.prettyprinter.convertors;

import java.util.HashSet;

import com.github.idozahavy.prettyprinter.config.InvokePermit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrettyConvertorConfig implements Cloneable {

	protected HashSet<Integer> fieldModifiers;
	protected HashSet<InvokePermit> invokePermits;
	protected HashSet<Object> convertedObjects;

	public PrettyConvertorConfig(HashSet<Integer> fieldModifiers, HashSet<InvokePermit> invokePermits,
			HashSet<Object> convertedObjects) {
		this.fieldModifiers = new HashSet<>();
		this.invokePermits = new HashSet<>();
		this.convertedObjects = new HashSet<>();

		this.fieldModifiers.addAll(fieldModifiers);
		this.invokePermits.addAll(invokePermits);
		this.convertedObjects.addAll(convertedObjects);
	}

	public boolean has(Integer modifier) {
		if (fieldModifiers != null) {
			return fieldModifiers.contains(modifier);
		}
		return false;
	}

	public boolean has(InvokePermit permit) {
		if (invokePermits != null) {
			return invokePermits.contains(permit);
		}
		return false;
	}

	public boolean hasConverted(Object object) {
		if (convertedObjects != null) {
			return convertedObjects.contains(object);
		} else {
			convertedObjects = new HashSet<>();
		}
		return false;
	}

	public void addConverted(Object object) {
		if (convertedObjects == null) {
			convertedObjects = new HashSet<>();
		}
		convertedObjects.add(object);
	}

	public void resetConverted() {
		if (convertedObjects != null) {
			convertedObjects.clear();
		} else {
			convertedObjects = new HashSet<>();
		}
	}

	public PrettyConvertorConfig clone() {
		return new PrettyConvertorConfig(fieldModifiers, invokePermits, convertedObjects);
	}
}
