// https://www.acmicpc.net/problem/1735

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_1735 {

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
        String [] array1 = line.split(" ");

        int a1 = Integer.parseInt(array1[0]);
        int a2 = Integer.parseInt(array1[1]);
        line = scanner.nextLine();
        String [] array2 = line.split(" ");
        int b1 = Integer.parseInt(array2[0]);
        int b2 = Integer.parseInt(array2[1]);

        scanner.close();

        baekjoonLogic(a1, a2, b1, b2);
    }

    public static void baekjoonLogic(int a1, int a2, int b1, int b2) {
        int A = a1 * b2 + a2 * b1, B = a2 * b2, count = 2;

        while (A >= count && B >= count) {
            if (A % count == 0 && B % count == 0) {
                A /= count;
                B /= count;
                continue;
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A).append(' '). append(B);
        System.out.println(sb);
    }

}