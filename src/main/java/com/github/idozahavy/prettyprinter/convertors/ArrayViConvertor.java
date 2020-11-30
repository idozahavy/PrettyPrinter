package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Array;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.factory.ViCollectionFactory;

public class ArrayViConvertor extends ViConvertor<Object> {

	public ArrayViConvertor(ViConvertorConfig config) {
		super(config);
	}

	@Override
	public ViObject convert(Object object) {
		return convert(object, config);
	}

	public static ViObject convert(Object array, ViConvertorConfig convertorConfig) {
		ViCollection collection = ViCollectionFactory.createNew(array.getClass(), convertorConfig);
		// TODO check config for array format (0:'123', 1:'423') or ('123', '423')
		for (int i = 0; i < Array.getLength(array); i++) {
			Object arrObject = Array.get(array, i);
			collection.push(ObjectViConvertor.convert(arrObject, convertorConfig));
		}
		return collection;
	}
}
