package com.payment.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	private String messagecode;
	private String instruction;
	
	public Message() {
		
	}
	public Message(String messagecode, String instruction) {
		this.messagecode = messagecode;
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Message [messagecode=" + messagecode + ", instruction=" + instruction + "]";
	}
	public String getmessagecode() {
		return messagecode;
	}
	public void setmessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
