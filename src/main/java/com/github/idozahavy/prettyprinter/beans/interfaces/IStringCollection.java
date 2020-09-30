package com.github.idozahavy.prettyprinter.beans.interfaces;

import java.util.Iterator;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans.SimpleString;

public interface IStringCollection extends IPrettyString, Iterable<IPrettyString> {

	void add(IPrettyString prettyString);

	int getItemCount();
	
	List<IPrettyString> getItems();
	
	SimpleString getFirst();

	@Override
	Iterator<IPrettyString> iterator();
}
