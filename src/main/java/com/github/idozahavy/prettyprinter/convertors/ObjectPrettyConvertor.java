package com.github.idozahavy.prettyprinter.convertors;

import java.util.Collection;

import com.github.idozahavy.prettyprinter.beans.SimpleString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.config.InvokePermit;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorUtils;

public final class ObjectPrettyConvertor extends PrettyConvertor<Object> {

	public ObjectPrettyConvertor(PrettyConvertorConfig config) {
		super(config);
	}

	public IPrettyString convert(Object object) {
		return convert(object, config);
	}

	public static IPrettyString convert(Object object, PrettyConvertorConfig config) {
		if (object == null) {
			return new SimpleString("[null]");
		}
		Class<?> objectClass = object.getClass();

		if (PrettyConvertorUtils.isPrimitive(objectClass)
				|| (config.hasPermit(InvokePermit.ToString) && PrettyConvertorUtils.hasToString(objectClass))) {
			return new SimpleString(object.toString());
		}

		if (config.hasConverted(object)) {
			return new SimpleString("[Recursive] " + objectClass.getName());
		} else {
			config.addConverted(object);
		}

		if (objectClass.isArray()) {
			return ArrayPrettyConvertor.convert(object, config);
		} else if (object instanceof Collection<?>) {
			return CollectionPrettyConvertor.convert((Collection<?>) object, config);
		} else {
			return ClassPrettyConvertor.convert(object, config);
		}
	}
}
