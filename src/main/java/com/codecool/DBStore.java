package com.codecool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBStore extends Store{


    @Override
    public List<Product> getAllProducts() {

        List<Product> ps = new ArrayList<>();

        String sql = "SELECT * FROM products";

        try (Connection conn = this.getDBConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
              Product p =  createProduct(rs.getString("type"),
                        rs.getString("name"),
                        rs.getInt("size"),
                        rs.getInt("price"));
              ps.add(p);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ps;
    }

    @Override
    public void storeCDProduct(String name, int price, int tracks) {

        Connection c = getDBConnection();

        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = "INSERT INTO products (name, size, type, price) VALUES " +
                    "('"+ name +"',"+ tracks + ", 'cd', " + price +");";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void storeBookProduct(String name, int price, int pages) {
        Connection c = getDBConnection();

        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            String sql = "INSERT INTO products (name, size, type, price) VALUES " +
                    "('"+ name +"',"+ pages + ", 'book', " + price +");";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getDBConnection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/palmonoczki",
                            "palmonoczki", "");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

        return c;
    }

    @Override
    public void storeProduct(Product product) {
        if ( product instanceof  CDProduct){
            storeCDProduct(product.getName(), product.getPrice(), ((CDProduct) product).getNumOfTracks());
        }
        else{
            storeBookProduct(product.getName(), product.getPrice(), ((BookProduct)product).getNumOfPages());
        }


    }
}
