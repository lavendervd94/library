package com.library.model;

public class Book {
	private String Name;
	private String Category;
	private String Author;
	private String Price;
	private String Id;
	public Book() {
		
	}
	public Book(String name, String category, String author, String price,String id) {
		this.Name = name;
		this.Category = category;
		this.Author = author;
		this.Price = price;
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		this.Author = author;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
}
