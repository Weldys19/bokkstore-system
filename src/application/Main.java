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
						String title = UI.UITitle(sc);
						String author = UI.UIAuthor(sc);
						Integer id = UI.UIId(sc);
						store.idAlreadyExists(id);
						Integer quantityStock = UI.UIQuantityStock(sc);
						Category category = UI.UICategory(sc);
						store.add(new Book(title, author, id, quantityStock, category));
						break;
					case 2:
						UI.catalog(store);
						sc.nextLine();
						break;
					case 3:
						System.out.println();
						title = UI.UITitle(sc);
						UI.searchBookResult(store, title, sc);
						sc.nextLine();
						break;
					case 4:
						System.out.println();
						System.out.println("Entre com os dados do cliente:");
						String name = UI.UIName(sc);
						id = UI.UIId(sc);
						String telephone = UI.UITelephone(sc);
						Client clientExistis = store.clientAlreadyExists(id, name , telephone);
						if (clientExistis != null) {
							UI.loan(clientExistis, sc, store);
						}
						else {
							Client client = new Client(name, id, telephone);
							UI.loan(client, sc, store);
						}	
						sc.nextLine();
						break;
					case 5:
						UI.returnBook(store, sc);
						break;
					case 6:
						System.out.println();
						category = UI.UICategory(sc);
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
