package com.friendz.friendz.model;

public class Paging{
	private String next;
	private Cursors cursors;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setCursors(Cursors cursors){
		this.cursors = cursors;
	}

	public Cursors getCursors(){
		return cursors;
	}

	@Override
 	public String toString(){
		return 
			"Paging{" + 
			"next = '" + next + '\'' + 
			",cursors = '" + cursors + '\'' + 
			"}";
		}
}
