package org.example.logistics;

import java.sql.SQLException;
import java.util.Scanner;

public class WarehousesUI {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.print("조회할 Warehouse ID를 입력하세요: ");
        int warehouseId = sc.nextInt();

        WarehousesDAO dao = new WarehousesDAO(); // 1-2단계 실행!
        WarehousesVO warehouse = dao.one(warehouseId); // 사용자 입력 ID로 조회

        if (warehouse != null) {
            System.out.println("검색한 Warehouse ID>> " + warehouse.getWarehouseId());
            System.out.println("검색한 Warehouse Name>> " + warehouse.getName());
            System.out.println("검색한 Warehouse Location>> " + warehouse.getLocation());
            System.out.println("검색한 Warehouse Capacity>> " + warehouse.getCapacity());
        } else {
            System.out.println("해당 Warehouse ID에 대한 정보가 없습니다.");
        }

        sc.close();
    }
}
