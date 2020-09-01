package com.github.idozahavy.prettyprinter.beans2;

import java.util.ArrayList;
import java.util.List;

public abstract class StringCollection implements PrettyString2 {

	protected List<PrettyString2> items;

	public void add(PrettyString2 prettyString) {
		if (items == null) {
			items = new ArrayList<PrettyString2>();
		}
		items.add(prettyString);
	}

	public int getItemCount() {
		return items != null ? items.size() : -1;
	}
	
	public List<PrettyString2> getItems() {
		return new ArrayList<PrettyString2>(items);
	}

}
