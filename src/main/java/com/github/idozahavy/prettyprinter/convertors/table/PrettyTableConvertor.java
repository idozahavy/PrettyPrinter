package com.github.idozahavy.prettyprinter.convertors.table;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.interfaces.IPrettyConvertor;

public class PrettyTableConvertor implements IPrettyConvertor<IPrettyString> {

	@Override
	public IPrettyString convert(IPrettyString object) {
		return convertTable(object);
	}
	
	public static IPrettyString convertTable(IPrettyString object) {
		// TODO Auto-generated method stub
		return null;
	}

}
