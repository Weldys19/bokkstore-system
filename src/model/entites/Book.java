package model.entites;

public class Book {

	private String title;
	private String author;
	private Integer id;
	private Double price;
	private Integer quantityStock;
	
	public Book(String title, String author, Integer id, Double price, Integer quantityStock) {
		this.title = title;
		this.author = author;
		this.id = id;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
