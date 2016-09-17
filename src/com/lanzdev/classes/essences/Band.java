package com.lanzdev.classes.essences;

import com.lanzdev.utils.Utils;

public class Band implements Nameable{
    private int id;
    private String name;
    private String history = "No history";

    public Band(int id, String name, String history) {
        this.id = id;
        this.name = name;
        if (history != " "&& history != null)
            this.history = history;
    }

    public int getId( ) {
        return id;
    }

    @Override
    public String getName( ) {
        return Utils.convertName(name);
    }

    public String getHistory( ) {
        return history;
    }

    @Override
    public String toString( ) {
        return name + "; " + history;
    }
}
