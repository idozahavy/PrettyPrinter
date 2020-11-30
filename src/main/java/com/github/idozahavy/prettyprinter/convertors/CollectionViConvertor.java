package com.github.idozahavy.prettyprinter.convertors;

import java.util.Collection;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.factory.ViCollectionFactory;

public class CollectionViConvertor extends ViConvertor<Collection<?>> {

	public CollectionViConvertor(ViConvertorConfig config) {
		super(config);
	}

	@Override
	public ViObject convert(Collection<?> object) {
		return convert(object, config);
	}

	public static ViObject convert(Collection<?> object, ViConvertorConfig config) {
		ViCollection collection = ViCollectionFactory.createNew(object.getClass(), config);
		for (Object objectItem : object) {
			collection.push(ObjectViConvertor.convert(objectItem, config));
		}
		return collection;
	}

}
