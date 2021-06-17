/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Main.MyDB;
<<<<<<< HEAD
import static Main.view.BookController.id;
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
import Util.Levenshtein_distance_algorithm;
import static Util.Levenshtein_distance_algorithm.levenshtein_distance_algorithm;
import entity.Book;
import entity.Category;
import entity.User;
import iservice.ibook;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.time.Year;
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Aoe Neko 98
 */
public class BookService implements ibook {

    Connection conn;

    public BookService() {
        this.conn = MyDB.getInstance().getConnexion();

    }

    @Override
    public void addBook(Book b) {

        String sql = "INSERT INTO `book1` (`nom`, `type`, `description`, `Prix`, `Image`,`categorie`,`user`,`isbn`  ) VALUES ( '" + b.getNom() + "', '" + b.getType() + "', '" + b.getDiscreption()
<<<<<<< HEAD
                + "', '" + b.getPrix() + "', '" + b.getImage() + "','" + b.getCategory().getId() + "','" + id + "', '" + b.getIsbn() + "');";
=======
                + "', '" + b.getPrix() + "', '" + b.getImage() + "','" + b.getCategory().getId() + "','" + '1' + "', '" + b.getIsbn() + "');";
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add Done");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    @Override
    public void editBook(Book b) {
        String sql = "UPDATE `book1` SET `nom` = '" + b.getNom() + "', `type` = '" + b.getType() + "', `description` = '" + b.getDiscreption() + "', `Prix` = '" + b.getPrix() + "', `Image` = '" + b.getImage() + "', `categorie` = '" + b.getCategory().getId()
<<<<<<< HEAD
                + "', `isbn` = '" + b.getIsbn() + "' WHERE `book1`.`id` = " + b.getId() + " ;";
=======
                + "', `isbn` = '" + b.getIsbn() + "' WHERE `book1`.`id` = '" + b.getId() + "';";
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update Done");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void deleteBook(Book b) {
        System.out.println(b);
        String sql = "DELETE FROM `book1` WHERE `book1`.`id` = " + b.getId() + "";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    @Override
    public Book showBook(Book b) {
        Book book = new Book();
        ResultSet rs = null;
        String sql = "SELECT * FROM book1 WHERE id = " + b.getId() + ";";
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            rs.next();
            book = new Book(rs.getString("nom"), rs.getString("type"), rs.getString("description"));
            System.out.println(book.toString());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return book;

    }

    public List<Book> searchBookByName(String name, Category cate, String t, float p) {
        List<Book> ls = new ArrayList<>();
        ResultSet rs;
        Book book;
        String sql;
        if (cate != null) {

<<<<<<< HEAD
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id_User  inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%' && c.nom like '%" + cate + "%' && b.type like '%" + t + "%' && b.prix >='" + p + "' && b.user="+id+" ;";
        } else {
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id_User inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%'&& b.type like '%" + t + "%' && b.prix >= '" + p + "' && b.user ="+id+";";
=======
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id  inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%' && c.nom like '%" + cate + "%' && b.type like '%" + t + "%' && b.prix >='" + p + "';";
        } else {
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%'&& b.type like '%" + t + "%' && b.prix >= '" + p + "' ;";
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        }

        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {
                book = new Book();
                Category cat = new Category();
                User us = new User();
                cat.setId(rs.getInt("c.id"));
                cat.setDescription(rs.getString("c.description"));
                cat.setNom(rs.getString("c.nom"));
<<<<<<< HEAD
                us.setId(rs.getInt("u.id_User"));
=======
                us.setId(rs.getInt("u.id"));
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
                us.setNom(rs.getString("u.nom"));
                book.setCategory(cat);
                book.setUser(us);
                book.setNom(rs.getString("b.nom"));
                book.setType(rs.getString("b.type"));
                book.setDiscreption(rs.getString("b.description"));
                book.setId(rs.getInt("b.id"));
                book.setPrix(rs.getFloat("b.prix"));
                book.setImage(rs.getString("b.image"));
                book.setIsbn(rs.getString("b.isbn"));

                System.out.println(book.toString());
                ls.add(book);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ls;

    }
<<<<<<< HEAD
   
=======

>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    public List<Book> searchMyBookByName(String name, Category cate, String t, float p) {

        List<Book> ls = new ArrayList<>();
        ResultSet rs;
        Book book;
        String sql;
        if (cate != null) {

<<<<<<< HEAD
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id_User  inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%' && c.nom like '%" + cate + "%' && b.type like '%" + t + "%' && b.prix >='" + p + "' && b.user="+ id +";";
        } else {
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id_User inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%'&& b.type like '%" + t + "%' && b.prix >= '" + p + "' && b.user="+ id +";";
=======
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id  inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%' && c.nom like '%" + cate + "%' && b.type like '%" + t + "%' && b.prix >='" + p + "' && b.user=1 ;";
        } else {
            sql = "SELECT * FROM book1 b inner join user u on b.user= u.id inner join categorie c on b.categorie = c.id where b.nom Like '%" + name + "%'&& b.type like '%" + t + "%' && b.prix >= '" + p + "' && b.user=1 ;";
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        }

        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {
                book = new Book();
                Category cat = new Category();
                User us = new User();
                cat.setId(rs.getInt("c.id"));
                cat.setDescription(rs.getString("c.description"));
                cat.setNom(rs.getString("c.nom"));
<<<<<<< HEAD
                us.setId(rs.getInt("u.id_User"));
=======
                us.setId(rs.getInt("u.id"));
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
                us.setNom(rs.getString("u.nom"));
                book.setCategory(cat);
                book.setUser(us);
                book.setNom(rs.getString("b.nom"));
                book.setType(rs.getString("b.type"));
                book.setDiscreption(rs.getString("b.description"));
                book.setId(rs.getInt("b.id"));
                book.setPrix(rs.getFloat("b.prix"));
                book.setImage(rs.getString("b.image"));
                book.setIsbn(rs.getString("b.isbn"));

                System.out.println(book.toString());
                ls.add(book);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ls;

    }

    public List<Book> showAllBooks() {
        List<Book> ls = new ArrayList<>();
        ResultSet rs;
        Book book;
<<<<<<< HEAD
        String sql = "SELECT * FROM book1 b inner join categorie c on b.categorie = c.id inner join user u on b.user = u.id_User  ;";
=======
        String sql = "SELECT * FROM book1 b inner join categorie c on b.categorie = c.id inner join user u on b.user = u.id  ;";
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {
                book = new Book();
                Category cat = new Category();
                User us = new User();

<<<<<<< HEAD
                us.setId(rs.getInt("u.id_User"));
=======
                us.setId(rs.getInt("u.id"));
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
                us.setNom(rs.getString("u.nom"));
                cat.setId(rs.getInt("c.id"));
                cat.setDescription(rs.getString("c.description"));
                cat.setNom(rs.getString("c.nom"));

                book.setCategory(cat);
                book.setNom(rs.getString("b.nom"));
                book.setType(rs.getString("b.type"));
                book.setDiscreption(rs.getString("b.description"));
                book.setId(rs.getInt("b.id"));
                book.setPrix(rs.getFloat("b.prix"));
                book.setImage(rs.getString("b.image"));
                book.setUser(us);
                book.setIsbn(rs.getString("b.isbn"));

                System.out.println(book.toString());
                ls.add(book);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ls;

    }
<<<<<<< HEAD
    
    public List<Book> showMyBooks(int y) {
        List<Book> ls = new ArrayList<>();
        ResultSet rs;
        Book book;
        String sql = "SELECT * FROM book1 b inner join categorie c on b.categorie = c.id inner join user u on b.user = u.id_User WHERE b.user = "+y+" ;";
=======

    public List<Book> showMyBooks() {
        List<Book> ls = new ArrayList<>();
        ResultSet rs;
        Book book;
        String sql = "SELECT * FROM book1 b inner join categorie c on b.categorie = c.id inner join user u on b.user = u.id WHERE b.user = 1 ;";
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {
                book = new Book();
                Category cat = new Category();
                User us = new User();

<<<<<<< HEAD
                us.setId(rs.getInt("u.id_User"));
=======
                us.setId(rs.getInt("u.id"));
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
                us.setNom(rs.getString("u.nom"));
                cat.setId(rs.getInt("c.id"));
                cat.setDescription(rs.getString("c.description"));
                cat.setNom(rs.getString("c.nom"));

                book.setCategory(cat);
                book.setNom(rs.getString("b.nom"));
                book.setType(rs.getString("b.type"));
                book.setDiscreption(rs.getString("b.description"));
                book.setId(rs.getInt("b.id"));
                book.setPrix(rs.getFloat("b.prix"));
                book.setImage(rs.getString("b.image"));
                book.setUser(us);
                book.setIsbn(rs.getString("b.isbn"));

                System.out.println(book.toString());
                ls.add(book);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ls;

    }

    public double maxPrice() {

        ResultSet rs;
        double p = 0;
        float f;

        String sql = "SELECT MAX(Prix) AS price FROM book1   ; ";
        try {

            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {

                f = rs.getFloat("price");

                p = (double) f;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return p;

    }

    public Map<String, Integer> similaire(String s) {
        SortedMap<String, Integer> h = new TreeMap<>();
        ResultSet rs;
        String sql = "SELECT * FROM book1 b ;";

        try {

            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {
                h.put(rs.getString("b.nom"), levenshtein_distance_algorithm(s, rs.getString("b.nom")));

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return h;

    }

}
