package com.github.idozahavy.prettyprinter.beans2.interfaces;

public interface IPrettyString {

	int getWidth();
	int getHeight();
	
	int getRowCount();
	IStringHorizontalCollection getRow(int row);
	
	int getColumnCount();
	IStringVerticalCollection getColumn(int column);
}
