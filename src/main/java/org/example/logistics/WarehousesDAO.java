package org.example.logistics;

import java.sql.*;
import java.util.ArrayList;

public class WarehousesDAO {
    Connection con;

    public WarehousesDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 성공!");

        String url = "jdbc:mysql://localhost:3306/warehouse_db";
        String id = "root";
        String pw = "1234";
        con = DriverManager.getConnection(url, id, pw);
        System.out.println("2. DB 연결 성공!");
    }

    public WarehousesVO one(int warehouseId) throws SQLException {
        WarehousesVO warehouse = new WarehousesVO();

        String sql = "SELECT * FROM Warehouses WHERE warehouse_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, warehouseId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            warehouse.setWarehouseId(rs.getInt("warehouse_id"));
            warehouse.setName(rs.getString("name"));
            warehouse.setLocation(rs.getString("location"));
            warehouse.setCapacity(rs.getInt("capacity"));
        }
        return warehouse;
    }

    public ArrayList<WarehousesVO> list() throws SQLException {
        ArrayList<WarehousesVO> list = new ArrayList<>();

        String sql = "SELECT * FROM Warehouses";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            WarehousesVO warehouse = new WarehousesVO();
            warehouse.setWarehouseId(rs.getInt("warehouse_id"));
            warehouse.setName(rs.getString("name"));
            warehouse.setLocation(rs.getString("location"));
            warehouse.setCapacity(rs.getInt("capacity"));
            list.add(warehouse);
        }
        return list;
    }
}
