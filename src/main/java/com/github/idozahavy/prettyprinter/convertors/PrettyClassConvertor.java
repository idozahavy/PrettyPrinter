package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Field;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.beans.*;

public class PrettyClassConvertor {

	public static PrettyString convert(Object object, PrettyConvertorConfig convertorConfig, List<Object> objectList) {
		Class<?> objectClass = object.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		PrettyStringMap map = new PrettyStringMap();
		for (Field field : fields) {
			PrettyFieldString pfs = PrettyFieldConvertor.fieldToPrettyString(field, object, convertorConfig, objectList);
			if (pfs != null) {
				map.add(pfs);
			}
		}
		if (map.getRowCount() == -1) {
			return new AString(object.toString());
		}
		return map;
	}
}
