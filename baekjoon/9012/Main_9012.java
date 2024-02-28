// https://www.acmicpc.net/problem/9012

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main_9012 {

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
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean condition = true;

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            int line_len = line.length();
            condition = true;
            stack.clear();

            for (int j = 0; j < line_len; j++) {
                if (line.charAt(j) == '(') {
                    stack.add('(');
                }
                else{
                    if (stack.isEmpty()) {
                        condition = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && condition) {
                sb.append("YES").append('\n');
                continue;
            }
            sb.append("NO").append('\n');
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}
