package com.friendz.friendz.db;

public class PostsPaging {
	private String next;
	private String previous;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setPrevious(String previous){
		this.previous = previous;
	}

	public String getPrevious(){
		return previous;
	}

	@Override
 	public String toString(){
		return 
			"PostsPaging{" +
			"next = '" + next + '\'' + 
			",previous = '" + previous + '\'' + 
			"}";
		}
}
