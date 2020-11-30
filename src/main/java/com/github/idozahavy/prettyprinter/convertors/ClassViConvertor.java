package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Field;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.convertors.interfaces.IViConvertor;
import com.github.idozahavy.prettyprinter.factory.ViCollectionFactory;


public class ClassViConvertor implements IViConvertor<Object> {

	private ViConvertorConfig config;

	@Override
	public ViObject convert(Object object) {
		return convert(object, config);
	}

	//TODO add from get methods option
	
	public static ViObject convert(Object object, ViConvertorConfig config) {
		Class<?> objectClass = object.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		ViCollection collection = ViCollectionFactory.createNew(objectClass, config);
		for (Field field : fields) {
			ViObject fieldPrettyString = FieldViConvertor.convert(field, object, config);
			if (fieldPrettyString != null) {
				collection.push(fieldPrettyString);
			}
		}
		return collection;
	}
}
