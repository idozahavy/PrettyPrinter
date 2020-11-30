package com.github.idozahavy.prettyprinter.beans;

import java.util.*;
import java.util.stream.IntStream;

import com.github.idozahavy.prettyprinter.beans.enums.ViCollectionType;

import lombok.*;

public class ViCollection extends ViObject implements Iterable<ViObject> {

	@Getter
	@Setter
	private Object presentor;
	@Getter
	@Setter
	private ViCollectionType type;
	private List<ViObject> items;

	public ViCollection(Object presentor, ViCollectionType type) {
		this.presentor = presentor;
		this.type = type;
		this.items = new ArrayList<ViObject>();
	}

	public ViObject get(int index) {
		if (index < 0 || index >= size()) {
			return null;
		}
		return this.items.get(index);
	}

	@Override
	public int getColumnCount() {
		if (size() == 1) {
			return 1;
		}
		switch (this.type) {
		case Horizontal:
			return 1 + items.stream().max((ob, other) -> ob.getColumnCount() - other.getColumnCount()).get()
					.getColumnCount();
		case Vertical:
			return items.stream().flatMapToInt((ob) -> IntStream.builder().add(ob.getColumnCount()).build()).sum();
		}
		return 0;
	}

	@Override
	public int getRowCount() {
		if (size() == 1) {
			return 1;
		}
		switch (this.type) {
		case Horizontal:
			return items.stream().flatMapToInt((ob) -> IntStream.builder().add(ob.getColumnCount()).build()).sum();
		case Vertical:
			return items.stream().max((ob, other) -> ob.getColumnCount() - other.getColumnCount()).get()
					.getColumnCount();
		}
		return 0;
	}

	public void push(ViObject viObject) {
		items.add(viObject);
	}

	public int size() {
		return this.items.size();
	}

	public List<ViObject> getItems() {
		return this.items;
	}

	@Override
	public Iterator<ViObject> iterator() {
		return this.items.iterator();
	}

	@Override
	public int hashCode() {
		return presentor.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return presentor.equals(obj);
	}

}
