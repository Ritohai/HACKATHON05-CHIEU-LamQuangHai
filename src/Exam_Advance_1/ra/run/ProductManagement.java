package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussiness.IShop;
import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    static Scanner scanner = new Scanner(System.in);
    public static List<Catalog> catalogList = new ArrayList<Catalog>();
    public static List<Product> productList = new ArrayList<Product>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục [10 điểm]\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm [20 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) [10 điểm]\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm [05 điểm]\n" +
                    "5. Thoát [05 điểm]");
            System.out.println("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortPrice();
                    break;
                case 4:
                    searchCatalog();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại từ 1-5!");
                    break;
            }
        }
    }

    public static void addCatalog() {
        System.out.println("Nhập số danh mục muốn thêm: ");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            Catalog catalog = new Catalog();
            System.out.println("Nhập danh mục thứ " + (i + 1));
            catalog.inputData();
            catalogList.add(catalog);
        }
        System.out.println("Thêm thành công.");
    }

    public static void addProduct() {
        System.out.println("Nhập số sản phẩm muốn thêm: ");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            Product product = new Product();
            System.out.println("Nhập danh mục thứ " + (i + 1));
            product.inputData();
            productList.add(product);
        }
        System.out.println("Thêm thành công.");
        System.out.println("--------------------------------");
        System.out.println("Danh sách sản phẩm : ");
        for (Product product : productList) {
            product.displayData();
        }
        System.out.println("--------------------------------");
    }

    public static void sortPrice() {
        Collections.sort(productList, new Comparator<IShop>() {
            @Override
            public int compare(IShop product1, IShop product2) {
                return Float.compare(((Product) product1).getExportPrice(), ((Product) product2).getExportPrice());
            }
        });
        System.out.println("Danh sách đã được sắp xếp theo giá tăng dần.");
        for (Product product : productList) {
            product.displayData();
        }
    }

    public static void searchCatalog() {
        System.out.println("Nhập tên danh mục cần tìm kiếm: ");
        String nameCatalog = scanner.next();
        for (Product product : productList) {
            if (product.getCatalog().getCatalogName().equalsIgnoreCase(nameCatalog)) {
                product.displayData();
            }
        }
    }

    public static Catalog findByIdCatalog(int id) {
        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getCatalogId() == id) {
                return catalogList.get(i);
            }
        }
        return null;
    }

    public static Product findByIdProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }
}
