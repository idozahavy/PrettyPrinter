package com.github.idozahavy.prettyprinter.beans;

import java.util.ArrayList;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringVerticalCollection;

public class OneStringCollection extends StringCollection
		implements IStringHorizontalCollection, IStringVerticalCollection {
	
	public OneStringCollection(Object object) {
		super(object);
		throw new RuntimeException("no clazz constructor to OneStringCollection");
	}

	public OneStringCollection(IPrettyString prtStr) {
		super(String.class);
		items = new ArrayList<>();
		items.add(prtStr);
	}

	@Override
	public void add(IPrettyString prettyString) {
		if (getItemCount() == 0) {
			super.add(prettyString);
		}
	}

	@Override
	public int getWidth() {
		return items.get(0).getWidth();
	}

	@Override
	public int getHeight() {
		return items.get(0).getHeight();
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public IStringHorizontalCollection getRow(int row) {
		return this;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public IStringVerticalCollection getColumn(int column) {
		return this;
	}

	@Override
	public SimpleString getFirst() {
		return (SimpleString)items.get(0);
	}
}
