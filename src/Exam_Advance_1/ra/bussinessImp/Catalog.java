package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.Scanner;

import static Exam_Advance_1.ra.run.ProductManagement.*;


public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String description;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String description, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id danh mục: ");
        while (true) {
            String idStr = (scanner.nextLine());
            if (!idStr.equals("")) {
                int id = Integer.parseInt(idStr);
                if (findByIdCatalog(id) != null) {
                    System.err.println("Mã id đã tồn tại mời nhập lại!");
                } else {
                    this.catalogId = id;
                    break;
                }
            } else {
                System.err.println("Không được để rỗng");
            }
        }
        System.out.println("Nhập tên danh mục: ");
        while (true) {
            String name = scanner.nextLine();
            boolean check = true;
            if (!name.equals("")) {
                for (Catalog catalog : catalogList) {
                    if (catalog.getCatalogName().equals(name)) {
                        System.err.println("Tên danh mục đã tồn tại.");
                        check = false;
                    }
                }
                if (check) {
                    this.catalogName = name;
                    break;
                }
            } else {
                System.err.println("Không được để trống.");
            }
        }
        System.out.println("Nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả: ");
        this.description = scanner.nextLine();
        System.out.println("Nhập trạng thái: ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + catalogId + " | Danh mục: " + catalogName);
        System.out.println("Độ ưu tiên: " + priority + " | Mô tả: " + description);
        System.out.println("Trạng thái: " + catalogStatus);
    }
}
