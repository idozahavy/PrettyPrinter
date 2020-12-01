package prettyprinter.tests.convertor;

import java.lang.reflect.Modifier;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.config.InvokationPermit;
import com.github.idozahavy.prettyprinter.convertors.ObjectViConvertor;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;
import com.github.idozahavy.prettyprinter.strtable.StrTableConvertor;

import prettyprinter.tests.beans.TestClass;

@SuppressWarnings("unused")
public class Test1 {
	public static void main(String[] args) {

		ViConvertorConfig config = new ViConvertorConfig();
		config.addModifier(Modifier.PUBLIC);
		config.addModifier(Modifier.PRIVATE);
//		config.addPermit(InvokePermit.ToString);
		System.out.println(config);
		
		ViObject ob = ObjectViConvertor.convert(new TestClass("agfd",2.564,new int[] {365,74,7}), config);
		
		if (ob instanceof ViCollection) {
			ViCollection coll = (ViCollection) ob;
			System.out.println("Size = "+coll.size());
			for (ViObject viObject : coll) {
				System.out.println(viObject.toString());
			}
		}
		else {
			System.out.println("not collection");
		}
		
		System.out.println();
		System.out.println("***");
		System.out.println(StrTableConvertor.convert(ob));
		
	}
}
