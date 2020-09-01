package com.github.idozahavy.prettyprinter.beans2;

public interface PrettyString2 {

	int getWidth();
	int getHeight();
	
	int getRowCount();
	StringCollection getRow(int row);
	
	int getColumnCount();
	StringCollection getColumn(int column);
}
