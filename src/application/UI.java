package application;

import model.entites.Book;
import model.entites.Bookstore;
import model.entites.enums.Category;

public class UI {
	
	protected static String menu() {
		return 	"\n"
				+ "                         LIVRARIA\n"
		        + "=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n"
				+ "1 - Cadastro de livros          4 - Emprestimos de livros\n"
				+ "2 - Catalogo de livros          5 - Devolucao de livros\n"
				+ "3 - Buscar livros por titulo    6 - Buscar livros por categoria";
	}
	
	protected static void catalog(Bookstore store) {
		System.out.println();
		System.out.println("             Catalogo de livros");
		System.out.println("=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		for (Book book : store.getList()) {
			System.out.println(book.toString());
		}
		System.out.print("PRESS ENTER");
	}
	
	protected static void searchBookResult(Bookstore store, String title) {
		if (store.searchBook(title).size() == 0) {
			System.out.println("Nenhum livro encontrado");
		}
		else {
			for (Book b : store.searchBook(title)) {
				System.out.println(b.toString());
			}
		}
	}
	
	protected static void searchBookCategoryResult(Bookstore store, Category category) {
		if (store.searchBookCategory(category).size() == 0) {
			System.out.println("Nenhum livro encontrado");
		}
		else {
			for (Book b : store.searchBookCategory(category)) {
				System.out.println(b.toString());
			}
		}
	}
}
