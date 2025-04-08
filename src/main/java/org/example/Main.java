package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isON = false;
        BookManager biblioteka = new BookManager();
        while(!isON){
            Scanner scanner = new Scanner(System.in);
            System.out.println("---------------BIBLIOTEKA--------------------");
            System.out.println("1. Dodaj nową książkę");
            System.out.println("2. Wyświetl wszystkie książki");
            System.out.println("3. Wyszukaj książkę po tytule lub autorze");
            System.out.println("4. Usuń książkę po ID");
            System.out.println("5. Zapisz książki do pliku");
            System.out.println("6. Wczytaj książki z pliku");
            System.out.println("7. Zakończ program");
            int option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    System.out.println("Podaj tytuł książki");
                    String title = scanner.nextLine();
                    System.out.println("Podaj autora książki");
                    String author = scanner.nextLine();
                    System.out.println("Podaj rok wydania książki");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj gatunek książki");
                    String genre = scanner.nextLine();
                    int bookID = biblioteka.numberOfBooks();
                    Book ksiazka = new Book(++bookID, title, author, year, genre);
                    biblioteka.addBook(ksiazka);
                    break;
                case 2:
                    biblioteka.selectAllBook();
                    break;
                case 3:
                    biblioteka.searchBook("title", "author");
                    break;
                case 4:
                    biblioteka.deleteBook(1);
                    break;
                case 5:
                    biblioteka.saveBooksToFile("plik");
                    break;
                case 6:
                    biblioteka.readBooksToFile("plik");
                    break;
                case 7:
                    System.out.println("Czy chcesz wyjść z programu? Naicśnij 'T' jeśli chcesz to zrobić ");
                    String quit = scanner.nextLine();
                    if(quit.equals("t") || quit.equals("T")){
                        isON = true;
                    }
                    break;
                default:
                    System.out.println("Opcja jest niepoprawna. Podaj inną liczbę");
            }

        }
    }
}