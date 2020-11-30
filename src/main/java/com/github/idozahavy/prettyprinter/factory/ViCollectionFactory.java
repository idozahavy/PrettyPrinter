package com.github.idozahavy.prettyprinter.factory;

import java.util.Collection;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.enums.ViCollectionType;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;

public class ViCollectionFactory {

	public static ViCollection createNew(Class<?> objectClass, ViConvertorConfig config) {
		// TODO check config data and make the appropriate collection
		if (objectClass.isArray() || objectClass.isNestmateOf(Collection.class)) {
			return new ViCollection(objectClass, ViCollectionType.Vertical);
		} else {
			return new ViCollection(objectClass, ViCollectionType.Horizontal);
		}
	}

}
