package com.github.idozahavy.prettyprinter.beans2;

import java.util.ArrayList;

import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringVerticalCollection;

public class OneStringCollection extends StringCollection
		implements IStringHorizontalCollection, IStringVerticalCollection {

	public OneStringCollection(IPrettyString prtStr) {
		items = new ArrayList<>();
		items.add(prtStr);
	}

	public String getValue() {
		if (getItemCount() == 1) {
			SimpleString simpleString = (SimpleString) items.get(0);
			if (simpleString != null) {
				return ((SimpleString) items.get(0)).getValue();
			}
		}
		return "";
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
}
