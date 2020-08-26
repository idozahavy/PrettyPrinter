package prettyprinter;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class TestClass {
	private String aString;
	private int bInt;
	private boolean cBool;
	private double dDouble;
}
