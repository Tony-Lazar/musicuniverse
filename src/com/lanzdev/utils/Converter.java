package com.lanzdev.utils;

public class Converter {

    // industrial rock --- Industrial Rock
    public static String convertName(String name) {
        String[]      parts  = name.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            Character capital = parts[i].charAt(0);
            parts[i] = Character.toUpperCase(capital) + parts[i].substring(1);
            result.append(parts[i]);
            if (i < parts.length)
                result.append(" ");
        }
        return result.toString();
    }
}
