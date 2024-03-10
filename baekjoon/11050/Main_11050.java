// https://www.acmicpc.net/problem/11050

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_11050 {

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
        String[] split = line.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        scanner.close();

        baekjoonLogic(n, k);
    }

    public static void baekjoonLogic(int n, int k) {
        int answer = Factorial(n) / (Factorial(k) * Factorial(n - k));

        System.out.println(answer);
    }

    public static int Factorial(int a) {
        int answer = 1;
        for (int i = 0; i < a; i++) {
            answer *= i + 1;
        }

        return answer;
    }

}