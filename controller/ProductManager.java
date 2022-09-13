package controller;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> productArrayList = new ArrayList();
    public void addProduct(Product p){
        productArrayList.add(p);
    }
    public void showProduct(){
        for (Product product : productArrayList) {
            System.out.println(product);
        }
    }
    public void showProduct(ArrayList<Product> products){
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public void deleteProduct(String productCode){
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getProductCode().equals(productCode)){
                productArrayList.remove(productArrayList.get(i));
                break;
            }
        }
    }
    public ArrayList<Product> sortByIncreaseCost(){
        Collections.sort(productArrayList);
        return productArrayList;
    }
    public ArrayList<Product> sortByDecreaseCost(){
        ArrayList<Product> arrayList;
        arrayList = sortByIncreaseCost();
        Collections.reverse(arrayList);
        return arrayList;
    }
    public void findMaxCost(){
        ArrayList<Product> arrayList;
        arrayList = sortByDecreaseCost();
        System.out.println("The product with the greatest price is: "+arrayList.get(0));
    }
    public Product createProduct(String productCode, String productName, int cost, int productAmount, String productDescribe){
        return new Product(productCode,productName,cost,productAmount,productDescribe);
    }
    public int getsize(){
       return productArrayList.size();
    }
    public Product get(int index){
       return productArrayList.get(index);
    }
    public void editProduct() {
        System.out.println("Nhập vào mã sản phẩm cần sửa");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        for (Product a : productArrayList) {
            if (a.getProductCode().equals(code)) {
                System.out.println("Nhập mã sản phẩm muốn sửa: ");
                Scanner scanner1 = new Scanner(System.in);
                String productCode = scanner1.nextLine();
                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                Scanner scanner2 = new Scanner(System.in);
                String productName = scanner2.nextLine();
                System.out.println("Nhập giá sản phẩm muốn sửa: ");
                Scanner scanner3 = new Scanner(System.in);
                int productPrice = Integer.parseInt(scanner3.nextLine());
                System.out.println("Nhập số lượng sản phẩm muốn sửa: ");
                Scanner scanner4 = new Scanner(System.in);
                int productAmount = Integer.parseInt(scanner4.nextLine());
                System.out.println("Nhâp mô tả sản phẩm cần sửa: ");
                Scanner scanner5 = new Scanner(System.in);
                String productDescribe = scanner5.nextLine();
                a.setProductCode(productCode);
                a.setProductName(productName);
                a.setCost(productPrice);
                a.setProductAmount(productAmount);
                a.setProductDescribe(productDescribe);
            } else {
                System.out.println("Không tìm được sản phẩm ");
            }
        }
    }
    public void productRemove(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm muốn xóa: ");
        String productCode = scanner.nextLine();
        for (Product a : productArrayList) {
            if (a.getProductCode().equals(productCode)) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm ?");
                System.out.println("Y: Đồng ý xóa.");
                System.out.println("Nhập ký tự bất kỳ để thoát");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    productArrayList.remove(a);
                    break;
                }

            } else {
                System.out.println("Không tìm được sản phẩm");
            }
        }
    }
    public ArrayList<Product> getProductArrayList(){
        return productArrayList;
    }
}

