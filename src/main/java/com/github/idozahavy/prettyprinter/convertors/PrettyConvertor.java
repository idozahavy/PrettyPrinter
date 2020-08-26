package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.*;
import com.github.idozahavy.prettyprinter.beans.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PrettyConvertor {
	private PrettyConvertorConfig convertorConfig;

	public PrettyString convert(Object object) {
		return convert(object, this.convertorConfig, new ArrayList<>());
	}

	public static PrettyString convert(Object object, PrettyConvertorConfig convertorConfig) {
		return convert(object, convertorConfig, new ArrayList<>());
	}
	
	public static PrettyString convert(Object object, PrettyConvertorConfig convertorConfig, List<Object> objectList) {
		if (object == null) {
			return new AString("[null]");
		}
		if (objectList.contains(object)) {
			return new AString("[Recursive] " + object.getClass().getName());
		}
		Class<?> objectClass = object.getClass();
		objectList.add(object);

		if (isPrimitive(objectClass) || (convertorConfig.isInvokeToString() && hasToString(objectClass))) {
			return new AString(object.toString());
		} else if (objectClass.isArray()) {
			return arrayToPrettyStrings(object, convertorConfig,objectList);
		} else if (object instanceof Collection<?>) {
			return collectionToPrettyStrings((Collection<?>) object, convertorConfig,objectList);
		} else {
			return PrettyClassConvertor.convert(object, convertorConfig, objectList);
		}
	}

	private static boolean isPrimitive(Class<?> cls) {
		if (cls.isPrimitive() || cls.isEnum()) {
			return true;
		}
		List<Class<?>> primClasses = new ArrayList<Class<?>>();
		primClasses.add(Integer.class);
		primClasses.add(Float.class);
		primClasses.add(Double.class);
		primClasses.add(String.class);
		primClasses.add(Boolean.class);

		for (Class<?> primClass : primClasses) {
			if (primClass.equals(cls)) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasToString(Class<?> cls) {
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName() == "toString") {
				return true;
			}
		}
		return false;
	}

	private static PrettyStringMap arrayToPrettyStrings(Object array, PrettyConvertorConfig convertorConfig, List<Object> objectList) {
		PrettyStringMap map = new PrettyStringMap();
		for (int i = 0; i < Array.getLength(array); i++) {
			Object arrObject = Array.get(array, i);
			PrettyFieldString pfs = new PrettyFieldString(String.valueOf(i), convert(arrObject, convertorConfig,objectList));
			map.add(pfs);
		}
		return map;
	}

	private static PrettyStringMap collectionToPrettyStrings(Collection<?> collection,
			PrettyConvertorConfig convertorConfig,List<Object>objectList) {
		PrettyStringMap prtMap = new PrettyStringMap();
		for (Object object2 : collection) {
			prtMap.add(convert(object2, convertorConfig,objectList));
		}
		return prtMap;
	}
}
