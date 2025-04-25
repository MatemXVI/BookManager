package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj tytuł książki: ");
        String title = scanner.nextLine();

        System.out.print("Podaj autora książki: ");
        String author = scanner.nextLine();

        System.out.print("Podaj rok wydania książki: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Podaj gatunek książki: ");
        String genre = scanner.nextLine();

        Book book = new Book(nextId++, title, author, year, genre);
        books.add(book);
        System.out.println("Dodano książkę.");
    }

    public void selectAllBook() {
        if (books.isEmpty()) {
            System.out.println("Brak książek w bazie.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String query) {
        boolean found = false;
        for (Book book : books) {
            String title = book.getTitle().toLowerCase();
            String author = book.getAuthor().toLowerCase();
            if (title.contains(query.toLowerCase()) || author.contains(query.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nie znaleziono książki.");
        }
    }

    public void deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            System.out.println("Usunięto książkę.");
        } else {
            System.out.println("Nie znaleziono książki o podanym ID.");
        }
    }

    public void saveBooksToFile(String fileName) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(fileName + ".txt"));
            for (Book book : books) {
                writer.println(book);
            }
            System.out.println("Zapisano książki do pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd przy zapisie do pliku: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


    public void readBooksToFile(String fileName) {
        Scanner scanner = null;
        books.clear();

        try {
            File file = new File(fileName + ".txt");
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    String genre = parts[4];

                    books.add(new Book(id, title, author, year, genre));

                    // Ustawienie nextId na największe ID + 1
                    if (id >= nextId) {
                        nextId = id + 1;
                    }
                }
            }
            System.out.println("Wczytano książki z pliku.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + fileName + ".txt");
        } finally {
            if (scanner != null) {
                scanner.close(); // zawsze zamknij scanner
            }
        }
    }
}
