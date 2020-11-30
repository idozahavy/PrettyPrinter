package com.github.idozahavy.prettyprinter.convertors.interfaces;

import com.github.idozahavy.prettyprinter.beans.ViObject;

public interface IViConvertor<ConvertorType> {
	
	ViObject convert(ConvertorType object);
	
}
