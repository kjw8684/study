// https://www.acmicpc.net/problem/2231

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main_2231 {

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
        String input = scanner.nextLine();
        int N = Integer.parseInt(input), digit = input.length();

        scanner.close();

        baekjoonLogic(N, digit);
    }

    public static void baekjoonLogic(int N, int digit) {
        int min = N - 9 * digit, answer = 0;

        for (int i = min; i < N; i++) {
            int sum = i;
            int creat = i;
            while (creat != 0) {
                sum += creat % 10;
                creat /= 10;
            }

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

}