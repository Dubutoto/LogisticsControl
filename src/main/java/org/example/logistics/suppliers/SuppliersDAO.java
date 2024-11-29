package org.example.logistics.suppliers;

import org.example.logistics.DatabaseConnection;

import java.sql.*;

public class SuppliersDAO {
    Connection con;
    //Create
    public void addSupplier(SuppliersVO supplier) throws SQLException, ClassNotFoundException {
        String query = "Insert into suppliers (supplier_id, name, contact, location) values (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, supplier.getSupplierId());
            pstmt.setString(2, supplier.getSupplierName());
            pstmt.setString(3, supplier.getSupplierContact());
            pstmt.setString(4, supplier.getSupplierLocation());
            pstmt.executeUpdate();

            System.out.println("Supplier added successfully");
        }
    }

    //Read
    public SuppliersVO getSupplier(int supplierId) throws SQLException, ClassNotFoundException {
        String query = "Select * from suppliers where supplier_id=?";
        SuppliersVO supplier = null;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, supplierId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    supplier = new SuppliersVO();
                    supplier.setSupplierId(rs.getInt("supplier_id"));
                    supplier.setSupplierName(rs.getString("supplier_name"));
                    supplier.setSupplierContact(rs.getString("supplier_contact"));
                    supplier.setSupplierLocation(rs.getString("supplier_location"));
                }
            }
        }
        return supplier;
    }

    //Update
    public void updateSupplier(SuppliersVO supplier) throws SQLException, ClassNotFoundException {
        String query = "UPDATE suppliers SET supplier_name = ?, supplier_contact = ?, supplier_location = ? WHERE supplier_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, supplier.getSupplierName());
            pstmt.setString(2, supplier.getSupplierContact());
            pstmt.setString(3, supplier.getSupplierLocation());
            pstmt.setInt(4, supplier.getSupplierId());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Supplier updated successfully!");
            }
        }
    }

    //Delete
    public void deleteSupplier(int supplierId) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM suppliers WHERE supplier_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, supplierId);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Supplier deleted successfully!");
            }
        }
    }

    public SuppliersVO one(int supplierId) throws SQLException {
        SuppliersVO supplier = new SuppliersVO();

        String sql = "SELECT * FROM Suppliers WHERE supplier_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, supplierId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            supplier.setSupplierId(rs.getInt("supplier_id"));
            supplier.setSupplierName(rs.getString("name"));
            supplier.setSupplierContact(rs.getString("contact"));
            supplier.setSupplierLocation(rs.getString("location"));
        }
        return supplier;
    }
}
