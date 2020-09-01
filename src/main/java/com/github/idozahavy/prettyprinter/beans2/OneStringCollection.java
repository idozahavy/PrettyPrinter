package com.github.idozahavy.prettyprinter.beans2;

import java.util.ArrayList;

public class OneStringCollection extends StringCollection {

	public OneStringCollection(PrettyString2 prtStr) {
		items = new ArrayList<PrettyString2>();
		items.add(prtStr);
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
	public StringCollection getRow(int row) {
		return this;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public StringCollection getColumn(int column) {
		return this;
	}
}
