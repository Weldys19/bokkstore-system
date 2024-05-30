package application;

import java.util.Scanner;

import model.entites.Book;
import model.entites.BookException;
import model.entites.Bookstore;
import model.entites.enums.Category;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Bookstore store = new Bookstore();
		
		int choice = 1;

		do {
			try {
				System.out.println(UI.menu());
				System.out.println();
				System.out.print("Insira o numero desejado nesse campo: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
					case 1:
						System.out.println();
						System.out.println("Cadastro de livro: ");
						System.out.print("Titulo: ");
						String title = sc.nextLine();
						
						System.out.print("Autor: ");
						String author = sc.nextLine();
						
						System.out.print("Id: ");
						Integer id = sc.nextInt();
						store.idAlreadyExists(id);
						
						System.out.print("Preco: ");
						sc.nextLine();
						Double price = sc.nextDouble();
						
						System.out.print("Estoque: ");
						sc.nextLine();
						Integer quantityStock = sc.nextInt();
						
						System.out.print("Categoria: ");
						sc.nextLine();
						Category category = Category.valueOf(sc.nextLine().toUpperCase());
						
						store.add(new Book(title, author, id , price, quantityStock, category));
						break;
					case 2:
						UI.catalog(store);
						sc.nextLine();
						break;
				}		
			}
			catch (BookException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}	
			catch (IllegalArgumentException e) {
				System.out.print("Categoria invalida. PRESS ENTER");
				sc.nextLine();
			}
			catch (RuntimeException e) {
				System.out.print("Informacoes invalidas. PRESS ENTER");
				sc.nextLine();
				sc.nextLine();
			}

			}while (choice != 0);	
		
		sc.close();
	}
}
