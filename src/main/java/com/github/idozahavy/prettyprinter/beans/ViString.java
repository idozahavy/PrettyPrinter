package com.github.idozahavy.prettyprinter.beans;

import lombok.Getter;

public class ViString extends ViObject {

	@Getter
	private String value;

	public ViString(String value) {
		this.value = value;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public String toString() {
		return value;
	}
}
