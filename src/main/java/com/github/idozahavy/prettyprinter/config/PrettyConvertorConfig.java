package com.github.idozahavy.prettyprinter.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrettyConvertorConfig {
	public static PrettyConvertorConfig defaultConfig = new PrettyConvertorConfig(PrettyAccessor.Public);
	private PrettyAccessor accessor;
	private boolean invokeToString = true;

	private boolean retrieveStaticFields;

	public PrettyConvertorConfig(PrettyAccessor accessor) {
		this.accessor = accessor;
	}
}
