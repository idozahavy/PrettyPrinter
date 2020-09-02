package com.github.idozahavy.prettyprinter.beans2;

import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringVerticalCollection;

public class StringHorizontalCollection extends StringCollection implements IStringHorizontalCollection {

	public StringHorizontalCollection(String name) {
		this.name = name;
	}

	@Override
	public int getWidth() {
		int width = 0;
		for (IPrettyString prettyString : items) {
			width += prettyString.getWidth();
		}
		return width;
	}

	@Override
	public int getHeight() {
		int height = 0;
		for (IPrettyString prettyString : items) {
			height = Math.max(prettyString.getHeight(), height);
		}
		return height;
	}

	@Override
	public int getRowCount() {
		int rowCount = 0;
		for (IPrettyString prettyString : items) {
			rowCount = Math.max(prettyString.getRowCount(), rowCount);
		}
		return rowCount;
	}

	@Override
	public IStringHorizontalCollection getRow(int row) {
		StringHorizontalCollection collection = new StringHorizontalCollection(name);
		for (IPrettyString prettyString : items) {
			collection.add(prettyString.getRow(row));
		}
		return collection;
	}

	@Override
	public int getColumnCount() {
		int columnCount = 0;
		for (IPrettyString prettyString : items) {
			columnCount += prettyString.getColumnCount();
		}
		return columnCount;
	}

	@Override
	public IStringVerticalCollection getColumn(int column) {
		// TOCHECK Need To Check
		int columnsPassed = 0;
		for (IPrettyString prettyString : items) {
			if (columnsPassed + prettyString.getColumnCount() > column) {
				StringVerticalCollection collection = new StringVerticalCollection(name);
				collection.add(prettyString.getColumn(column - columnsPassed));
				return collection;
			}
			columnsPassed += prettyString.getColumnCount();
		}
		return new EmptyStringCollection();
	}
}
