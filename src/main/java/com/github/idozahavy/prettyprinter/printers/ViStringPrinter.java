package com.github.idozahavy.prettyprinter.printers;

import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.beans.ViString;

public class ViStringPrinter extends ViPrinter {

	public ViStringPrinter(ViPrinterConfig config) {
		super(config);
	}

	@Override
	public void println(ViObject prettyString) {
		printfln(prettyString, config);
	}

	@Override
	public void printfln(ViObject prettyString, ViPrinterConfig config) {

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
//			ViCollection row = prettyString.getRow(rowIndex);
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
//				ViCollection column = prettyString.getColumn(columnIndex);
//				ViString str = row.getColumn(columnIndex).getFirst();
//				String paddedStr = PrettyPrinterUtils.padCenter(str.getValue(), columnWidths[columnIndex], ' ');
//				String paddedStr = PrettyPrinterUtils.padCenter(str.getValue(), column.getColumnCount(), ' ');
//				builder.append(paddedStr);
				
				if (columnIndex != columnCount - 1) {
//					builder.append(config.getItemSeperatorString());
				}
			}
//			builder.append(getRowString(row, config));
			builder.append(config.getRightString());
			System.out.println(builder);
		}
		int aaa = 0;
	}

	public String getRowString(ViCollection rowCollection, ViPrinterConfig config) {
		StringBuilder builder = new StringBuilder(config.getLeftString());
		for (ViObject item: rowCollection) {
			if (item instanceof ViCollection) {
				ViCollection itemCollection = (ViCollection) item;
				if (itemCollection.getColumnCount()<2) {
//					builder.append(itemCollection.getFirst().getValue());
				} else {
					builder.append(getRowString(itemCollection, config));
				}
			}
		}
		builder.append(config.getRightString());
		return builder.toString();
	}

}
