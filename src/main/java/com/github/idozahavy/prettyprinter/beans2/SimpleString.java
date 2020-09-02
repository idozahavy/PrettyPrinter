package com.github.idozahavy.prettyprinter.beans2;

import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringVerticalCollection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SimpleString implements IPrettyString {

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
	public IStringHorizontalCollection getRow(int row) {
		return row == 0 ? new OneStringCollection(this) : new EmptyStringCollection();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public IStringVerticalCollection getColumn(int column) {
		return column == 0 ? new OneStringCollection(this) : new EmptyStringCollection();
	}
}
