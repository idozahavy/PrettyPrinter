package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PrettyConvertorUtils {

	public static boolean isPrimitive(Class<?> cls) {
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
	
	public static boolean hasToString(Class<?> cls) {
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals("toString")) {
				return true;
			}
		}
		return false;
	}
	
}
