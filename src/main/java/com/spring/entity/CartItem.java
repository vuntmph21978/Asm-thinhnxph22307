package com.spring.entity;


public class CartItem {

    private Integer id;
    private String name;
    private double price;
    private String image;
    private int qty;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Integer id, String name, double price, String image, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", qty=" + qty + "]";
	}
    
    

}