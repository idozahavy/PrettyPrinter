package com.github.idozahavy.prettyprinter.beans2;

public class StringHorizontalCollection extends StringCollection {

	@Override
	public int getWidth() {
		int width = 0;
		for (PrettyString2 prettyString : items) {
			width += prettyString.getWidth();
		}
		return width;
	}

	@Override
	public int getHeight() {
		int height = 0;
		for (PrettyString2 prettyString : items) {
			height = Math.max(prettyString.getHeight(), height);
		}
		return height;
	}

	@Override
	public int getRowCount() {
		int rowCount = 0;
		for (PrettyString2 prettyString : items) {
			rowCount = Math.max(prettyString.getRowCount(), rowCount);
		}
		return rowCount;
	}

	@Override
	public StringCollection getRow(int row) {
		StringHorizontalCollection collection = new StringHorizontalCollection();
		for (PrettyString2 prettyString : items) {
			collection.add(prettyString.getRow(row));
		}
		return collection;
	}

	@Override
	public int getColumnCount() {
		int columnCount = 0;
		for (PrettyString2 prettyString : items) {
			columnCount += prettyString.getColumnCount();
		}
		return columnCount;
	}

	@Override
	public StringCollection getColumn(int column) {
		return new OneStringCollection(items.get(column));
	}
}
