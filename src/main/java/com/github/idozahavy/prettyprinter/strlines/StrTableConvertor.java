package com.github.idozahavy.prettyprinter.strlines;

import java.util.List;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.beans.ViString;
import com.github.idozahavy.prettyprinter.beans.enums.ViCollectionType;

public class StrTableConvertor {

	public static StrTable convert(ViObject viObj) {
		StrTable table = new StrTable();

		if (viObj instanceof ViString) {
			table.appendVer(((ViString) viObj).getValue());
		} else if (viObj instanceof ViCollection) {
			ViCollection coll = (ViCollection) viObj;
			for (ViObject item : coll) {
				StrTable itemLines = convert(item);
				if (coll.getType() == ViCollectionType.Horizontal) {
					table.appendHor(itemLines);
				}else if (coll.getType() == ViCollectionType.Vertical) {
					table.appendVer(itemLines);
				}
			}
			StrTable rightSide = new StrTable();
			for (int i = 0; i < table.getRowCount(); i++) {
				rightSide.appendVer(">");
			}
			StrTable leftSide = new StrTable();
			for (int i = 0; i < table.getRowCount(); i++) {
				leftSide.appendVer("<");
			}
			StrTable topSide = new StrTable();
			for (int i = 0; i < table.getColumnCount(); i++) {
				topSide.appendHor("^");
			}
			StrTable bottomSide = new StrTable();
			for (int i = 0; i < table.getColumnCount(); i++) {
				bottomSide.appendHor("v");
			}
			table.insertHor(leftSide, 0);
			table.appendHor(rightSide);
			table.insertVer(topSide, 0);
			table.appendVer(bottomSide);
			
		}

		return table;
	}

}
