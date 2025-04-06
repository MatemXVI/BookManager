package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void selectAllBook(){
        for(Book book : books){
            System.out.println(book);
        }
    }
    public void searchBook(String title, String author){
        for(Book book : books) {
            if(book.getTitle().equals(title) || book.getAuthor().equals(author)){
                System.out.println(book);
            }else{
                System.out.println("Brak takiej książki");
            }
        }

    }
    public void deleteBook(int id){
        books.remove(id);
    }
    public void saveBooksToFile(String fileName){
        try {
            FileWriter plik = new FileWriter(fileName +".txt");
            for(Book book : books){
                plik.write(book.toString() + "\n");
            }
            plik.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd przy zapisie do pliku: " + e.getMessage());
        }
    }
    public void readBooksToFile(String fileName){
//        fileName += ".txt";
//
//        BufferedReader bufferedReader = new BufferedReader(fileName);
//        try {
//            Scanner scan = new Scanner(file);
//            String book = scan.nextLine();
//            file.
//            System.out.println(book);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

}
