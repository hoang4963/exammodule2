package views;

import controller.ProductManager;
import model.Product;
import storage.ReadAndWriteCSV;

import java.util.Scanner;

public class Menu {
    public static final int FISRTCHOSEN = 1;
    public static final int SECONDCHOSEN = 2;
    public static final int THIRDCHOSEN = 3;
    public static final int FOURTHCHOSEN = 4;
    public static final int FIFTHCHOSEN = 5;
    public static final int SIXTHCHOSEN = 6;
    public static final int SEVENTHCHOSEN = 7;
    public static final int EIGHTHCHOSEN = 8;
    public static final int NINETHCHOSEN = 9;
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
            case FISRTCHOSEN -> productManager.show5Product(0);
            case SECONDCHOSEN -> addproduct(productManager);
            case THIRDCHOSEN -> productManager.editProduct();
            case FOURTHCHOSEN -> deleteProduct(productManager);
            case FIFTHCHOSEN -> sort();
            case SIXTHCHOSEN -> productManager.findMaxCost();
            case SEVENTHCHOSEN -> ReadAndWriteCSV.getInstance().readFileProductList(productManager.getProductArrayList());
            case EIGHTHCHOSEN -> ReadAndWriteCSV.getInstance().writeProductToCSV(productManager.getProductArrayList());
            case NINETHCHOSEN -> System.out.println("OUT");
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
                case FISRTCHOSEN -> productManager.showProduct(productManager.sortByDecreaseCost());
                case SECONDCHOSEN -> productManager.showProduct(productManager.sortByIncreaseCost());
            }
        }
    }
}
