package com.lanzdev.classes;

import com.lanzdev.classes.essences.*;

import java.sql.*;
import java.util.HashSet;

public class DB {
        private static final String URL      = "jdbc:mysql://mysql302.1gb.ua/gbua_mcunivers";
//    private static final String URL      = "jdbc:mysql://localhost:3306/gbua_mcunivers";
        private static final String LOGIN    = "gbua_mcunivers";
//    private static final String LOGIN    = "root";
        private static final String PASSWORD = "df5f96daf0";
//    private static final String PASSWORD = "Equilibrium20!4";
    private static       DB     db       = null;

    private DB( ) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
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

    /*GETTERS*/


    public HashSet<Subgenre> getSubgenresByGenre(int id) {
        Connection        con  = null;
        PreparedStatement stmt = null;
        ResultSet         rs   = null;

        HashSet<Subgenre> genres  = new HashSet<Subgenre>();
        String            request = "select * from gbua_mcunivers.subgenres where parent = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            try {
                while (rs.next()) {
                    genres.add(new Subgenre(
                            rs.getInt("id"), rs.getInt("parent"), rs.getString("name"), rs.getString("history")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return genres;

    }

    public HashSet<Band> getBandsBySubgenre(int id) {
        Connection        con  = null;
        PreparedStatement stmt = null;
        ResultSet         rs   = null;

        HashSet<Band> bands = new HashSet<Band>();
        String request = "select * from gbua_mcunivers.bands where id in (" +
                "select band_id from gbua_mcunivers.bands_genres where subgenre_id = ?)";
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            try {
                while (rs.next()) {
                    bands.add(new Band(rs.getInt("id"), rs.getString("name"), rs.getString("history")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bands;
    }

    public HashSet<Album> getAlbumsByBand(int id) {
        Connection        con  = null;
        PreparedStatement stmt = null;
        ResultSet         rs   = null;

//        band = band.toLowerCase();
        HashSet<Album> albums = new HashSet<Album>();
        String request = "select * from gbua_mcunivers.albums where band = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            try {
                while (rs.next()) {
                    albums.add(new Album(rs.getInt("id"), rs.getString("name"), rs.getInt("year"),
                            rs.getString("url"), rs.getString("history"), rs.getString("image_path"),
                            rs.getInt("band")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return albums;
    }


    public HashSet<Genre> getGenres( ) {
        Connection con  = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        HashSet<Genre> genres  = new HashSet<Genre>();
        String         request = "select * from gbua_mcunivers.genres";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(request);
            try {
                while (rs.next()) {
                    genres.add(new Genre(rs.getInt("id"), rs.getString("name"), rs.getString("history")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return genres;
    }

    public HashSet<Subgenre> getSubgenres( ) {
        Connection con  = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        HashSet<Subgenre> subgenres = new HashSet<Subgenre>();
        String            request   = "select * from gbua_mcunivers.subgenres";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(request);
            try {
                while (rs.next())
                    subgenres.add(new Subgenre(
                            rs.getInt("id"), rs.getInt("parent"), rs.getString("name"), rs.getString("history")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return subgenres;
    }

    public HashSet<Band> getBands( ) {
        Connection con  = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        HashSet<Band> bands   = new HashSet<Band>();
        String        request = "select * from gbua_mcunivers.bands";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(request);
            try {
                while (rs.next())
                    bands.add(new Band(rs.getInt("id"), rs.getString("name"), rs.getString("history")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bands;
    }

    public HashSet<Album> getAlbums( ) {
        Connection con  = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        HashSet<Album> albums  = new HashSet<Album>();
        String         request = "select * from gbua_mcunivers.albums";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(request);
            try {
                while (rs.next())
                    albums.add(new Album(rs.getInt("id"), rs.getString("name"), rs.getInt("year"),
                            rs.getString("url"), rs.getString("history"), rs.getString("image_path"),
                            rs.getInt("band")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return albums;
    }

    public HashSet<Article> getArticles( ) {
        Connection con  = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        HashSet<Article> articles = new HashSet<Article>();
        String        request  = "select * from gbua_mcunivers.articles";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(request);
            try {
                while (rs.next())
                    articles.add(new Article(rs.getInt("id"), rs.getString("title"), rs.getString("content")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return articles;
    }


    public Genre getGenre(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Genre genre = null;

        String request = "select * from gbua_mcunivers.genres where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            genre = new Genre(rs.getInt("id"), rs.getString("name"), rs.getString("history"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return genre;
    }

    public Subgenre getSubgenre(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Subgenre subgenre = null;

        String request = "select * from gbua_mcunivers.subgenres where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            subgenre = new Subgenre(
                    rs.getInt("id"), rs.getInt("parent"), rs.getString("name"), rs.getString("history"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return subgenre;
    }

    public Band getBand(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Band band = null;

        String request = "select * from gbua_mcunivers.bands where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            band = new Band(rs.getInt("id"), rs.getString("name"), rs.getString("history"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return band;
    }

    public Album getAlbum(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Album album = null;

        String request = "select * from gbua_mcunivers.albums where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            album = new Album(
                    rs.getInt("id"), rs.getString("name"), rs.getInt("year"),
                    rs.getString("url"), rs.getString("history"), rs.getString("image_path"),
                    rs.getInt("band"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return album;
    }

    public Article getArticle(int id) {
        Connection        con     = null;
        PreparedStatement stmt    = null;
        ResultSet         rs      = null;
        Article           article = null;

        String request = "select * from gbua_mcunivers.articles where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("content"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return article;
    }

    /*UPDATE*/

    public int updateArticle(int id, String title, String content) {
        int changed = 0;

        String request = "update gbua_mcunivers.articles set title = ?, content = ? " +
                "where id = ?";

        changed = update(request, title, content, id, changed);

        return changed > 0 ? 1 : changed;
    }

    public int updateGenre(int id, String name, String history) {
        int changed = 0;

        String request = "update gbua_mcunivers.genres set name = ?, history = ? " +
                "where id = ?";

        changed = update(request, name, history, id, changed);

        return changed > 0 ? 1 : changed;
    }

    public int updateSubgenre(int id, int parent, String name, String history) {
        Connection con = null;
        PreparedStatement stmt = null;
        int changed = 0;

        String request = "update gbua_mcunivers.subgenres set parent = ?, name = ?, history = ? " +
                "where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, parent);
            stmt.setString(2, name);
            stmt.setString(3, history);
            stmt.setInt(4, id);
            changed = stmt.executeUpdate();
        } catch (SQLException e) {
            changed = -1;
            e.printStackTrace();
        } finally {
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return changed;
    }

    public int updateBand(int id, String name, String history) {
        int changed = 0;

        String request = "update gbua_mcunivers.bands set name = ?, history = ? " +
                "where id = ?";

        changed = update(request, name, history, id, changed);

        return changed;
    }

    public int updateAlbum(int id, String name, int year, String url, String history, String imagePath, int band) {
        Connection con = null;
        PreparedStatement stmt = null;
        int changed = 0;

        String request = "update gbua_mcunivers.albums set " +
                "name = ?, , year = ?, url = ?, history = ?, image_path = ?, band = ?" +
                "where id = ?";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setString(1, name);
            stmt.setInt(2, year);
            stmt.setString(3, url);
            stmt.setString(4, history);
            stmt.setString(5, imagePath);
            stmt.setInt(6, band);
            stmt.setInt(7, id);
            changed = stmt.executeUpdate();
        } catch (SQLException e) {
            changed = -1;
            e.printStackTrace();
        } finally {
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return changed;
    }



    private int update(String request, String param_1, String param_2, int param_3, int changedIn) {
        Connection con  = null;
        PreparedStatement  stmt = null;

        int changedOut = changedIn;
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setString(1, param_1);
            stmt.setString(2, param_2);
            stmt.setInt(3, param_3);
            changedOut = stmt.executeUpdate();
        } catch (SQLException e) {
            changedOut = -1;
            e.printStackTrace();
        } finally {
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return changedOut;
    }



    public boolean insertArticle(String title, String content) {
        boolean result = false;
        String request = "insert into gbua_mcunivers.articles (title, content) values"
                + "(?,?)";

        result = insert(request, title, content, result);

        return result;
    }

    public boolean insertGenre(String name, String history) {
        boolean result = false;
        String request = "insert into gbua_mcunivers.genres (name, history) values"
                + "(?,?)";

        result = insert(request, name, history, result);

        return result;
    }

    public boolean insertSubgenre(int parent, String name, String history) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean result = false;

        String request = "insert into gbua_mcunivers.subgenres (parent, name, history) values" +
                "(?,?,?)";

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setInt(1, parent);
            stmt.setString(2, name);
            stmt.setString(3, history);
            stmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        } finally {
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean insert(String request, String param_1, String param_2, boolean resultIn) {
        Connection con = null;
        PreparedStatement stmt = null;

        boolean resultOut = resultIn;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stmt = con.prepareStatement(request);
            stmt.setString(1, param_1);
            stmt.setString(2, param_2);
            stmt.executeUpdate();
            resultOut = true;
        } catch (SQLException e) {
            e.printStackTrace();
            resultOut = false;
        } finally {
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultOut;
    }
}