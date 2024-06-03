package model.entites;

import model.entites.enums.Category;

public class Book {

	private String title;
	private String author;
	private Integer id;
	private Integer quantityStock;
	private Category category;
	
	public Book(String title, String author, Integer id, Integer quantityStock, Category category) {
		if (id < 0 || quantityStock < 0) {
			throw new BookException("Tanto o ID, quanto a quantidade em estoque, nao podem ser negativos. PRESS ENTER");
		}
		this.title = title;
		this.author = author;
		this.id = id;
		this.quantityStock = quantityStock;
		this.category = category;
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

	public Integer getQuantityStock() {
		return quantityStock;
	}
	
	public void setQuantityStock(Integer quantityStock) {
		this.quantityStock = quantityStock;
	}
	
	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Titulo: " + title
				+ "\nAutor: " + author
				+ "\nID: " + id
				+ "\nCategoria: " + category;
	}
}
