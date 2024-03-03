// https://www.acmicpc.net/problem/2164

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Main_2164 {

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
        int len = Integer.parseInt(line);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            queue.offer(i + 1);
        }

        scanner.close();

        baekjoonLogic(queue);
    }

    public static void baekjoonLogic(Queue<Integer> queue) {
        int answer = 0, i = 0;

        while (!queue.isEmpty()) {
            answer = queue.poll();
            i++;

            if (i % 2 == 0) {
                queue.offer(answer);
            }
        }

        System.out.println(answer);
    }

}

