package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.messenger.model.Message;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;

public class MessageService {
	

	public List<Message> getAllMessages(String argument) {
		Message m1 = new Message(1L, "first list that appears when response equals VANEA", "Valentin3453");
		Message m2 = new Message(2L, "Hello Jersey!", "Valentin34543");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);

		Message m3 = new Message(134L, "second list that appears when response equals Jora!", "test");
		Message m4 = new Message(22342L, "test", "test");
		List<Message> list2 = new ArrayList<Message>();
		list2.add(m3);
		list2.add(m4);

		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
		String name = hello.getHelloWorldAsString("Chirila");
		System.out.println(name + " <-the Name===============================");
		System.out.println(argument + " <-the Arg===============================");

		if (name.equals("JORA")) {
			return list2;
		} else {
			return list;
		}

		// url http://localhost:8080/messenger/webapi/messages
	}

}
