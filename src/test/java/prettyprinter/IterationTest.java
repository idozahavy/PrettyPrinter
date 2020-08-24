package prettyprinter;

import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.PrettyAccessor;
import com.github.idozahavy.prettyprinter.core.PrettyPrint;
import com.github.idozahavy.prettyprinter.string.beans.PrettyString;

public class IterationTest {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(5);
		ints.add(453);
		
		PrettyString str = PrettyPrint.toPrettyStrings(ints, PrettyAccessor.Public, false);
		for (PrettyString prettyString : str) {
			System.out.println(prettyString);
		}
		
		str = PrettyPrint.toPrettyStrings(new TestClass3(4, new TestClass2(new TestClass("blop", 123, false, 444.11), 5)), PrettyAccessor.Private, true);
		for (PrettyString prettyString : str) {
			System.out.println(prettyString);
		}
		
	}

}
