package com.github.idozahavy.prettyprinter.convertors;

import java.util.Collection;
import java.util.HashSet;

import com.github.idozahavy.prettyprinter.config.InvokationPermit;

import lombok.Data;

@Data
public class ViConvertorConfig implements Cloneable {

	protected HashSet<Integer> fieldModifiers;
	protected HashSet<InvokationPermit> invokePermits;
	protected HashSet<Object> convertedObjects;
	protected boolean valuesFromGetMethod;

	public ViConvertorConfig() {
		this.fieldModifiers = new HashSet<>();
		this.invokePermits = new HashSet<>();
		this.convertedObjects = new HashSet<>();
		valuesFromGetMethod = false;
	}

	public ViConvertorConfig(Collection<Integer> fieldModifiers, Collection<InvokationPermit> invokePermits,
			Collection<Object> convertedObjects) {
		this();
		this.fieldModifiers.addAll(fieldModifiers);
		this.invokePermits.addAll(invokePermits);
		this.convertedObjects.addAll(convertedObjects);
	}

	public boolean hasModifier(Integer modifier) {
		return fieldModifiers.contains(modifier);
	}

	public void addModifier(Integer modifier) {
		fieldModifiers.add(modifier);
	}

	public boolean hasPermit(InvokationPermit permit) {
		return invokePermits.contains(permit);
	}

	public void addPermit(InvokationPermit permit) {
		invokePermits.add(permit);
	}

	public boolean hasConverted(Object object) {
		return convertedObjects.contains(object);
	}

	public void addConverted(Object object) {
		convertedObjects.add(object);
	}

	public void resetConverted() {
		convertedObjects.clear();
	}

	public ViConvertorConfig clone() {
		return new ViConvertorConfig(fieldModifiers, invokePermits, convertedObjects);
	}
}
