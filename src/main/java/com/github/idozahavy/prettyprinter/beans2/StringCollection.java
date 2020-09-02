package com.github.idozahavy.prettyprinter.beans2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans2.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans2.interfaces.IStringCollection;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class StringCollection implements IStringCollection {

	@Setter
	protected String name;
	protected List<IPrettyString> items;

	public void add(IPrettyString prettyString) {
		if (items == null) {
			items = new ArrayList<IPrettyString>();
		}
		items.add(prettyString);
	}

	public int getItemCount() {
		return items != null ? items.size() : -1;
	}

	@Override
	public Iterator<IPrettyString> iterator() {
		return items.iterator();
	}
}
