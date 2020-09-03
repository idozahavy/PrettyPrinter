package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Field;

import com.github.idozahavy.prettyprinter.convertors.factory.StringCollectionFactory;
import com.github.idozahavy.prettyprinter.convertors.interfaces.IPrettyConvertor;
import com.github.idozahavy.prettyprinter.beans.StringCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;

public class ClassPrettyConvertor implements IPrettyConvertor<Object> {

	private PrettyConvertorConfig config;

	@Override
	public IPrettyString convert(Object object) {
		return convert(object, config);
	}

	public static IPrettyString convert(Object object, PrettyConvertorConfig config) {
		Class<?> objectClass = object.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		StringCollection collection = StringCollectionFactory.createNew(objectClass, config);
		for (Field field : fields) {
			IPrettyString fieldPrettyString = FieldPrettyConvertor.convert(field, object, config);
			if (fieldPrettyString != null) {
				collection.add(fieldPrettyString);
			}
		}
		return collection;
	}
}
