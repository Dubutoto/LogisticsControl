package org.example.logistics;

import java.sql.*;
import java.util.ArrayList;

public class ProductsDAO {
    Connection con;

    public ProductsDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 성공!");

        String url = "jdbc:mysql://localhost:3306/warehouse_db";
        String id = "root";
        String pw = "1234";
        con = DriverManager.getConnection(url, id, pw);
        System.out.println("2. DB 연결 성공!");
    }

    public ProductsVO one(int productId) throws SQLException {
        ProductsVO product = new ProductsVO();

        String sql = "SELECT * FROM Products WHERE product_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, productId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            product.setProductId(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setCategoryId(rs.getInt("category_id"));
            product.setPrice(rs.getDouble("price"));
            product.setCreatedAt(rs.getString("created_at"));
            product.setManufacturerId(rs.getInt("manufacturer_id"));
        }
        return product;
    }

    public ArrayList<ProductsVO> list() throws SQLException {
        ArrayList<ProductsVO> list = new ArrayList<>();

        String sql = "SELECT * FROM Products";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProductsVO product = new ProductsVO();
            product.setProductId(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setCategoryId(rs.getInt("category_id"));
            product.setPrice(rs.getDouble("price"));
            product.setCreatedAt(rs.getString("created_at"));
            product.setManufacturerId(rs.getInt("manufacturer_id"));
            list.add(product);
        }
        return list;
    }
}
