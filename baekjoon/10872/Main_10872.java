// https://www.acmicpc.net/problem/10872

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_10872 {

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
        int n = Integer.parseInt(line);

        scanner.close();

        baekjoonLogic(n);
    }

    public static void baekjoonLogic(int n) {
        int answer = 1;

        for (int i = 1; i < n + 1; i++) {
            answer *= i;
        }

        System.out.println(answer);
    }

}