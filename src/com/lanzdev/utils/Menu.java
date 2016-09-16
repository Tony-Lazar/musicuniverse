package com.lanzdev.utils;

public enum Menu {

    GENRES("/genresPanel", "Genre Panel"),
    SUBGENRES("/subgenresPanel", "Subgenre Panel"),
    BANDS("/bandsPanel", "Bands Panel"),
    AlBUMS("/albumsPanel", "Albums Panel"),
    ARTICLES("/articlesPanel", "Articles Panel");

    private String url;
    private String title;

    Menu(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl( ) {
        return url;
    }

    public String getTitle( ) {
        return title;
    }
}
