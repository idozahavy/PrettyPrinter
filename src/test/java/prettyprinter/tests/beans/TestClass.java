package prettyprinter.tests.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestClass {
	private String aString;
	public double dDouble;
	private int[] ints;
}
