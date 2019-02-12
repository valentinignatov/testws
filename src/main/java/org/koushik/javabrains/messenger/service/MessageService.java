package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.messenger.model.Message;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;

public class MessageService {
	

	public List<Message> getAllMessages(String argument) {
		Message m1 = new Message(1L, "first list that appears when response equals VANEA", "Valentin3453", "Test");
		Message m2 = new Message(2L, "Your sent value was 2!", "Valentin34543 The Value From DB is Chirila", "Test");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);

		Message m3 = new Message(134L, "second list that appears when response equals Jora!", "test", "Test");
		Message m4 = new Message(22342L, "Your sent value was 1", "test The Value From DB is Moraru", "Test");
		List<Message> list2 = new ArrayList<Message>();
		list2.add(m3);
		list2.add(m4);
		
		List<Message> list3 = new ArrayList<Message>();
		Message m5 = new Message(666L, "Default", "Default", "Default");
		list3.add(m5);
		
		//Message argument = new Message();
		
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
		//String name = hello.getHelloWorldAsString(argument);
		System.out.println(hello.getHelloWorldAsString(argument) + " <-the Name===============================");
		System.out.println(argument + " <-the Arg===============================");

		//return hello.getHelloWorldAsString(argument);
//		String rsp = hello.getHelloWorldAsString(argument);
		String rsp = argument;
		System.out.println("[getAllMessages] - rsp = " + rsp);
		if ("JORA".equals(rsp)) {
			return list2;
		}else if ("VANEA".equals(rsp)) 
		{
			return list;
		} 
		else
		{
			return list3;
		} 
		
	
		
		

		// url http://localhost:8080/messenger/webapi/messages
	}

}
