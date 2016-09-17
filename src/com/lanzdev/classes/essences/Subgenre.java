package com.lanzdev.classes.essences;

import com.lanzdev.utils.Utils;

public class Subgenre implements Nameable{
    private int id;
    private int parent;
    private String name;
    private String history = "No history";

    public Subgenre(int id, int parent, String name, String history) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        if (history != null && !history.equals(""))
            this.history = history;

    }

    public int getId( ) {
        return id;
    }

    public int getParent( ) {
        return parent;
    }

    @Override
    public String getName() {
        return Utils.convertName(name);
    }

    public String getHistory() {
        return history;
    }

    @Override
    public String toString( ) {
        return id + "; " + name + "; " + history;
    }
}
