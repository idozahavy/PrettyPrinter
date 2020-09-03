package com.github.idozahavy.prettyprinter.printers.interfaces;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.printers.PrettyPrinterConfig;

public interface IPrettyPrinter {

	void println(IPrettyString prettyString);

	void printfln(IPrettyString prettyString, PrettyPrinterConfig config);

	void print(IPrettyString prettyString, int row);

	void printf(IPrettyString prettyString, int row, PrettyPrinterConfig config);

}
