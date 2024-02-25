// https://www.acmicpc.net/problem/17103

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main_17103 {

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

        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(line);
        int line_int = 0, count = 0;
        HashSet<Integer> prime = new HashSet<>();

        for (int i = 2; i < 1000001; i++) {
            if (isprime(i)) {
                prime.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            count = 0;
            line = scanner.nextLine();
            line_int = Integer.parseInt(line);
            for (int j = 0; j < line_int - j + 1; j++) {
                if (prime.contains(j) && prime.contains(line_int - j)) {
                    count++;
                }
            }
            sb.append(count).append('\n');
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
