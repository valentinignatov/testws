package org.koushik.javabrains.messenger.service;

public class MessageArgument {
	private String Arg;
	
	public MessageArgument(){};
	
	public MessageArgument(String Arg){
		this.Arg = Arg;
	}

	public String getArg() {
		return Arg;
	}

	public void setArg(String arg) {
		Arg = arg;
	}
}
