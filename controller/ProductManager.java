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
        int index = -1;
        boolean check = false;
        System.out.println("Nhập vào mã sản phẩm cần sửa");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        for (int i =0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getProductCode().equals(code)) {
                check = true;
                index = i;
                break;
            }
        }
        if (check){
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
            productArrayList.get(index).setProductCode(productCode);
            productArrayList.get(index).setProductName(productName);
            productArrayList.get(index).setCost(productPrice);
            productArrayList.get(index).setProductAmount(productAmount);
            productArrayList.get(index).setProductDescribe(productDescribe);
        }
        else System.out.println("khong tim thay");
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
    public void show5Product(int index){
        int indexbegin = index + 5;
        if (index < productArrayList.size() && indexbegin < productArrayList.size()) {
            for (int i = 0; i < indexbegin; i++) {
                System.out.println(productArrayList.get(i));
            }
            System.out.println("tiep tuc 5 san pham an Enter( an nut khac bang out):");
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            if (a == "")
            show5Product(indexbegin);
            else System.out.println("out");
        }
        else if (indexbegin < productArrayList.size()){
            for (int i = indexbegin; i < productArrayList.size(); i++) {
                System.out.println(productArrayList.get(i));
            }
        }
        else {System.out.println("het");}
    }
}

