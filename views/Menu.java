package views;

import controller.ProductManager;
import model.Product;
import storage.ReadAndWriteCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static ProductManager productManager = new ProductManager();

    public static void begin() {
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi từ file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            doYourChoice(choice);
        } while (choice != 9);
    }

    private static void doYourChoice(int choice) {
        switch (choice) {
            case 1 -> productManager.showProduct();
            case 2 -> addproduct(productManager);
            case 3 -> productManager.editProduct();
            case 4 -> deleteProduct(productManager);
            case 5 -> sort();
            case 6 -> productManager.findMaxCost();
            case 7 -> ReadAndWriteCSV.getInstance().readFileProductList(productManager.getProductArrayList());
            case 8 -> ReadAndWriteCSV.getInstance().writeProductToCSV(productManager.getProductArrayList());
            case 9 -> System.out.println("OUT");
        }
    }
    private static void deleteProduct(ProductManager productManager) {
        System.out.println("nhập mã sản phẩm muốn xóa: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        productManager.deleteProduct(code);
    }

    private static void addproduct(ProductManager productManager) {
        productManager.addProduct(Menu.createProduct());
    }

    public static Product createProduct() {
        System.out.println("Nhập mã sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        String productCode = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        Scanner scanner1 = new Scanner(System.in);
        String productName = scanner1.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        Scanner scanner2 = new Scanner(System.in);
        int productPrice = scanner2.nextInt();
        System.out.println("Nhập số lượng sản phẩm: ");
        Scanner scanner3 = new Scanner(System.in);
        int productAmount = scanner3.nextInt();
        System.out.println("Nhập mô tả sản phẩm: ");
        String productDescribe = scanner.nextLine();
        return new Product(productCode, productName, productPrice, productAmount, productDescribe);
    }
    private static void sort(){
        {
            int choice1;
            System.out.println("1. Sắp xếp tăng dần");
            System.out.println("2. Sắp xếp giảm dần");
            Scanner scanner5 = new Scanner(System.in);
            choice1 = Integer.parseInt(scanner5.nextLine());
            switch (choice1) {
                case 1 -> productManager.sortByIncreaseCost();
                case 2 -> productManager.sortByDecreaseCost();
            }
        }
    }
}
