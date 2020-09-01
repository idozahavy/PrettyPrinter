package prettyprinter.tests.strings;

import com.github.idozahavy.prettyprinter.beans.AString;
import com.github.idozahavy.prettyprinter.beans.PrettyFieldString;
import com.github.idozahavy.prettyprinter.beans.PrettyFieldStringList;
import com.github.idozahavy.prettyprinter.beans.PrettyStringMap;
import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

public class PrettyFieldStringListTest {

	public static void main(String[] args) {
		
		PrettyFieldStringList ls = new PrettyFieldStringList("fields");
		
		ls.addString(new AString("abc"));
		ls.addString(new PrettyFieldString("str", new AString("value")));
		
		PrettyStringMap map = new PrettyStringMap();
		map.add(ls);
		
		System.out.println(map.getRowLine(3, 3, PrettyPrinterConfig.defaultConfig));
		
		
	}

}
