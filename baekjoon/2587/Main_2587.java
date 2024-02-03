// https://www.acmicpc.net/problem/2587

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main_2587 {

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

        int[] intlist = new int[5];

        for (int i = 0; i < 5; i++) {
            intlist[i] = scanner.nextInt();
        }
        Arrays.sort(intlist);

        scanner.close();

        baekjoonLogic(intlist);
    }

    public static void baekjoonLogic(int[] intlist) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += intlist[i];
        }
        System.out.println(sum / 5);
        System.out.println(intlist[2]);
    }
}