package org.example.logistics.warehouse_inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse_InventoryUI {
    public static void main(String[] args) throws Exception {
        Warehouse_InventoryDAO dao = new Warehouse_InventoryDAO();
        Scanner sc = new Scanner(System.in);

        System.out.print("창고 id: ");
        int id = sc.nextInt();

        ArrayList<Warehouse_InventoryVO> list = dao.getAllInventoryDAO(id);
        System.out.println("=====재고 목록=====");
        System.out.println("| ID" + " | 상품 이름 " + " | 가격" + " | 수량 |");
        for (Warehouse_InventoryVO bag : list) {
            System.out.println("| " +bag.getProductId() + " | " + bag.getProductName() + " | " + bag.getProductPrice() + " | " + bag.getQuantity() + " |");
        }
    }
}