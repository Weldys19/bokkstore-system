package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entites.Book;
import model.entites.enums.Category;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Book> book = new ArrayList<>();
		
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
					book.add(new Book(title, author, id , price, quantityStock, Category.valueOf(category)));
					break;
				case 2:
					for (Book b : book) {
						System.out.println(b.toString());
					}
					System.out.println("PRESS ENTER");
					sc.nextLine();
					break;
					
			}
			
		}while (choice != 0);	
	}
}
