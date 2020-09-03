package com.github.idozahavy.prettyprinter.convertors.factory;

import java.util.Collection;

import com.github.idozahavy.prettyprinter.beans.StringCollection;
import com.github.idozahavy.prettyprinter.beans.StringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.StringVerticalCollection;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorConfig;

public class StringCollectionFactory {

	public static StringCollection createNew(Class<?> objectClass, PrettyConvertorConfig config) {
		// TODO check config data and make the appropriate collection
		if (objectClass.isArray() || objectClass.isNestmateOf(Collection.class)) {
			return new StringHorizontalCollection(objectClass);
		} else {
			return new StringVerticalCollection(objectClass);
		}
	}

}
