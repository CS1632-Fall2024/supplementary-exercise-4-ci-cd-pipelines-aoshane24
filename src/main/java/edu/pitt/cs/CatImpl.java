package edu.pitt.cs;

public class CatImpl implements Cat {

	int id;
	String name;
	Boolean rented;

	public CatImpl(int id, String name) {
		this.id = id;
		this.name = name;
		rented = false;
	}

	public void rentCat() {
		rented = true;
	}

	public void returnCat() {
		rented = false;
	}

	public void renameCat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public boolean getRented() {
		return rented;
	}

	public String toString() {
		return ("ID " + String.valueOf(id)+". " + name);
	}

}