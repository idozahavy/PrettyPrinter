package com.github.idozahavy.prettyprinter.convertors.interfaces;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;

public interface IPrettyConvertor<ConvertorType> {
	
	IPrettyString convert(ConvertorType object);
	
}
