package com.github.idozahavy.prettyprinter.printers;

import com.github.idozahavy.prettyprinter.printers.interfaces.IPrettyPrinter;

public abstract class PrettyPrinter implements IPrettyPrinter {
	
	protected PrettyPrinterConfig config;

	public PrettyPrinter(PrettyPrinterConfig config) {
		this.config = config;
	}
}
