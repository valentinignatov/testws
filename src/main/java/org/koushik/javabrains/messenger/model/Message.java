package org.koushik.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id;
    private String carti;
    private String pixuri;
    private String costume;
    
    public Message() {
    	
    }
    public Message(int id) {
    	this.id = id;
    }

	public Message(long id, String carti, String pixuri, String costume) {
		super();
		this.id = id;
		this.carti = carti;
		this.pixuri = pixuri;
		this.costume = costume;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarti() {
		return carti;
	}

	public void setCarti(String carti) {
		this.carti = carti;
	}

	public String getPixuri() {
		return pixuri;
	}

	public void setPixuri(String pixuri) {
		this.pixuri = pixuri;
	}

	public String getCostume() {
		return costume;
	}

	public void setCostume(String costume) {
		this.costume = costume;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", carti=" + carti + ", pixuri=" + pixuri + ", costume=" + costume + "]";
	}
 
	
	
}