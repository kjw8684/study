// https://www.acmicpc.net/problem/4949

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main_4949 {

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
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line;
        StringBuilder sb = new StringBuilder();

        while (true) {
            line = scanner.nextLine();
            if (line.equals(".")) {
                break;
            }

            sb.append(compare(line, line.length())).append('\n');
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static String compare(String line, int len) {
        Stack<String> stack = new Stack<>();
        char current;
        for (int i = 0; i < len; i++) {
            current = line.charAt(i);
            if (current == '(') {
                stack.push(")");
                continue;
            }
            if (current == '[') {
                stack.push("]");
                continue;
            }

            if (current == ')') {
                if (stack.isEmpty()) {
                    return "no";
                }

                if (stack.peek().equals(")")) {
                    stack.pop();
                    continue;
                }

                return "no";
            }

            if (current == ']') {
                if (stack.isEmpty()) {
                    return "no";
                }

                if (stack.peek().equals("]")) {
                    stack.pop();
                    continue;
                }

                return "no";
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        }
        return "no";
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}

