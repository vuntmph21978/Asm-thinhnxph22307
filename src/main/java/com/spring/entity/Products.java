package com.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Please enter your's image")
	@Column(unique = true,nullable = false)
	private String image;
	
	@NotBlank(message = "Please enter name")
	@Column(unique = true,nullable = false)
	private String name;
	
	private double price;
	

	private String description;
	
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Products() {
		
	}

	public Products(Integer id, @NotBlank(message = "Please enter your's image") String image,
			@NotBlank(message = "Please enter name") String name,
			@NotEmpty(message = "Please enter price") double price,
			@NotBlank(message = "Please enter description") String description, Integer quantity, Category category) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}

	
	

	
	
}
