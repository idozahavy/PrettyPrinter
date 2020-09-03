package prettyprinter.tests.convertor;

import java.lang.reflect.Modifier;

import com.github.idozahavy.prettyprinter.config.InvokePermit;
import com.github.idozahavy.prettyprinter.convertors.ObjectPrettyConvertor;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorConfig;

import prettyprinter.tests.beans.TestClass;

@SuppressWarnings("unused")
public class Test1 {
	public static void main(String[] args) {

		PrettyConvertorConfig config = new PrettyConvertorConfig();
		config.addModifier(Modifier.PUBLIC);
//		config.addModifier(Modifier.PRIVATE);
//		config.addPermit(InvokePermit.ToString);
		System.out.println(config);
		
		System.out.println(ObjectPrettyConvertor.convert(new TestClass("agfd",2.564,new int[] {365,74,7}), config));
		
	}
}
