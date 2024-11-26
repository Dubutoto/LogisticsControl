package org.example.logistics;

import java.sql.*;
import java.util.ArrayList;

public class Warehouse_InventoryDAO {
    Connection con;

    public Warehouse_InventoryDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 성공!");

        String url = "jdbc:mysql://localhost:3306/warehouse_db";
        String id = "root";
        String pw = "1234";
        con = DriverManager.getConnection(url, id, pw);
        System.out.println("2. DB 연결 성공!");
    }

    public Warehouse_InventoryVO one(int inventoryId) throws SQLException {
        Warehouse_InventoryVO inventory = new Warehouse_InventoryVO();

        String sql = "SELECT * FROM Warehouse_Inventory WHERE inventory_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, inventoryId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            inventory.setInventoryId(rs.getInt("inventory_id"));
            inventory.setWarehouseId(rs.getInt("warehouse_id"));
            inventory.setProductId(rs.getInt("product_id"));
            inventory.setQuantity(rs.getInt("quantity"));
            inventory.setLastUpdated(rs.getString("last_updated"));
        }
        return inventory;
    }

    public ArrayList<Warehouse_InventoryVO> list() throws SQLException {
        ArrayList<Warehouse_InventoryVO> list = new ArrayList<>();

        String sql = "SELECT * FROM Warehouse_Inventory";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Warehouse_InventoryVO inventory = new Warehouse_InventoryVO();
            inventory.setInventoryId(rs.getInt("inventory_id"));
            inventory.setWarehouseId(rs.getInt("warehouse_id"));
            inventory.setProductId(rs.getInt("product_id"));
            inventory.setQuantity(rs.getInt("quantity"));
            inventory.setLastUpdated(rs.getString("last_updated"));
            list.add(inventory);
        }
        return list;
    }
}

