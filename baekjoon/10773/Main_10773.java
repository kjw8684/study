// https://www.acmicpc.net/problem/10773

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Stack;
import java.util.Scanner;

public class Main_10773 {

    public static boolean setStdin(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            System.setIn(fis);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void test() {
        String[] filenames = new String[] {
                "input1.txt",
                "input2.txt",
        };
        for (String filename : filenames) {
            if (setStdin(filename) == false) {
                System.out.println("Failed to open file: " + filename);
                continue;
            }
            baekjoon();
        }
    }

    public static void main(String[] args) {
        test();
        // baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int len = Integer.parseInt(line);
        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            if (line.equals("0")) {
                stack.pop();
            }
            else {
                stack.add(Long.parseLong(line));
            }
        }

        scanner.close();

        baekjoonLogic(stack);
    }

    public static void baekjoonLogic(Stack<Long> stack) {
        Long answer = 0L;
        int len = stack.size();

        for (int i = 0; i < len; i++) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }

}
