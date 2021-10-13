package com.pojo.issue;


public class Fields {
	
	Payload fields;
	// ObjectMappaert conver our object in JSON format
	public Fields(Payload payload) {
		this.fields = payload;
	}
	public Payload getFields() {
		return fields;
	}
	public void setFields(Payload fields) {
		this.fields = fields;
	}




}
