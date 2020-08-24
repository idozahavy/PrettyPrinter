package com.github.idozahavy.prettyprinter.core;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.*;
import com.github.idozahavy.prettyprinter.string.beans.*;

public class PrettyPrint {
	public static PrettyString toPrettyStrings(Object object, PrettyAccessor accessor, boolean overrideToString) {
		Class<?> objectClass = object.getClass();

		if (isPrimitive(objectClass) || (!overrideToString && hasToString(objectClass))) {
			return new AString(object.toString());
		} else if (objectClass.isArray()) {
			return arrayToPrettyStrings(object, accessor, overrideToString);
		} else if (object instanceof Collection<?>) {
			return collectionToPrettyStrings(object, accessor, overrideToString);
		} else {
			return classToPrettyString(object, accessor, overrideToString);
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

	/***
	 * Object class reflection to PrettyStringMap
	 * 
	 * @param object
	 * @return
	 */
	private static PrettyString classToPrettyString(Object object, PrettyAccessor accessor, boolean overrideToString) {
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
				fieldPrettyString = toPrettyStrings(field.get(object), accessor, overrideToString);
			} catch (IllegalAccessException | IllegalArgumentException e) {
				e.printStackTrace();
				fieldPrettyString = new AString("[unaccessable]");
			}
			PrettyFieldString pfs = new PrettyFieldString(fieldName, fieldPrettyString);
			map.add(pfs);
		}
		if (map.getRowCount() == -1) {
			return new AString(object.toString());
		}
		return map;
		// TODO Class Name Header
	}

	public static void println(Object object) {
		println(object, PrettyAccessor.Public, false, PrettyConfig.defaultConfig);
	}

	public static void println(Object object, PrettyAccessor accessor) {
		println(object, accessor, false, PrettyConfig.defaultConfig);
	}

	public static void println(Object object, PrettyConfig config) {
		println(object, PrettyAccessor.Public, false, config);
	}

	public static void println(Object object, boolean overrideToString) {
		println(object, PrettyAccessor.Public, overrideToString, PrettyConfig.defaultConfig);
	}

	public static void println(Object object, boolean overrideToString, PrettyConfig config) {
		println(object, PrettyAccessor.Public, overrideToString, config);
	}

	public static void println(Object object, PrettyAccessor accessor, PrettyConfig config) {
		println(object, accessor, false, config);
	}

	public static void println(Object object, PrettyAccessor accessor, boolean overrideToString) {
		println(object, accessor, overrideToString, PrettyConfig.defaultConfig);
	}

	public static void println(Object object, PrettyAccessor accessor, boolean overrideToString, PrettyConfig config) {
		PrettyString str = toPrettyStrings(object, accessor, overrideToString);
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

	private static PrettyStringMap arrayToPrettyStrings(Object object, PrettyAccessor accessor,
			boolean overrideToString) {
		PrettyStringMap map = new PrettyStringMap();
		for (int i = 0; i < Array.getLength(object); i++) {
			Object arrObject = Array.get(object, i);
			PrettyFieldString pfs = new PrettyFieldString(String.valueOf(i),
					toPrettyStrings(arrObject, accessor, overrideToString));
			map.add(pfs);
		}
		return map;
	}

	private static PrettyStringMap collectionToPrettyStrings(Object object, PrettyAccessor accessor,
			boolean overrideToString) {
		Collection<?> coll = (Collection<?>) object;
		PrettyStringMap prtMap = new PrettyStringMap();
		for (Object object2 : coll) {
			prtMap.add(toPrettyStrings(object2, accessor, overrideToString));
		}
		return prtMap;
	}
}
