// https://www.acmicpc.net/problem/1934

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_1934 {

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
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            String [] array = line.split(" ");
            int a = Integer.parseInt(array[0]), b = Integer.parseInt(array[1]), count = 2, measure = 1;

            while (a >= count && b >= count) {
                if (a % count == 0 && b % count == 0) {
                    a /= count;
                    b /= count;
                    measure *= count;
                    continue;
                }
                count++;
            }
            answer[i] = a * b * measure;
        }

        scanner.close();

        baekjoonLogic(answer, len);
    }

    public static void baekjoonLogic(int[] array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array[i]).append('\n');
        }

        System.out.print(sb);
    }

}