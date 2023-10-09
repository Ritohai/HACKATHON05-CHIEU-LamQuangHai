package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Queue<String> queue = new LinkedList<String>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    nextParent();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại từ 1-3!");
                    break;
            }
        }
    }
    public static void add() {
        System.out.println("Nhập tên phụ huynh: ");
        String parent = scanner.nextLine();
        queue.offer(parent);
    }
    public static void nextParent() {
        if(!queue.isEmpty()) {
            String next = queue.poll();
            System.out.println("Phụ huynh đầu tiên: "+next);
        } else {
            System.out.println("Không có phụ huynh nào.");
        }
    }
}