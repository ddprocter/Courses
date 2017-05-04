package Homework2;

public class Book {	
	private String name;
	private float cost;
	
	
	public Book(String name, float cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
