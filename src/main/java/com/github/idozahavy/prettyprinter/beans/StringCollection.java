package com.github.idozahavy.prettyprinter.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringCollection;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class StringCollection implements IStringCollection {

	@Setter
	protected Object object;
	protected List<IPrettyString> items;
	
	public StringCollection(Object object) {
		this.object = object;
	}

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
	public SimpleString getFirst() {
		IPrettyString prettyString = items.get(0);
		if (prettyString instanceof IStringCollection) {
			return ((IStringCollection)prettyString).getFirst();
					}
		else if (prettyString instanceof SimpleString) {
			return (SimpleString)prettyString;
		}
		// if null - gets here
		throw new RuntimeException("did not catch instance of first item");
	}

	@Override
	public Iterator<IPrettyString> iterator() {
		return items.iterator();
	}
}
