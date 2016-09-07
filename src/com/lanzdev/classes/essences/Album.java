package com.lanzdev.classes.essences;

public class Album implements Nameable {
    String history;
    String imagePath;
    String name;
    int    year;

    public Album(String name, int year, String imagePath, String history) {
        this.name = name;
        this.year = year;
        this.imagePath = imagePath;
        if (history != " " && history != null)
            this.history = history;
    }

    @Override
    public String getName( ) {
        return name;
    }

    public String getHistory( ) {
        return history;
    }

    public String getImagePath( ) {
        return imagePath;
    }

    public int getYear( ) {
        return year;
    }
}
