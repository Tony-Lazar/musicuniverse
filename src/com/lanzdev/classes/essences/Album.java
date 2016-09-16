package com.lanzdev.classes.essences;

public class Album implements Nameable {
    private int id;
    private String name;
    private int    year;
    private String url;
    private String history;
    private String imagePath;
    private int band;

    public Album(int id, String name, int year, String url, String history, String imagePath, int band) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.url = url;
        if (history != null && !history.equals("")) {
            this.history = history;
        }
        this.imagePath = imagePath;
        this.band = band;
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

    public int getBand( ) {
        return band;
    }
}
