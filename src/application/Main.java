package application;

import java.util.Scanner;

import model.entites.Book;
import model.entites.BookException;
import model.entites.Bookstore;
import model.entites.Client;
import model.entites.ClientException;
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
						
						System.out.print("Estoque: ");
						sc.nextLine();
						Integer quantityStock = sc.nextInt();
						
						System.out.print("Categoria: ");
						sc.nextLine();
						Category category = Category.valueOf(sc.nextLine().toUpperCase());
						
						store.add(new Book(title, author, id, quantityStock, category));
						break;
					case 2:
						UI.catalog(store);
						sc.nextLine();
						break;
					case 3:
						System.out.println();
						System.out.print("Insira o titulo do livro: ");
						title = sc.nextLine();
						UI.searchBookResult(store, title, sc);
						sc.nextLine();
						break;
					case 4:
						System.out.println();
						System.out.println("Entre com os dados do cliente:");
						System.out.print("Nome: ");
						String name = sc.nextLine();
						
						System.out.print("ID: ");
						Integer idClient = sc.nextInt();
						
						System.out.print("Numero de telefone: ");
						sc.nextLine();
						String telephone = sc.nextLine();

						if (store.clientAlreadyExists(idClient, name , telephone) != null) {
							UI.loan(store.clientAlreadyExists(idClient, name , telephone), sc, store);
						}
						else {
							Client client = new Client(name, idClient, telephone);
							UI.loan(client, sc, store);
						}	
						sc.nextLine();
						break;
					case 5:
						UI.returnBook(store, sc);
						break;
					case 6:
						System.out.println();
						System.out.print("Insira a categoria: ");
						category = Category.valueOf(sc.nextLine().toUpperCase());
						UI.searchBookCategoryResult(store, category);
						sc.nextLine();
						break;	
					case 7:
						UI.dataFromBorrowedBooks(store);
						sc.nextLine();
						break;
					case 8:
						UI.searchClientDataResult(store, sc);
						sc.nextLine();
						break;
					case 0:
						System.out.println("Programa encerrado");
				}		
			}
			catch (BookException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
				sc.nextLine();
			}	
			catch (IllegalArgumentException e) {
				System.out.print("Categoria invalida. PRESS ENTER");
				sc.nextLine();
			}
			catch (ClientException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			}	
			catch (RuntimeException e) {
				System.out.println("Informacoes invalidas. PRESS ENTER");
				sc.nextLine();
				sc.nextLine();
			}

			}while (choice != 0);	
		
		sc.close();
	}
}
