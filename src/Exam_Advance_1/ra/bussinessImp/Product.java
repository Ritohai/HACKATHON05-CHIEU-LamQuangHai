package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.Scanner;

import static Exam_Advance_1.ra.run.ProductManagement.*;


public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String description;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String description, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm: ");
        while (true) {
            String idStr = scanner.nextLine();
            if (!idStr.equals("")) {
                int id = Integer.parseInt(idStr);
                if (findByIdProduct(id) != null) {
                    System.err.println("Mã id đã tồn tại, mời nhập lại.");
                } else {
                    this.productId = id;
                    break;
                }
            } else {
                System.err.println("Không để rỗng.");
            }
        }
        System.out.println("Nhập tên sản phẩm: ");
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("")) {
                System.err.println("Không được để rỗng.");
            } else {
                this.productName = name;
                break;
            }
        }
        System.out.println("Nhập tiêu đề: ");
        this.title = scanner.nextLine();
        System.out.println("Nhập mô tả: ");
        this.description = scanner.nextLine();
        for (Catalog catalog1 : catalogList) {
            if (catalog1 != null) {
                System.out.println("--------------------------------------------------");
                System.out.println("ID: " + catalog1.getCatalogId() + " | Danh mục:  " + catalog1.getCatalogName());
            }
        }
        System.out.println("Chọn danh mục: ");
        while (true) {
            int id = scanner.nextInt();
            boolean flag = false;
            for (Catalog catalog : catalogList) {
                if (catalog != null && catalog.getCatalogId() == id) {
                    flag = true;
                    this.catalog = catalog;
                    break;
                }
            }
            if (!flag) {
                System.err.println("ID không đúng, vui lòng nhập lại!!!");
            } else {
                break;
            }
        }
        System.out.println("Nhập giá nhập: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        this.exportPrice = importPrice * RATE;
        System.out.println("Nhập trạng thái: ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + productId + " | Tên sản phẩm: " + productName);
        System.out.println("Tiêu đề: " + title + " | Mô tả: " + description);
        System.out.println("Danh mục: " + catalog.getCatalogName() + " | Giá nhập: " + importPrice);
        System.out.println("Giá bán: " + exportPrice + " | Trạng thái: " + (productStatus ? "Còn hàng" : "Hết hàng"));

    }
}
