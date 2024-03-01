// https://www.acmicpc.net/problem/18258

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main_18258 {

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
        Queue<String> queue = new ArrayDeque<>();
        String[] split = new String[2];
        String pop = new String(), back = new String();

        for (int i = 0; i < commend_len; i++) {
            line = scanner.nextLine();
            if (line.equals("pop")) {
                pop = queue.poll();
                if (pop == null) {
                    sb.append("-1").append('\n');
                    continue;
                }
                sb.append(pop).append('\n');
                continue;
            }

            if (line.equals("size")) {
                sb.append(queue.size()).append('\n');
                continue;
            }

            if (line.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append('\n');
                    continue;
                }
                sb.append("0").append('\n');
                continue;
            }

            if (line.equals("front")) {
                pop = queue.peek();
                if (pop == null) {
                    sb.append("-1").append('\n');
                    continue;
                }
                sb.append(pop).append('\n');
                continue;
            }

            if (line.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                    continue;
                }
                sb.append(back).append('\n');
                continue;
            }

            split = line.split(" ");
            back = split[1];
            queue.offer(back);
        }

        scanner.close();

        baekjoonLogic(sb);
    }


    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}