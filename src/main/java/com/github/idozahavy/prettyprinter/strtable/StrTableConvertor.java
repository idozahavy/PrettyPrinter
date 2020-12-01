package com.github.idozahavy.prettyprinter.strtable;

import java.util.ArrayList;
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
			List<Integer> lfSeperatorIndeces = new ArrayList<>();
			List<Integer> tbSeperatorIndeces = new ArrayList<>();
			ViCollection coll = (ViCollection) viObj;
			for (ViObject item : coll) {
				StrTable itemLines = convert(item);
				if (coll.getType() == ViCollectionType.Horizontal) {
					lfSeperatorIndeces.add(table.getColumnCount());
					table.appendHor(itemLines);
				} else if (coll.getType() == ViCollectionType.Vertical) {
					tbSeperatorIndeces.add(table.getRowCount());
					table.appendVer(itemLines);
				}
			}
			for (int i = lfSeperatorIndeces.size() - 1; i > 0; i--) {
				int sepIndex = lfSeperatorIndeces.get(i);
				table.insertHor(table.getLRBorder(" | "), sepIndex);
			}
			for (int i = tbSeperatorIndeces.size() - 1; i > 0; i--) {
				int sepIndex = tbSeperatorIndeces.get(i);
//				table.insertVer(table.getTBBorder("-"), sepIndex);
			}

			table.border(new BorderConfig('*', '*', " *", "* "));
		}

		return table;
	}

}
