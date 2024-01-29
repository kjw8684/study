// https://www.acmicpc.net/problem/19532

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main_19532 {

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
        String firstLines[] = line.split(" ");

        int a = Integer.parseInt(firstLines[0]);
        int b = Integer.parseInt(firstLines[1]);
        int c = Integer.parseInt(firstLines[2]);
        int d = Integer.parseInt(firstLines[3]);
        int e = Integer.parseInt(firstLines[4]);
        int f = Integer.parseInt(firstLines[5]);

        scanner.close();

        baekjoonLogic(a, b, c, d, e, f);
    }

    public static void baekjoonLogic(int a, int b, int c, int d, int e, int f) {
        int x_value = 0, y_value = 0;

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    x_value = x;
                    y_value = y;
                }
            }
        }

        System.out.println(x_value + " " + y_value);
    }

}