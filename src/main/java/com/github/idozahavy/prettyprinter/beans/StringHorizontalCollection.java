package com.github.idozahavy.prettyprinter.beans;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringVerticalCollection;

public class StringHorizontalCollection extends StringCollection implements IStringHorizontalCollection {

	public StringHorizontalCollection(Object object) {
		super(object);
	}

	@Override
	public int getWidth() {
		if (items==null)
			return 0;
		int width = 0;
		for (IPrettyString prettyString : items) {
			width += prettyString.getWidth();
		}
		return width;
	}

	@Override
	public int getHeight() {
		if (items==null)
			return 0;
		int height = 0;
		for (IPrettyString prettyString : items) {
			height = Math.max(prettyString.getHeight(), height);
		}
		return height;
	}

	@Override
	public int getRowCount() {
		if (items==null)
			return 0;
		int rowCount = 0;
		for (IPrettyString prettyString : items) {
			rowCount = Math.max(prettyString.getRowCount(), rowCount);
		}
		return rowCount;
	}

	@Override
	public IStringHorizontalCollection getRow(int row) {
		StringHorizontalCollection collection = new StringHorizontalCollection(object);
		if (items==null)
			return collection;
		for (IPrettyString prettyString : items) {
			collection.add(prettyString.getRow(row));
		}
		return collection;
	}

	@Override
	public int getColumnCount() {
		if (items==null)
			return 0;
		int columnCount = 0;
		for (IPrettyString prettyString : items) {
			columnCount += prettyString.getColumnCount();
		}
		return columnCount;
	}

	@Override
	public IStringVerticalCollection getColumn(int column) {
		// TOCHECK Need To Check
		if (items==null)
			return new EmptyStringCollection();
		int columnsPassed = 0;
		for (IPrettyString prettyString : items) {
			if (columnsPassed + prettyString.getColumnCount() > column) {
				StringVerticalCollection collection = new StringVerticalCollection(object);
				collection.add(prettyString.getColumn(column - columnsPassed));
				while (collection.getRowCount()<this.getRowCount()) {
					collection.add(new SimpleString(""));
				}
				return collection;
			}
			columnsPassed += prettyString.getColumnCount();
		}
		StringVerticalCollection emptyVerticalCollection = new StringVerticalCollection(null);
		for (int i = 0; i < this.getRowCount(); i++) {
			emptyVerticalCollection.add(new SimpleString(""));
		}
		return emptyVerticalCollection;
	}
}
