// https://www.acmicpc.net/problem/2750

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main_2750 {

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

        int len = scanner.nextInt();
        int[] intlist = new int[len];

        for (int i = 0; i < len; i++) {
            intlist[i] = scanner.nextInt();
        }

        scanner.close();

        baekjoonLogic(intlist, len);
    }

    public static void baekjoonLogic(int[] intlist, int len) {
        Arrays.sort(intlist);
        for (int i = 0; i < len; i++) {
            System.out.println(intlist[i]);
        }

    }
}