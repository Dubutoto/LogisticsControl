package org.example.logistics;

import java.sql.SQLException;
import java.util.Scanner;

public class Warehouse_InventoryUI {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.print("조회할 Inventory ID를 입력하세요: ");
        int inventoryId = sc.nextInt();

        Warehouse_InventoryDAO dao = new Warehouse_InventoryDAO(); // 1-2단계 실행!
        Warehouse_InventoryVO inventory = dao.one(inventoryId); // 사용자 입력 ID로 조회

        if (inventory != null) {
            System.out.println("검색한 Inventory ID>> " + inventory.getInventoryId());
            System.out.println("검색한 Warehouse ID>> " + inventory.getWarehouseId());
            System.out.println("검색한 Product ID>> " + inventory.getProductId());
            System.out.println("검색한 Quantity>> " + inventory.getQuantity());
            System.out.println("검색한 Last Updated>> " + inventory.getLastUpdated());
        } else {
            System.out.println("해당 Inventory ID에 대한 정보가 없습니다.");
        }

        sc.close();
    }
}
