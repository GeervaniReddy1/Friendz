package com.friendz.friendz.request;

public class FbMessageReq{
	private Recipient recipient;
	private Message message;

	public void setRecipient(Recipient recipient){
		this.recipient = recipient;
	}

	public Recipient getRecipient(){
		return recipient;
	}

	public void setMessage(Message message){
		this.message = message;
	}

	public Message getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"FbMessageReq{" + 
			"recipient = '" + recipient + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
