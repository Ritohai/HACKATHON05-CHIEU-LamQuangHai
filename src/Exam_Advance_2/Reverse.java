package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    static Scanner scanner = new Scanner(System.in);
    static Stack<String> stringStack = new Stack<String>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    reverseString();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại từ 1-3.");
                    break;
            }
        }
    }

    public static void input() {
        System.out.println("Nhập 1 câu tùy ý: ");
        String inputString = scanner.nextLine();
        String[] words = inputString.split(" ");
        for (String stack : words) {
            stringStack.push(stack);
        }
    }
    public static void reverseString() {
        System.out.println("Câu đảo ngược: ");
        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop() + " ");
        }
        System.out.println();
    }
}