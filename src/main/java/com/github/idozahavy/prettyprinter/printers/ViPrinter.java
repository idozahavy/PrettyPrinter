package com.github.idozahavy.prettyprinter.printers;

import com.github.idozahavy.prettyprinter.printers.interfaces.IPrettyPrinter;

public abstract class ViPrinter implements IPrettyPrinter {
	
	protected ViPrinterConfig config;

	public ViPrinter(ViPrinterConfig config) {
		this.config = config;
	}
}
