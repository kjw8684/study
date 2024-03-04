// https://www.acmicpc.net/problem/11866

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Main_11866 {

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
        String[] split = line.split(" ");
        int len = Integer.parseInt(split[0]), interval = Integer.parseInt(split[1]);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            queue.offer(i + 1);
        }

        scanner.close();

        baekjoonLogic(queue, interval);
    }


    public static void baekjoonLogic(Queue<Integer> queue, int interval) {
        StringBuilder sb = new StringBuilder("<");
        int current = 1;

        while (queue.size() != 1) {
            int poll = queue.poll();
            if (current == interval) {
                sb.append(poll).append(", ");
                current = 1;
                continue;
            }

            queue.offer(poll);
            current++;
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }

}