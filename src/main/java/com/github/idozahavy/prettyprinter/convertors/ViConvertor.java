package com.github.idozahavy.prettyprinter.convertors;

import com.github.idozahavy.prettyprinter.convertors.interfaces.IViConvertor;

public abstract class ViConvertor<ConvertorType> implements IViConvertor<ConvertorType> {
	protected ViConvertorConfig config;
	
	public ViConvertor(ViConvertorConfig config) {
		this.config = config;
	}
}
