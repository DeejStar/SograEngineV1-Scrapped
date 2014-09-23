package com.soginteractive.engine.core.misc;

public class Target {

	private String target;

	public Target() {
		this("");
	}

	public Target(String target) {
		target(target);
	}

	public Target target(String target) {
		this.target = target;
		return this;
	}

	public String getTarget() {
		return target;
	}

}
