package com.github.idozahavy.prettyprinter.beans2;

import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringVerticalCollection;

public class StringVerticalCollection extends StringCollection implements IStringVerticalCollection {

	public StringVerticalCollection(String name) {
		this.name = name;
	}

	@Override
	public int getWidth() {
		int width = 0;
		for (IPrettyString prettyString : items) {
			width = Math.max(prettyString.getWidth(), width);
		}
		return width;
	}

	@Override
	public int getHeight() {
		int width = 0;
		for (IPrettyString prettyString : items) {
			width += prettyString.getWidth();
		}
		return width;
	}

	@Override
	public int getRowCount() {
		int rowCount = 0;
		for (IPrettyString prettyString : items) {
			rowCount += prettyString.getRowCount();
		}
		return rowCount;
	}

	@Override
	public IStringHorizontalCollection getRow(int row) {
		// TOCHECK Need To Check
		int rowsPassed = 0;
		for (IPrettyString prettyString : items) {
			if (rowsPassed + prettyString.getRowCount() > row) {
				StringHorizontalCollection collection = new StringHorizontalCollection(name);
				collection.add(prettyString.getRow(row - rowsPassed));
				return collection;
			}
			rowsPassed += prettyString.getRowCount();
		}
		return new EmptyStringCollection();
	}

	@Override
	public int getColumnCount() {
		int columnCount = 0;
		for (IPrettyString prettyString : items) {
			columnCount = Math.max(prettyString.getColumnCount(), columnCount);
		}
		return columnCount;
	}

	@Override
	public IStringVerticalCollection getColumn(int column) {
		StringVerticalCollection collection = new StringVerticalCollection(name);
		for (IPrettyString prettyString : items) {
			collection.add(prettyString.getColumn(column));
		}
		return collection;
	}
}
