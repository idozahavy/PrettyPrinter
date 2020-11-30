package com.github.idozahavy.prettyprinter.printers.interfaces;

import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.printers.ViPrinterConfig;

public interface IPrettyPrinter {

	void println(ViObject prettyString);

	void printfln(ViObject prettyString, ViPrinterConfig config);

}
