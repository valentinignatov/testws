package org.koushik.javabrains.messenger.resources;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import javax.ws.rs.Path;
import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageArgument;
import org.koushik.javabrains.messenger.service.MessageService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;
import com.mkyong.ws.MySQLAccess;
@Path("/messages")
public class MessageResource {
	String test = "";
	List<Message> controllerResponse = new ArrayList<Message>();
	MessageArgument messageArgument = new MessageArgument();
	MessageService messageService = new MessageService();
	MySQLAccess mySQLAccess = new MySQLAccess();
	ExecutorService service = Executors.newFixedThreadPool(2000); 
	Message message = new Message();
	//AICI PRIMESC OBIECT JSON PRIN BODY	
	@SuppressWarnings("unchecked")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getArg(Message message) throws Exception{
		//HERE WE RETURN THE MESSEGES
		MySQLAccess access = new MySQLAccess();
		System.out.println("------------------------------- ");
		System.out.println("(In Controler)The argument is "+ message.getId());
		List<Message> messages = null;
		messages = access.selectRecordsFromTable((int)message.getId());
		System.out.println("Object returned from selectRecordFromTable()====== " + message.toString());
		Callable<String> callable = new MyCallable(test);	
		List<MyThreadIgor> listOfThreads = new ArrayList<>();
		List<Future<List<Message>>> futures = new ArrayList<Future<List<Message>>>();
		System.out.println("messages.size(): " + messages.size());
			
		for (Message localMessage: messages){
			int item = (int) localMessage.getId();
			MyThreadIgor listItemIgor = new MyThreadIgor(localMessage.getCarti());
//			System.out.println("access.selectRecordsFromTable(item)"+access.selectRecordsFromTable(item));
			listOfThreads.add(listItemIgor);
		}
		
		futures = service.invokeAll(listOfThreads);
		System.out.println("futures.size()"+futures.size());
		for (int i=0; i<futures.size(); i++) {
			System.out.println("futures: "+futures.get(i).get());
			controllerResponse.addAll(futures.get(i).get());
		};
		return controllerResponse;
	}

	//AICI PRIMESC VALOAREA PRIN HEADER
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@HeaderParam("headerAuthor") int headerAuthor) throws NumberFormatException, SQLException, InterruptedException, ExecutionException {
		MySQLAccess access = new MySQLAccess();
		System.out.println("headerAuthor: " + headerAuthor);
//		return messageService.getAllMessages(access.selectRecordsFromTable(headerAuthor));
		System.out.println("------------------------------- ");
		System.out.println("(In Controler)The argument is "+ headerAuthor);
		List<Message> messages = null;
		messages = access.selectRecordsFromTable(headerAuthor);
//		System.out.println("Object returned from selectRecordFromTable()====== " + message.toString());
		Callable<String> callable = new MyCallable(test);	
		List<MyThreadIgor> listOfThreads = new ArrayList<>();
		List<Future<List<Message>>> futures = new ArrayList<Future<List<Message>>>();
		System.out.println("messages.size(): " + messages.size());
			
		for (Message localMessage: messages){
			int item = (int) localMessage.getId();
			MyThreadIgor listItemIgor = new MyThreadIgor(localMessage.getCarti());
//			System.out.println("access.selectRecordsFromTable(item)"+access.selectRecordsFromTable(item));
			listOfThreads.add(listItemIgor);
		}
		
		futures = service.invokeAll(listOfThreads);
		System.out.println("futures.size()"+futures.size());
		for (int i=0; i<futures.size(); i++) {
			System.out.println("futures: "+futures.get(i).get());
			controllerResponse.addAll(futures.get(i).get());
		};
		return controllerResponse;
	}
	/*
	//AICI PRIMESC VALOAREA PRIN QUERY PARAM
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/query")
	public List<Message> getUsers(@Context UriInfo info) throws NumberFormatException, SQLException {
		MySQLAccess access = new MySQLAccess();
		String from = info.getQueryParameters().getFirst("name");
		System.out.println(from + " <-From");
		return messageService.getAllMessages(access.selectRecordsFromTable(Integer.parseInt(from)));
	}
	
	//AICI PRIMESC VALOARE PRIN URL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{urlParam}")
	public List<Message> getUrl(@PathParam("urlParam")int urlPar) throws SQLException{
		MySQLAccess access = new MySQLAccess();
		return messageService.getAllMessages(access.selectRecordsFromTable(urlPar));
	}*/
	
}


class MyThreadIgor implements Callable<List<Message>>{
	private String item; 
	private String response = "";
	MessageService messageService = new MessageService();
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	HelloWorldImplService helloService = new HelloWorldImplService();
	HelloWorld hello = helloService.getHelloWorldImplPort();
	
	public MyThreadIgor(String item) {
		this.item = item;
	}
	@Override
	public List<Message> call(){
		System.out.println("Thread name is------------------------------- " + Thread.currentThread().getName());
		System.out.println("(In Thread)item" + item);
		String rspTmp = hello.getHelloWorldAsString(item);	
		System.out.println("(In Thread)hello.getHelloWorldAsString(item) !!!= " + rspTmp);
		setResponse(rspTmp);
		
		return messageService.getAllMessages(rspTmp);
	}
}

class MyCallable implements Callable<String>{
	private String item;

	public MyCallable(String item) {
		this.item = item;
	}
	
	@Override
	public String call() throws Exception {
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
		String rspTmp = hello.getHelloWorldAsString(item);
		return rspTmp;
	}
}

class MyRunnable implements Runnable {
    private String value;

    @Override
    public void run() {
       value = Thread.currentThread().getName();
       System.out.println("Run thread "+Thread.currentThread().getName());
       System.out.println("Run Thread Thread value: " + value); //Aici value are valoare
    }

    public String getValue() {
    	System.out.println("Thread Thread value: " + value +Thread.currentThread().getName());
        return value; //Aici value nu mai are valoare    
        }
}