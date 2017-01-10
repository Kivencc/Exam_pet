package com.entity;

public class Pet {
	private int id;
	private String typename;
	private String petname;
	
	public Pet() {
		super();
	}
	public Pet(int id, String typename, String petname) {
		super();
		this.id = id;
		this.typename = typename;
		this.petname = petname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	
}
