package com.github.idozahavy.prettyprinter.beans.interfaces;

public interface IViObject {

	/**
	 * Horizontal Count 
	 */
	public abstract int getColumnCount();
	
	/**
	 * Vertical Count
	 */
	public abstract int getRowCount();
	
	@Override
	int hashCode();
}
