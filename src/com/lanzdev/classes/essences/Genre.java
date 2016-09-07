package com.lanzdev.classes.essences;

import com.lanzdev.utils.Converter;

public class Genre implements Nameable{
    String name;
    String history = "No history";

    public Genre(String name, String history) {
        this.name = name;
        if (history != "" && history != null)
            this.history = history;
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
        return name + "; " + history;
    }
}
