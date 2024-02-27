// https://www.acmicpc.net/problem/28278

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main_28278 {

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
        // baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int commend_len = Integer.parseInt(line);

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < commend_len; i++) {
            line = scanner.nextLine();

            switch (line) {
                case "2":
                    if (stack.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(stack.pop()).append('\n');
                    continue;
                case "3":
                    sb.append(stack.size()).append('\n');
                    continue;
                case "4":
                    if (stack.isEmpty()) {
                        sb.append(1).append('\n');
                        continue;
                    }
                    else {
                        sb.append(0).append('\n');
                        continue;
                    }
                case "5":
                    if (stack.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(stack.peek()).append('\n');
                    continue;
                default:
                    String[] split = line.split(" ");
                    stack.add(split[1]);
            }
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}
