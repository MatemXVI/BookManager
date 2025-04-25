package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {

    private int id;
    private String title;
    private String author;
    private int year;
    private String genre;

    @Override
    public String toString() {
        return id + ";" + title + ";" + author + ";" + year + ";" + genre;

    }

}
