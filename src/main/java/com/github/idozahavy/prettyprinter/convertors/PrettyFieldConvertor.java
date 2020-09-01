package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import com.github.idozahavy.prettyprinter.annotations.*;
import com.github.idozahavy.prettyprinter.config.*;
import com.github.idozahavy.prettyprinter.beans.*;

public class PrettyFieldConvertor {
	public static PrettyFieldString fieldToPrettyString(Field field, Object object,
			PrettyConvertorConfig convertorConfig, List<Object> objectList) {
		String fieldName = getFieldHeader(field);
		PrettyString fieldValue = getFieldValue(field, object, convertorConfig, objectList);
		if (fieldValue == null) {
			return null;
		}
		return new PrettyFieldString(fieldName, fieldValue);
	}

	private static String getFieldHeader(Field field) {
		if (field.isAnnotationPresent(PrettyHeader.class)) {
			PrettyHeader headerAnno = field.getDeclaredAnnotation(PrettyHeader.class);
			return headerAnno.value();
		}
		return field.getName();
	}

	private static PrettyString getFieldValue(Field field, Object object, PrettyConvertorConfig convertorConfig,List<Object> objectList) {

		if (field.isAnnotationPresent(PrettyCensored.class)) {
			return null;
		}
		if (field.isAnnotationPresent(PrettyValueCensored.class)) {
			return new AString(PrettyValueCensored.value);
		}

		if (Modifier.isStatic(field.getModifiers())) {
			if (convertorConfig.isRetrieveStaticFields()) {
				object = null;
			} else {
				return null;
			}
		}
		
		if (Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
		
		if (Modifier.isPrivate(field.getModifiers())) {
			if (convertorConfig.getAccessor() == PrettyAccessor.Private) {
				field.setAccessible(true);
			} else {
				return null;
			}
		}

		try {
			return PrettyConvertor.convert(field.get(object), convertorConfig, objectList);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			return new AString("[Inaccessable Field]");
		}
	}
}
