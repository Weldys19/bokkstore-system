package model.entites;

import java.util.ArrayList;
import java.util.List;

import model.entites.enums.Category;

public class Bookstore {
	
	private List<Book> list = new ArrayList<>();
	private List<Book> businessBooks = new ArrayList<>();
	private List<Client> client = new ArrayList<>();
	
	public Bookstore() {
	}

	public void add(Book book) {
		list.add(book);
	}
	
	public List<Book> getList() {
		return list;
	}
	
	public List<Client> getClient() {
		return client;
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
	
	public Client clientAlreadyExists(Integer id, String name, String telephone) {
		for (Client c : client) {
			if (c.getId() == id && c.getName().equals(name) && c.getTelephone().equals(telephone)) {
				return c;
			}
			else if (c.getId() == id) {
				throw new ClientException("ID invalido. Ja existe cliente com esse ID. PRESS ENTER");
			}
		}
		return null;
	}
	
	public void bookLoan(Client client, Integer id) {
		for (Book b : list) {
			if (id == b.getId()) {
				if (b.getQuantityStock() > 0) {
					client.addBook(b);
					this.client.add(client);
					businessBooks.add(b);
					b.setQuantityStock(b.getQuantityStock() - 1);
				}
				else {
					throw new BookException("Sem estoque desse livro. PRESS ENTER");
				}
			}
		}
	}
	
	public void listOfBorrowedBooks() {
		List<String> aux = new ArrayList<>();
		for (Client c : client) {
			aux.add(c.toString());
		}
	}
}
