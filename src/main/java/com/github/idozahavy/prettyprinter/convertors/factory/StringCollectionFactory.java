package com.github.idozahavy.prettyprinter.convertors.factory;

import com.github.idozahavy.prettyprinter.beans2.StringCollection;
import com.github.idozahavy.prettyprinter.beans2.StringHorizontalCollection;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorConfig;

public class StringCollectionFactory {

	public static StringCollection createNew(Class<?> objectsClass, PrettyConvertorConfig config) {
		//TODO check config data and make the appropriate collection
		return new StringHorizontalCollection(objectsClass.getName());
	}
	
}
