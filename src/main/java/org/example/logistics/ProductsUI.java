package org.example.logistics;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsUI {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("조회할 Product ID를 입력하세요: ");
        int productId = scanner.nextInt();

        ProductsDAO dao = new ProductsDAO(); // 1-2단계 실행!
        ProductsVO product = dao.one(productId); // 사용자 입력 ID로 조회

        if (product != null) {
            System.out.println("검색한 Product ID>> " + product.getProductId());
            System.out.println("검색한 Product Name>> " + product.getName());
            System.out.println("검색한 Product Description>> " + product.getDescription());
            System.out.println("검색한 Product Category ID>> " + product.getCategoryId());
            System.out.println("검색한 Product Price>> " + product.getPrice());
            System.out.println("검색한 Product Created At>> " + product.getCreatedAt());
            System.out.println("검색한 Manufacturer ID>> " + product.getManufacturerId());
        } else {
            System.out.println("해당 Product ID에 대한 정보가 없습니다.");
        }

        scanner.close();
    }
}
