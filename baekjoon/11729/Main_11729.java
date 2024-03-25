// https://www.acmicpc.net/problem/11729

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;


public class Main_11729 {

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

    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        scanner.close();

        baekjoonLogic(len);
    }

    public static void baekjoonLogic(int len) {
        hanoi(len, 1, 3, 2);

        System.out.println(count);
        System.out.print(sb);
    }

    public static void hanoi(int N, int start, int end, int middle) {
        if(N == 1) {
            move(start, end);
        }
        else {
            hanoi(N - 1, start, middle, end);
            move(start, end);
            hanoi(N - 1, middle, end, start);
        }
    }

    public static void move(int start, int end) {
        count++;
        sb.append(start).append(" ").append(end).append('\n');
    }

}