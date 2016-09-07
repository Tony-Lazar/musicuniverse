package com.lanzdev.classes.essences;

public class Subgenre implements Nameable{
    private Genre genre;

    public Subgenre(String name, String history) {
        genre = new Genre(name, history);
    }

    @Override
    public String getName() {
        return genre.getName();
    }

    public String getHistory() {
        return genre.getHistory();
    }

    @Override
    public String toString( ) {
        return genre.getName() + "; " + genre.getHistory();
    }
}
