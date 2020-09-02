package com.github.idozahavy.prettyprinter.convertors;

import java.util.Collection;

import com.github.idozahavy.prettyprinter.beans2.StringCollection;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.factory.StringCollectionFactory;

public class CollectionPrettyConvertor extends PrettyConvertor<Collection<?>> {

	public CollectionPrettyConvertor(PrettyConvertorConfig config) {
		super(config);
	}

	@Override
	public IPrettyString convert(Collection<?> object) {
		return convert(object, config);
	}

	public static IPrettyString convert(Collection<?> object, PrettyConvertorConfig config) {
		StringCollection collection = StringCollectionFactory.createNew(object.getClass(), config);
		for (Object objectItem : object) {
			collection.add(ObjectPrettyConvertor.convert(objectItem, config));
		}
		return collection;
	}

}
