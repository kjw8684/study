// https://www.acmicpc.net/problem/28279

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;


public class Main_28279{

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
        String line = scanner.nextLine();
        int commend_len = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        String[] split = new String[2];
        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < commend_len; i++) {
            line = scanner.nextLine();
            switch (line) {
                case "3":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                        continue;
                    }
                    sb.append(deque.removeFirst()).append('\n');
                    continue;

                case "4":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                        continue;
                    }
                    sb.append(deque.removeLast()).append('\n');
                    continue;

                case "5":
                    sb.append(deque.size()).append('\n');
                    continue;

                case "6":
                    if (deque.isEmpty()) {
                        sb.append("1").append('\n');
                        continue;
                    }
                    sb.append("0").append('\n');
                    continue;

                case "7":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                        continue;
                    }
                    sb.append(deque.peekFirst()).append('\n');
                    continue;

                case "8":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                        continue;
                    }
                    sb.append(deque.peekLast()).append('\n');
                    continue;

                default:
                    split = line.split(" ");
                    if (split[0].equals("1")) {
                        deque.addFirst(split[1]);
                        continue;
                    }

                    deque.addLast(split[1]);
            }
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}