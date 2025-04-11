package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isON = false;
        BookManager biblioteka = new BookManager();
        Scanner scanner = new Scanner(System.in);
        while(!isON){
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
                    biblioteka.addBook();
                    break;
                case 2:
                    biblioteka.selectAllBook();
                    break;
                case 3:
                    System.out.print("Podaj frazę do wyszukania (tytuł lub autor): ");
                    String query = scanner.nextLine();
                    biblioteka.searchBook(query);
                    break;

                case 4:
                    System.out.print("Podaj ID książki do usunięcia: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    biblioteka.deleteBook(id);
                    break;

                case 5:
                    biblioteka.saveBooksToFile("plik.txt");
                    break;

                case 6:
                    biblioteka.readBooksToFile("plik.txt");
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