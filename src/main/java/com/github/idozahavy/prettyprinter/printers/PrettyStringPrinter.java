package com.github.idozahavy.prettyprinter.printers;

import com.github.idozahavy.prettyprinter.beans.SimpleString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringVerticalCollection;

public class PrettyStringPrinter extends PrettyPrinter {

	public PrettyStringPrinter(PrettyPrinterConfig config) {
		super(config);
	}

	@Override
	public void println(IPrettyString prettyString) {
		printfln(prettyString, config);
	}

	@Override
	public void printfln(IPrettyString prettyString, PrettyPrinterConfig config) {

		int columnCount = prettyString.getColumnCount();
		int[] columnWidths = new int[columnCount];
		for (int i = 0; i < columnCount; i++) {
			IStringVerticalCollection column = prettyString.getColumn(i);
			columnWidths[i] = column.getWidth();
		}

		int rowCount = prettyString.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			StringBuilder builder = new StringBuilder(config.getLeftString());
			IStringHorizontalCollection row = prettyString.getRow(rowIndex);
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				SimpleString str = row.getColumn(columnIndex).getFirst();
				String paddedStr = PrettyPrinterUtils.padCenter(str.getValue(), columnWidths[columnIndex], ' ');
				builder.append(paddedStr);
				if (columnIndex != columnCount - 1) {
					builder.append(config.getItemSeperatorString());
				}
			}
			builder.append(config.getRightString());
			System.out.println(builder);
		}
		int aaa = 0;
	}

	@Override
	public void print(IPrettyString prettyString, int row) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printf(IPrettyString prettyString, int row, PrettyPrinterConfig config) {
		// TODO Auto-generated method stub

	}

}