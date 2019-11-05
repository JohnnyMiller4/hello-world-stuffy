package com.stuffy.business;

//import entity, then make it a wild card for @Id and @GeneratedValue(strategy = etc. etc.)
import javax.persistence.*;

@Entity
public class Stuffy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String color;
	private String size;
	private int limbs;
	
	public Stuffy() {
		super();
	}

	public Stuffy(String type, String color, String size, int limbs) {
		this.type = type;
		this.color = color;
		this.size = size;
		this.limbs = limbs;
	}

	public Stuffy(int id, String type, String color, String size, int limbs) {
		super();
		this.id = id;
		this.type = type;
		this.color = color;
		this.size = size;
		this.limbs = limbs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getLimbs() {
		return limbs;
	}

	public void setLimbs(int limbs) {
		this.limbs = limbs;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + type + ", Color: " + color + ", Size: " + size + ", Limbs: " + limbs;
	}

}
