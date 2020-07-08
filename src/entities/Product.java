package entities;

public class Product {
	
	private String name;
	private Double price;
	private int quantity;
		
	public Product() {
	}
	public Product(String name, Double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public double totalValue() {
		return quantity * price;
	}
}
