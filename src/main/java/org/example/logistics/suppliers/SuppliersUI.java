package org.example.logistics.suppliers;

import java.sql.SQLException;
import java.util.Scanner;

public class SuppliersUI {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.print("조회할 Supplier ID를 입력하세요: ");
        String SupplierId = sc.next();

        SuppliersDAO dao = new SuppliersDAO(); // 1-2단계 실행!
        SuppliersVO supplier = dao.one(Integer.parseInt(SupplierId)); // 사용자 입력 ID로 조회

        if (supplier != null) {
            System.out.println("검색한 Supplier ID>> " + supplier.getSupplierId());
            System.out.println("검색한 Supplier Name>> " + supplier.getSupplierName());
            System.out.println("검색한 Supplier Contact>> " + supplier.getSupplierContact());
            System.out.println("검색한 Supplier Location>> " + supplier.getSupplierLocation());
        } else {
            System.out.println("해당 Supplier ID에 대한 정보가 없습니다.");
        }

        sc.close();
    }
}
