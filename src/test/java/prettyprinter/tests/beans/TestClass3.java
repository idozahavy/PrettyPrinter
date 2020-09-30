package prettyprinter.tests.beans;

import com.github.idozahavy.prettyprinter.annotations.PrettyCensored;

import lombok.Data;

@Data
public class TestClass3 {

	public static int blop = -1;
	@PrettyCensored
	public int aBInt;
	private TestClass2 c;

	public TestClass3(int aBInt, TestClass2 c) {
		this.aBInt = aBInt;
		this.c = c;
	}
}
