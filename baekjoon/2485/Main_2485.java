// https://www.acmicpc.net/problem/2485

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_2485 {

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

        int len = Integer.parseInt(line);
        int min = 0;
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            array[i] = Integer.parseInt(line);
            if (i != 0) {
                if (i == 1) {
                    min = array[i] - array[i - 1];
                    continue;
                }
                min = gcd(array[i] - array[i - 1], min);
            }
        }

        scanner.close();

        baekjoonLogic(array, min, len);
    }

    public static void baekjoonLogic(int[] array, int min, int len) {
        int minus = 0, count = 0;
        for (int i = 1; i < len; i++) {
            minus = array[i] - array[i - 1];
            if (minus > min) {
                count += minus / min;
                count--;
            }
        }

        System.out.println(count);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}