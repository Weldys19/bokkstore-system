package model.entites;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String name;
	private Integer id;
	private String telephone;
	
	private List<Book> myBorrowedBooks = new ArrayList<>();
	
	public Client(String name, Integer id, String telephone) {
		if (telephone.length() != 9) {
			throw new ClientException("O numero digitado e invalido. PRESS ENTER");
		}
		this.name = name;
		this.id = id;
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Book> getMyBorrowedBooks() {
		return myBorrowedBooks;
	}
	
	protected void addBook(Book book) {
		myBorrowedBooks.add(book);
	}
	
	@Override
	public String toString() {
		System.out.println();
		System.out.println("Emprestimo feito. Dados:");
		StringBuilder sc = new StringBuilder();
		sc.append("Cliente:\n");
		sc.append("Name: " + name + "\n");
		sc.append("ID: " + id + "\n");
		sc.append("Telefone: " + telephone + "\n");
		sc.append("Livros emprestados para esse cliente:\n");
		for (Book b : myBorrowedBooks) {
			sc.append(b.toString() + "\n");
		}
		return sc.toString();	
	}
}
