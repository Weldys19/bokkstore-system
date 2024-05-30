package model.entites;

import java.util.ArrayList;
import java.util.List;

import model.entites.enums.Category;

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
				throw new BookException("ID invalido. Ja existe produto com esse ID. PRESS ENTER");
			}
		}
	}
	
	public List<Book> searchBook(String title) {
		List<Book> searchResult = new ArrayList<>();
		for (Book b : list) {
			if (title.toUpperCase().equals(b.getTitle().toUpperCase())) {
				searchResult.add(b);
			}
		}
		return searchResult;
	}
	
	public List<Book> searchBookCategory(Category category) {
		List<Book> searchResult = new ArrayList<>();
		for (Book b : list) {
			if (category == b.getCategory()) {
				searchResult.add(b);
			}
		}
		return searchResult;
	}
}
