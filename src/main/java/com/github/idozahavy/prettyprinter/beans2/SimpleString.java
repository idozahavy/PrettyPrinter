package com.github.idozahavy.prettyprinter.beans2;

public class SimpleString implements PrettyString2 {

	private String value;

	@Override
	public int getWidth() {
		return value != null ? value.length() : 0;
	}

	@Override
	public int getHeight() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public StringCollection getRow(int row) {
		return row == 0 ? new OneStringCollection(this) : null;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public StringCollection getColumn(int column) {
		return column == 0 ? new OneStringCollection(this) : null;
	}
}
