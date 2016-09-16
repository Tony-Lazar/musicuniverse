package com.lanzdev.classes.essences;

import com.lanzdev.utils.Converter;

public class Genre implements Nameable{
    private int id;
    private String name;
    private String history = "No history";

    public Genre(int id, String name, String history) {
        this.id = id;
        this.name = name;
        if (history != "" && history != null)
            this.history = history;
    }

    public int getId( ) {
        return id;
    }

    @Override
    public String getName( ) {
        return Converter.convertName(name);
    }

    public String getHistory( ) {
        return history;
    }

    @Override
    public String toString( ) {
        return id + "; " + name + "; " + history;
    }
}
