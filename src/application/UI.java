package application;

import java.util.Scanner;

import model.entites.Book;
import model.entites.Bookstore;
import model.entites.Client;
import model.entites.ClientException;
import model.entites.enums.Category;

public class UI {
	
	protected static String menu() {
		return 	"\n"
				+ "                         LIVRARIA\n"
		        + "=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n"
				+ "1 - Cadastro de livros           5 - Devolucao de livros\n"
				+ "2 - Catalogo de livros           6 - Buscar livros por categoria\n"
				+ "3 - Buscar livros por titulo     7 - Dados dos clientes e seus livros alugados\n"
				+ "4 - Emprestimos de livros        8 - Consultar cliente específico\n"
				+ "\n              Digite 0 para encerrar o programa";
	}
	
	protected static void catalog(Bookstore store) {
		System.out.println();
		System.out.println("             Catalogo de livros");
		System.out.println("=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		if (store.getList().size() > 0) {
			for (Book book : store.getList()) {
				System.out.println(book.toString());
				System.out.println("Quantidade em estoque: " + book.getQuantityStock());
				System.out.println();
			}
		}
		else {
			System.out.println("Nenhum livro cadastrado ate o momento");
		}
		System.out.print("\nPRESS ENTER");
	}
	
	protected static void searchBookResult(Bookstore store, String title, Scanner sc) {
		if (store.searchBook(title).size() == 0) {
			System.out.println("Nenhum livro encontrado. PRESS ENTER");
		}
		else {
			for (Book b : store.searchBook(title)) {
				System.out.println(b.toString());
				System.out.println("Quantidade em estoque: " + b.getQuantityStock());
				System.out.println();
			}
			System.out.println();
			System.out.println("Se deseja alugar alguns desses livros, escolha a opcao 4. PRESS ENTER");
		}
	}
	
	protected static void searchBookCategoryResult(Bookstore store, Category category) {
		if (store.searchBookCategory(category).size() == 0) {
			System.out.println("Nenhum livro encontrado. PRESS ENTER");
		}
		else {
			for (Book b : store.searchBookCategory(category)) {
				System.out.println(b.toString());
				System.out.println("Quantidade em estoque: " + b.getQuantityStock());
				System.out.println();
			}
			System.out.println();
			System.out.println("Se deseja alugar alguns desses livros, escolha a opcao 4. PRESS ENTER");
		}
	}
	
	protected static void searchClientDataResult(Bookstore store, Scanner sc) {
		System.out.println("\nDados do cliente:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("ID: ");
		Integer id = sc.nextInt();
		
		if (store.searchClientData(name, id) != null) {
			System.out.println(store.searchClientData(name, id).toString());
		}
		else {
			throw new ClientException("\nEsse cliente nao esta na base de dados");
		}
		System.out.println("PRESS ENTER");
	}
	
	protected static void loan(Client client, Scanner sc, Bookstore store) {
		System.out.print("Informe o ID do livro que deseja: ");
		Integer id = sc.nextInt();
		store.bookLoan(client, id);
		System.out.println();
		System.out.println("Emprestimo feito. Dados:");
		System.out.println(client.toString());
		System.out.println("PRESS ENTER");
		sc.nextLine();
	}
	
	protected static void returnBook(Bookstore store, Scanner sc) {
		System.out.println();
		System.out.println("Dados do livro: ");
		System.out.print("Titulo: ");
		String title = sc.nextLine();
		
		System.out.print("Id: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		System.out.println();
		System.out.println("Entre com os dados do cliente:");
		System.out.println();
		System.out.print("Nome: ");
		String name = sc.nextLine();
		
		System.out.print("ID: ");
		Integer idClient = sc.nextInt();
		
		System.out.print("Numero de telefone: ");
		sc.nextLine();
		String telephone = sc.nextLine();
		
		if (store.clientAlreadyExistsAux(idClient, name, telephone) != null) {
			store.bookReturn(store.clientAlreadyExistsAux(idClient, name, telephone), title, id);		
		}
		else {
			throw new ClientException("Esse cliente nao esta na base de dados. PRESS ENTER");
		}
		
		System.out.println("\nDevolucao feita. Dados:");
		System.out.println(store.clientAlreadyExistsAux(idClient, name, telephone).toString());
		System.out.println("\nPRESS ENTER");
		sc.nextLine();
	}
	
	protected static void dataFromBorrowedBooks(Bookstore store) {
		if (store.getClient().size() > 0) {
			System.out.println("Dados dos clientes e seus livros emprestados:");
			for (String data : store.listOfBorrowedBooks()) {
				System.out.println(data);
			}
		}
		else {
			System.out.println("\nNenhum cliente cadastrado ate o momento");
		}
		System.out.println("PRESS ENTER");
	}
}
