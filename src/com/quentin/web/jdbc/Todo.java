package com.quentin.web.jdbc;

public class Todo {
	private int id;
	private String liste;
	
	
	public Todo(int id, String liste) {
		super();
		this.id = id;
		this.liste = liste;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getListe() {
		return liste;
	}


	public void setListe(String liste) {
		this.liste = liste;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", liste=" + liste + "]";
	}
	
	
	
	
	
	
}
