package prettyprinter.tests;

import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.convertors.PrettyConvertor;

import prettyprinter.tests.beans.TestClass;
import prettyprinter.tests.beans.TestClass2;
import prettyprinter.tests.beans.TestClass3;

import com.github.idozahavy.prettyprinter.config.PrettyAccessor;
import com.github.idozahavy.prettyprinter.config.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.beans.PrettyString;

public class IterationTest {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(5);
		ints.add(453);

		PrettyString str = PrettyConvertor.convert(ints, PrettyConvertorConfig.defaultConfig);
		for (PrettyString prettyString : str) {
			System.out.println(prettyString);
		}

		str = PrettyConvertor.convert(new TestClass3(4, new TestClass2(new TestClass("blop", 123, false, 444.11), 5)),
				new PrettyConvertorConfig(PrettyAccessor.Private));
		for (PrettyString prettyString : str) {
			System.out.println(prettyString);
		}

	}

}
