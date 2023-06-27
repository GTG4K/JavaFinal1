package com.example.myjavafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {

    private final StringProperty title;
    private final StringProperty director;

    public Movie(String title, String director) {
        this.title = new SimpleStringProperty(title);
        this.director = new SimpleStringProperty(director);
    }

    public StringProperty getTitle() {
        return title;
    }

    public StringProperty getDirector() {
        return director;
    }
}
