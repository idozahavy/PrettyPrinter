package com.github.idozahavy.prettyprinter.printers;

import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans.OneStringCollection;
import com.github.idozahavy.prettyprinter.beans.SimpleString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringCollection;
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
//		int[] columnWidths = new int[columnCount];
//		for (int i = 0; i < columnCount; i++) {
//			IStringVerticalCollection column = prettyString.getColumn(i);
//			columnWidths[i] = column.getWidth();
//		}
		// TODO recursive get rows string

		int rowCount = prettyString.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			StringBuilder builder = new StringBuilder(config.getLeftString());
			IStringHorizontalCollection row = prettyString.getRow(rowIndex);
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				IStringVerticalCollection column = prettyString.getColumn(columnIndex);
				SimpleString str = row.getColumn(columnIndex).getFirst();
//				String paddedStr = PrettyPrinterUtils.padCenter(str.getValue(), columnWidths[columnIndex], ' ');
				String paddedStr = PrettyPrinterUtils.padCenter(str.getValue(), column.getWidth(), ' ');
//				builder.append(paddedStr);
				
				if (columnIndex != columnCount - 1) {
//					builder.append(config.getItemSeperatorString());
				}
			}
			builder.append(getRowString(row, config));
			builder.append(config.getRightString());
			System.out.println(builder);
		}
		int aaa = 0;
	}

	public String getRowString(IStringCollection rowCollection, PrettyPrinterConfig config) {
		StringBuilder builder = new StringBuilder(config.getLeftString());
		for (IPrettyString item: rowCollection) {
			if (item instanceof IStringCollection) {
				IStringCollection itemCollection = (IStringCollection) item;
				if (itemCollection.getColumnCount()<2) {
					builder.append(itemCollection.getFirst().getValue());
				} else {
					builder.append(getRowString(itemCollection, config));
				}
			}
		}
		builder.append(config.getRightString());
		return builder.toString();
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
