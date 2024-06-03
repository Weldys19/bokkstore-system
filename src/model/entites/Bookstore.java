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
				throw new BookException("ID invalido. Ja existe livro com esse ID. PRESS ENTER");
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
	
	public Client searchClientData(String name, Integer id) {
		for (Client c : client) {
			if (c.getName().equals(name) && c.getId() == id) {
				return c;
			}
		}
		return null;
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
	
	public Client clientAlreadyExistsAux(Integer id, String name, String telephone) {
		for (Client c : client) {
			if (c.getId() == id && c.getName().equals(name) && c.getTelephone().equals(telephone)) {
				return c;
			}
		}
		return null;
	}
	
	public void bookLoan(Client client, Integer id) {
		if(clientAlreadyExistsAux(client.getId(), client.getName(), client.getTelephone()) == null) {
			this.client.add(client);
		}
		boolean bookExistis = false;
		for (Book b : list) {
			if (id == b.getId()) {
				bookExistis = true;
				if (b.getQuantityStock() > 0) {
					client.addBook(b);
					businessBooks.add(b);
					b.setQuantityStock(b.getQuantityStock() - 1);
				}
				else {
					throw new BookException("Sem estoque desse livro. PRESS ENTER");
				}
			}
		}
		if (!bookExistis) {
			throw new BookException("Esse livro nao esta na base de dados. PRESS ENTER");
		}
	}
	
	public void bookReturn(Client client, String title, Integer id) {
		Book b = returnedBook(client, title, id);
		if (b != null) {
			client.removeBook(b);
			businessBooks.remove(b);
			for (Book books : list) {
				if (books.getId() == b.getId()) {
					books.setQuantityStock(books.getQuantityStock() + 1);
				}
			}
		}
		else {
			throw new BookException("O cliente nao tem nenhum livro alugado com esses dados. PRESS ENTER");
		}
	}
	
	private Book returnedBook(Client client, String title, Integer id) {
		for (Book b : client.getMyBorrowedBooks()) {
			if (b.getTitle().equals(title) && b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}
	
	public List<String> listOfBorrowedBooks() {
		List<String> aux = new ArrayList<>();
		for (Client c : client) {
			aux.add(c.toString());
		}
		return aux;
	}
}
