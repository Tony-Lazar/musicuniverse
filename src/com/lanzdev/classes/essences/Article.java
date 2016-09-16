package com.lanzdev.classes.essences;

public class Article {
    private int id;
    private String title;
    private String content;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId( ) {
        return id;
    }

    public String getTitle( ) {
        return title;
    }

    public String getContent( ) {
        return content;
    }
}
