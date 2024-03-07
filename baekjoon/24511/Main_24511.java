// https://www.acmicpc.net/problem/24511

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_24511 {

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
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = Integer.parseInt(line) - 1;
        line = scanner.nextLine();
        String[] split = line.split(" ");
        line = scanner.nextLine();
        String[] num_split = line.split(" ");
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = len; i > -1; i--) {
            if (split[i].equals("0")) {
                queue.offer(num_split[i]);
            }
        }

        line = scanner.nextLine();
        len = Integer.parseInt(line);
        line = scanner.nextLine();
        split = line.split(" ");

        for (int i = 0; i < len; i++) {
            queue.offer(split[i]);
            sb.append(queue.poll()).append(' ');
        }
        scanner.close();

        baekjoonLogic(sb);
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.println(sb);
    }

}