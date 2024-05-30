package model.entites;

import model.entites.enums.Category;

public class Book {

	private String title;
	private String author;
	private Integer id;
	private Double price;
	private Integer quantityStock;
	private Category category;
	private String synopsis;
	
	public Book(String title, String author, Integer id, Double price, Integer quantityStock, Category category, String synopsis) {
		if (price < 0 || id < 0 || quantityStock < 0) {
			throw new BookException("Tanto o ID, quanto o preco, e quantidade em estoque, nao podem ser negativos. PRESS ENTER");
		}
		this.title = title;
		this.author = author;
		this.id = id;
		this.price = price;
		this.quantityStock = quantityStock;
		this.category = category;
		this.synopsis = synopsis;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantityStock() {
		return quantityStock;
	}
	
	public void setQuantityStock(Integer quantityStock) {
		this.quantityStock = quantityStock;
	}
	
	public Category getCategory() {
		return category;
	}

	public String getSynopsis() {
		return synopsis;
	}

	@Override
	public String toString() {
		return title
				+ ", "
				+ author
				+ ", R$"
				+ String.format("%.2f", price)
				+ ", "
				+ quantityStock;
	}
}
