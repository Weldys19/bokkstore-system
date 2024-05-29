package application;


import java.util.Scanner;

import model.entites.Book;
import model.entites.Bookstore;
import model.entites.enums.Category;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Bookstore store = new Bookstore();
		UI.setStore(store);
		
		int choice = 0;
		
		do {
			System.out.println(UI.menu());
			System.out.println();
			System.out.print("Insira o numero desejado nesse campo: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					System.out.print("Titulo: ");
					String title = sc.nextLine();
					System.out.print("Autor: ");
					String author = sc.nextLine();
					System.out.print("Id: ");
					Integer id = sc.nextInt();
					System.out.print("Preco: ");
					sc.nextLine();
					Double price = sc.nextDouble();
					System.out.print("Estoque: ");
					sc.nextLine();
					Integer quantityStock = sc.nextInt();
					System.out.print("Categoria: ");
					sc.nextLine();
					String category = sc.nextLine().toUpperCase();
					store.add(new Book(title, author, id , price, quantityStock, Category.valueOf(category)));
					break;
				case 2:
					UI.catalog();
					sc.nextLine();
					break;
			}
			
		}while (choice != 0);	
	}
}
