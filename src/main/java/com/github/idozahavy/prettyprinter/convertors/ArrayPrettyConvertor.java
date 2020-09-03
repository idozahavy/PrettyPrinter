package com.github.idozahavy.prettyprinter.convertors;

import java.lang.reflect.Array;

import com.github.idozahavy.prettyprinter.beans.StringCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.factory.StringCollectionFactory;

public class ArrayPrettyConvertor extends PrettyConvertor<Object> {

	public ArrayPrettyConvertor(PrettyConvertorConfig config) {
		super(config);
	}

	@Override
	public IPrettyString convert(Object object) {
		return convert(object, config);
	}

	public static IPrettyString convert(Object array, PrettyConvertorConfig convertorConfig) {
		StringCollection collection = StringCollectionFactory.createNew(array.getClass(), convertorConfig);
		// TODO check config for array format (0:'123', 1:'423') or ('123', '423')
		for (int i = 0; i < Array.getLength(array); i++) {
			Object arrObject = Array.get(array, i);
			collection.add(ObjectPrettyConvertor.convert(arrObject, convertorConfig));
		}
		return collection;
	}
}
