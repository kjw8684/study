// https://www.acmicpc.net/problem/4134

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_4134 {

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

        int len = Integer.parseInt(line);
        long line_int = 0;
        long[] answer = new long[len];

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            line_int = Long.parseLong(line);
            answer[i] = isprime(line_int);
        }

        scanner.close();

        baekjoonLogic(answer, len);
    }

    public static long isprime(long number) {
        if (number <= 1) {
            return 2;
        }
        boolean chack = true;
        while(true) {
            chack = true;

            for (long i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    chack = false;
                    break;
                }
            }

            if (chack) {
                return number;
            }

            number++;
        }
    }

    public static void baekjoonLogic(long[] array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array[i]).append('\n');
        }

        System.out.print(sb);
    }

}
