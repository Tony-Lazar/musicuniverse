package com.lanzdev.classes.essences;

public class Album implements Nameable {
    private int id;
    private String name;
    private int    year;
    private String url;
    private String history;
    private String imagePath;

    public Album(int id, String name, int year, String url, String history, String imagePath) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.url = url;
        if (history != " " && history != null) {
            this.history = history;
        }
        this.imagePath = imagePath;
    }

    public int getId( ) {
        return id;
    }

    @Override
    public String getName( ) {
        return name;
    }

    public int getYear( ) {
        return year;
    }

    public String getUrl( ) {
        return url;
    }

    public String getHistory( ) {
        return history;
    }

    public String getImagePath( ) {
        return imagePath;
    }
}
