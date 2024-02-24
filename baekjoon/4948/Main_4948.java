// https://www.acmicpc.net/problem/4948

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_4948 {

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
        String line = scanner.nextLine();
        int start_int = 0, end_int = 0, count = 0;
        StringBuilder sb = new StringBuilder();

        while (!line.equals("0")) {
            start_int = Integer.parseInt(line);
            end_int = start_int * 2;
            count = 0;
            start_int++;

            for (int i = start_int; i <= end_int; i++) {
                if (isprime(i)) {
                    count++;
                }
            }

            sb.append(count).append('\n');
            line = scanner.nextLine();
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static boolean isprime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}
