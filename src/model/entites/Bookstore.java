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
	
	public List<Book> getList() {
		return list;
	}
	
	public void idAlreadyExists(Integer id) {
		for (Book b : list) {
			if (b.getId() == id) {
				throw new BookException("ID invalido. Ja existe outro produto com esse ID. PRESS ENTER");
			}
		}
	}
}
