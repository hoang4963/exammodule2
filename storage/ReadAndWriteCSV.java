package storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteCSV {
        private final String LINK_FILE_CSV = "C:\\Users\\Acer\\Desktop\\codegym\\Module2APJ\\exam\\product.csv";
        private ReadAndWriteCSV(){}
        static ReadAndWriteCSV instance;
        public static ReadAndWriteCSV getInstance(){
            if (instance == null){
                instance = new ReadAndWriteCSV();
            }
            return instance;
        }
        public void writeProductToCSV(ArrayList<Product> products){
            try {
                File file = new File(LINK_FILE_CSV);
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (Product product : products) {
                    bufferedWriter.write(product.getProductCode() + "," + product.getProductName() + "," + product.getCost() + "," + product.getProductAmount() + "," + product.getProductDescribe() + "\n");
                }
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("");
            }
        }
    public ArrayList<Product> readFileProductList(ArrayList<Product> arrayListProduct) {
        try {
            File file = new File(LINK_FILE_CSV);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(strings[0], strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                arrayListProduct.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("");
        }
        return arrayListProduct;
    }
}
