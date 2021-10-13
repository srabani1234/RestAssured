package com.pojo.issue;

public class issueType {
	String name;
	int id;
	
	public issueType(String name) {
		this.name = name;
		
	}
	public issueType(int id) {
		this.id = id;
		
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
