package com.github.idozahavy.prettyprinter.convertors;

import java.util.Collection;

import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.beans.ViString;
import com.github.idozahavy.prettyprinter.config.InvokationPermit;

public final class ObjectViConvertor extends ViConvertor<Object> {

	public ObjectViConvertor(ViConvertorConfig config) {
		super(config);
	}

	public ViObject convert(Object object) {
		return convert(object, config);
	}

	public static ViObject convert(Object object, ViConvertorConfig config) {
		if (object == null) {
			return new ViString("[null]");
		}
		Class<?> objectClass = object.getClass();

		if (PrettyConvertorUtils.isPrimitive(objectClass)
				|| (config.hasPermit(InvokationPermit.ToString) && PrettyConvertorUtils.hasToString(objectClass))) {
			return new ViString(object.toString());
		}

		if (config.hasConverted(object)) {
			return new ViString("[Recursive] " + objectClass.getName());
		} else {
			config.addConverted(object);
		}

		if (objectClass.isArray()) {
			return ArrayViConvertor.convert(object, config);
		} else if (object instanceof Collection<?>) {
			return CollectionViConvertor.convert((Collection<?>) object, config);
		} else {
			return ClassViConvertor.convert(object, config);
		}
	}
}
