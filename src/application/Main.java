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
		
		System.out.println();
		System.out.println("                         LIVRARIA");
		System.out.println("=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println();
		System.out.println(UI.menu());
	}
}
