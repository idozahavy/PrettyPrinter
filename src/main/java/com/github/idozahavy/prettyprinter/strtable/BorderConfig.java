package com.github.idozahavy.prettyprinter.strtable;

import lombok.Getter;

@Getter
public class BorderConfig {

	public static BorderConfig build() {
		return new BorderConfig();
	}
	private BorderConfig() {
	}
	public BorderConfig(Character topChar, Character bottomChar, String rightStr, String leftStr) {
		this.topChar = topChar.toString();
		this.bottomChar = bottomChar.toString();
		this.rightStr = rightStr;
		this.leftStr = leftStr;
	}
	private String topChar;
	private String bottomChar;
	private String rightStr;
	private String leftStr;
	
	public BorderConfig setTopChar(Character topChar) {
		this.topChar = topChar.toString();
		return this;
	}
	public BorderConfig setBottomChar(Character bottomChar) {
		this.bottomChar = bottomChar.toString();
		return this;
	}
	public BorderConfig setRightChar(Character rightStr) {
		this.rightStr = rightStr.toString();
		return this;
	}
	public BorderConfig setLeftChar(Character leftStr) {
		this.leftStr = leftStr.toString();
		return this;
	}
	
}
