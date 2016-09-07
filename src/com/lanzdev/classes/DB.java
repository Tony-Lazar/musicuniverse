package com.lanzdev.classes;

import com.lanzdev.classes.essences.Genre;
import com.lanzdev.classes.essences.Nameable;
import com.lanzdev.classes.essences.Subgenre;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;

public class DB {
    private static final String URL      = "jdbc:mysql://localhost:3306/music";
    private static final String LOGIN    = "root";
    private static final String PASSWORD = "Equilibrium20!4";
    private static       DB     db       = null;
    private Connection connection;
    private Statement  statement;

    private DB( ) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("connected successfully");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("some troubles");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DB getDB( ) {
        if (db == null)
            db = new DB();
        return db;
    }

    public HashSet<Nameable> getGenres( ) {
        HashSet<Nameable> genres  = new HashSet<>();
        String         request = "select * from music.genres";
        ResultSet      resSet  = getResultSet(request);

        try {
            while (resSet.next()) {
                genres.add(new Genre(resSet.getString("name"), resSet.getString("history")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    public HashSet<Nameable> getSubgenres(String genre) {
        {
            genre = genre.toLowerCase();
            HashSet<Nameable> genres  = new HashSet<>();
            String            request = "select * from music.subgenres where parent = (select id from music.genres where name = '" + genre + "')";
            ResultSet         resSet  = getResultSet(request);

            if (resSet == null)
                return null;

            try {
                while (resSet.next()) {
                    genres.add(new Subgenre(resSet.getString("name"), resSet.getString("history")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return genres;
        }
    }

    public HashSet<Nameable> getBands(String genre) {
        genre = genre.toLowerCase();
        HashSet<Nameable> bands = new HashSet<>();
        String request = "select * from music.bands where id in (" +
                         "select band_id from music.bands_genres where subgenre_id in(" +
                         "select id from music.subgenres where name = '" + genre + "'))";
        ResultSet resSet = getResultSet(request);

        try {
            while (resSet.next()) {
                bands.add(new Subgenre(resSet.getString("name"), resSet.getString("history")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bands;
    }

    public HashSet<Nameable> getAlbums(String band) {
        band = band.toLowerCase();
        HashSet<Nameable> albums = new HashSet<>();
        String request = "select * from music.albums where band = (" +
                "select id from music.bands where name = '" + band + "')";
        ResultSet resSet = getResultSet(request);


        try {
            while (resSet.next()) {
                albums.add(new Subgenre(resSet.getString("name"), resSet.getString("history")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return albums;
    }

    private ResultSet getResultSet(String request) {
        ResultSet resSet = null;
        try {
            resSet = statement.executeQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }


}
