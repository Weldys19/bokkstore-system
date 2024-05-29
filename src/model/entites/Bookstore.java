package model.entites;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
	
	private List<Book> list = new ArrayList<>();
	
	public Bookstore() {
	}

	public void add(Book book) {
		list.add(book);
	}

	public String bookCatalog() {
		for (Book book : list) {
			return book.toString();
		}
		return "";
	}
}
