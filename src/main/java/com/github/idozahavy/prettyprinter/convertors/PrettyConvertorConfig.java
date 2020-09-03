package com.github.idozahavy.prettyprinter.convertors;

import java.util.Collection;
import java.util.HashSet;

import com.github.idozahavy.prettyprinter.config.InvokePermit;

import lombok.Data;

@Data
public class PrettyConvertorConfig implements Cloneable {

	protected HashSet<Integer> fieldModifiers;
	protected HashSet<InvokePermit> invokePermits;
	protected HashSet<Object> convertedObjects;

	public PrettyConvertorConfig() {
		this.fieldModifiers = new HashSet<>();
		this.invokePermits = new HashSet<>();
		this.convertedObjects = new HashSet<>();
	}

	public PrettyConvertorConfig(Collection<Integer> fieldModifiers, Collection<InvokePermit> invokePermits,
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

	public boolean hasPermit(InvokePermit permit) {
		return invokePermits.contains(permit);
	}

	public void addPermit(InvokePermit permit) {
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

	public PrettyConvertorConfig clone() {
		return new PrettyConvertorConfig(fieldModifiers, invokePermits, convertedObjects);
	}
}
