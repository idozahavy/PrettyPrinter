package com.idozah.prettyprinter.core;

import java.lang.reflect.*;
import java.util.Collection;

import com.idozah.prettyprinter.config.*;
import com.idozah.prettyprinter.string.beans.*;

public class PrettyPrint {
	public static PrettyString toPrettyStrings(Object object, PrettyAccessor accessor) {
		Class<?> objectClass = object.getClass();

		if (objectClass.isPrimitive() || hasToString(objectClass)) {
			return new AString(object.toString());
		} else if (objectClass.isArray()) {
			return arrayToPrettyStrings(object, accessor);
		} else if (object instanceof Collection<?>) {
			return collectionToPrettyStrings(object, accessor);
		} else {
			return classToPrettyString(object, accessor);
		}
	}

	/***
	 * Object class reflection to PrettyStringMap
	 * 
	 * @param object
	 * @return
	 */
	private static PrettyString classToPrettyString(Object object, PrettyAccessor accessor) {
		Class<?> objectClass = object.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		PrettyStringMap map = new PrettyStringMap();
		for (Field field : fields) {
			if (Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			if (!field.canAccess(object)) {
				if (accessor == PrettyAccessor.Private) {
					field.setAccessible(true);
				} else {
					continue;
				}
			}
			String fieldName = field.getName();
			PrettyString fieldPrettyString = null;
			try {
				fieldPrettyString = toPrettyStrings(field.get(object), accessor);
			} catch (IllegalAccessException | IllegalArgumentException e) {
				e.printStackTrace();
				fieldPrettyString = new AString("[unaccessable]");
			}
			PrettyFieldString pfs = new PrettyFieldString(fieldName, fieldPrettyString);
			map.add(pfs);
		}
		return map;
	}

	public static void println(Object object) {
		println(object, PrettyAccessor.Public);
	}

	public static void println(Object object, PrettyAccessor accessor) {
		PrettyString str = toPrettyStrings(object, accessor);
		System.out.println(str);
	}

	public static void println(Object object, PrettyConfig config) {
		println(object, PrettyAccessor.Public, config);
	}

	public static void println(Object object, PrettyAccessor accessor, PrettyConfig config) {
		PrettyString str = toPrettyStrings(object, accessor);
		System.out.println(str.toString(config));
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

	private static PrettyStringMap arrayToPrettyStrings(Object object, PrettyAccessor accessor) {
		PrettyStringMap map = new PrettyStringMap();
		for (int i = 0; i < Array.getLength(object); i++) {
			Object arrObject = Array.get(object, i);
			PrettyFieldString pfs = new PrettyFieldString(String.valueOf(i), toPrettyStrings(arrObject, accessor));
			map.add(pfs);
		}
		return map;
	}

	private static PrettyStringMap collectionToPrettyStrings(Object object, PrettyAccessor accessor) {
		Collection<?> coll = (Collection<?>) object;
		PrettyStringMap prtMap = new PrettyStringMap();
		for (Object object2 : coll) {
			prtMap.add(toPrettyStrings(object2, accessor));
		}
		return prtMap;
	}
}
