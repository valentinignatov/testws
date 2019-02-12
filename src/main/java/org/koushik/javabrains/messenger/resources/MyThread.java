package org.koushik.javabrains.messenger.resources;

import java.util.concurrent.Callable;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;

public class MyThread implements Callable<String>{
	private String name; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	HelloWorldImplService helloService = new HelloWorldImplService();
	HelloWorld hello = helloService.getHelloWorldImplPort();
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(name);
//		return hello.getHelloWorldAsString(name);
		return name;
		
	}
	
}
