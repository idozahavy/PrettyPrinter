package prettyprinter;

import com.github.idozahavy.prettyprinter.core.Pretty;
import com.github.idozahavy.prettyprinter.annotations.*;
import com.github.idozahavy.prettyprinter.config.PrettyAccessor;
import com.github.idozahavy.prettyprinter.config.PrettyConvertorConfig;

public class AnnoTest {

	public static double doub = 35.345;
	private static double doubPrivate = 532.6988104;
	@PrettyHeader("header1")
	public int headerNameChange1 = 354;
	@PrettyValueCensored
	public int valueCensored = 5959;
	@PrettyHeader("str name2")
	private String headerNameChange2 = "fdsd";
	private AnnoTest annoTest;

	public static void main(String[] args) {
		// private static accessor
		Pretty.println(new AnnoTest(), new PrettyConvertorConfig(PrettyAccessor.Private, true, true));
		
		// public static accessor
		Pretty.println(new AnnoTest(), new PrettyConvertorConfig(PrettyAccessor.Public, true, true));
		
		// public accessor
		Pretty.println(new AnnoTest(), new PrettyConvertorConfig(PrettyAccessor.Public, true, false));
	}

}
