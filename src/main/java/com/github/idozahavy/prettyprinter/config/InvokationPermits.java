package com.github.idozahavy.prettyprinter.config;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;

@Builder
public class InvokationPermits {
	
	public InvokationPermits() {
		this.invokePermits = new HashSet<>();
	}
	
	public InvokationPermits(Set<InvokationPermit> invokePermits) {
		this.invokePermits = invokePermits;
	}

	Set<InvokationPermit> invokePermits;
	
	public void add(InvokationPermit permit) {
		this.invokePermits.add(permit);
	}
	
}
