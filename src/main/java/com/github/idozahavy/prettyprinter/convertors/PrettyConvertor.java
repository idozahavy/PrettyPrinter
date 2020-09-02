package com.github.idozahavy.prettyprinter.convertors;

import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.interfaces.IPrettyConvertor;

public abstract class PrettyConvertor<ConvertorType> implements IPrettyConvertor<ConvertorType> {
	protected PrettyConvertorConfig config;
	
	public PrettyConvertor(PrettyConvertorConfig config) {
		this.config = config;
	}
	
	public abstract IPrettyString convert(ConvertorType object);
}
