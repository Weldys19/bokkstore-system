package application;

import model.entites.Bookstore;

public class UI {
	
	private static Bookstore store;
	
	public static void setStore(Bookstore Bookstore) {
		store = Bookstore;
	}
	
	public static String menu() {
		return 	"\n"
				+ "                         LIVRARIA\n"
		        + "=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n"
				+ "1 - Cadastro de livros          4 - Emprestimos de livros\n"
				+ "2 - Catalogo de livros          5 - Devolução de livros\n"
				+ "3 - Buscar livros por titulo    6 - Buscar livros por categoria";
	}
	public static void catalog() {
		System.out.println(store.bookCatalog());
		System.out.println("PRESS ENTER");
	}
}
