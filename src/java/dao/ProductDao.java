package dao;

import java.sql.*;
import java.util.*;

import model.Cart;
import model.Product;

public class ProductDao {

    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDao(Connection con) {
        super();
        this.con = con;
    }

    public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        try {

            query = "select * from products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setTitle(rs.getString("title"));
                row.setPrice(rs.getDouble("price"));
                row.setThumbnail(rs.getString("thumbnail"));
                row.setCombinedCategories(rs.getString("combinedCategories"));

                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }

    public Product getSingleProduct(int id) {
        Product row = null;
        try {
            query = "select * from products where id=? ";

            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setTitle(rs.getString("title"));
                row.setPrice(rs.getDouble("price"));
                row.setThumbnail(rs.getString("thumbnail"));
                row.setRating(rs.getDouble("rating"));
                row.setReview(rs.getInt("review"));
                row.setDescription(rs.getString("description"));
                row.setAvailability(rs.getBoolean("availability"));
                row.setWeight(rs.getDouble("weight"));
                row.setAmount(rs.getInt("amount"));
                row.setCategoryName(rs.getString("categoryName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return row;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        System.out.println("==========cartList=========: " + cartList);

        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("==========SUM=========: " + sum);

        return sum;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setTitle(rs.getString("title"));
                        row.setPrice(rs.getDouble("price") * item.getQuantity());
                        row.setThumbnail(rs.getString("thumbnail"));
                        row.setCategoryName(rs.getString("categoryName"));
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
}
