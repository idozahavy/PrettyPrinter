package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.github.idozahavy.prettyprinter.annotations.*;
import com.github.idozahavy.prettyprinter.beans.SimpleString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;

public class FieldPrettyConvertor {
	public static IPrettyString convert(Field field, Object object, PrettyConvertorConfig convertorConfig) {
		IPrettyString fieldPrettyString = getFieldValue(field, object, convertorConfig);
		if (fieldPrettyString == null) {
			return null;
		}
		return fieldPrettyString;
	}

	//TODO use this
	@SuppressWarnings("unused")
	private static String getFieldHeader(Field field) {
		if (field.isAnnotationPresent(PrettyHeader.class)) {
			PrettyHeader headerAnno = field.getDeclaredAnnotation(PrettyHeader.class);
			return headerAnno.value();
		}
		return field.getName();
	}

	private static IPrettyString getFieldValue(Field field, Object object, PrettyConvertorConfig config) {

		if (field.isAnnotationPresent(PrettyCensored.class)) {
			return null;
		}
		if (field.isAnnotationPresent(PrettyValue.class)) {
			return new SimpleString(field.getAnnotation(PrettyValue.class).value());
		}

		if (Modifier.isStatic(field.getModifiers())) {
			if (config.hasModifier(Modifier.STATIC)) {
				object = null;
			} else {
				return null;
			}
		}

		if (Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
		// TODO make a better way to check modifiers
		if (Modifier.isPrivate(field.getModifiers())) {
			if (config.hasModifier(Modifier.PRIVATE)) {
				field.setAccessible(true);
			} else {
				return null;
			}
		}

		try {
			// TODO need to create a collection with field name
			return ObjectPrettyConvertor.convert(field.get(object), config);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			return new SimpleString("[Inaccessable Field]");
		}
	}
}
