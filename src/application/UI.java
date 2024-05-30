package application;

import model.entites.Book;
import model.entites.Bookstore;

public class UI {
	
	public static String menu() {
		return 	"\n"
				+ "                         LIVRARIA\n"
		        + "=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n"
				+ "1 - Cadastro de livros          4 - Emprestimos de livros\n"
				+ "2 - Catalogo de livros          5 - Devolucao de livros\n"
				+ "3 - Buscar livros por titulo    6 - Buscar livros por categoria";
	}
	public static void catalog(Bookstore store) {
		System.out.println();
		System.out.println("             Catalogo de livros");
		System.out.println("=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		for (Book book : store.getList()) {
			System.out.println(book.toString());
		}
		System.out.print("PRESS ENTER");
	}
}
