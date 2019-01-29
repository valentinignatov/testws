package org.koushik.javabrains.messenger.resources;

public class Test {

	private String carti;

	public String getCarti() {
		return carti;
	}

	public void setCarti(String carti) {
		this.carti = carti;
	}

	public Test(String carti) {
		super();
		this.carti = carti;
	}

	public Test() {
		super();
	}

	@Override
	public String toString() {
		return carti;
	}
	
	
	
}