package com.github.idozahavy.prettyprinter.beans2.interfaces;

import java.util.Iterator;

public interface IStringCollection extends IPrettyString, Iterable<IPrettyString> {

	void add(IPrettyString prettyString);

	int getItemCount();

	@Override
	Iterator<IPrettyString> iterator();
}
