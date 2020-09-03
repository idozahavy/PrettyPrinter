package com.github.idozahavy.prettyprinter.beans;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringVerticalCollection;

public class StringVerticalCollection extends StringCollection implements IStringVerticalCollection {

	public StringVerticalCollection(Object object) {
		super(object);
	}

	@Override
	public int getWidth() {
		if (items==null)
			return 0;
		int width = 0;
		for (IPrettyString prettyString : items) {
			width = Math.max(prettyString.getWidth(), width);
		}
		return width;
	}

	@Override
	public int getHeight() {
		if (items==null)
			return 0;
		int width = 0;
		for (IPrettyString prettyString : items) {
			width += prettyString.getWidth();
		}
		return width;
	}

	@Override
	public int getRowCount() {
		if (items==null)
			return 0;
		int rowCount = 0;
		for (IPrettyString prettyString : items) {
			rowCount += prettyString.getRowCount();
		}
		return rowCount;
	}

	@Override
	public IStringHorizontalCollection getRow(int row) {
		// TOCHECK Need To Check
		if (items==null)
			return new EmptyStringCollection();
		int rowsPassed = 0;
		for (IPrettyString prettyString : items) {
			if (rowsPassed + prettyString.getRowCount() > row) {
				StringHorizontalCollection collection = new StringHorizontalCollection(object);
				collection.add(prettyString.getRow(row - rowsPassed));
				return collection;
			}
			rowsPassed += prettyString.getRowCount();
		}
		return new EmptyStringCollection();
	}

	@Override
	public int getColumnCount() {
		if (items==null)
			return 0;
		int columnCount = 0;
		for (IPrettyString prettyString : items) {
			columnCount = Math.max(prettyString.getColumnCount(), columnCount);
		}
		return columnCount;
	}

	@Override
	public IStringVerticalCollection getColumn(int column) {
		StringVerticalCollection collection = new StringVerticalCollection(object);
		if (items==null)
			return collection;
		for (IPrettyString prettyString : items) {
			collection.add(prettyString.getColumn(column));
		}
		return collection;
	}
}
