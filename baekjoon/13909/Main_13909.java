// https://www.acmicpc.net/problem/13909

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_13909 {

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
        // baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        long N = Long.parseLong(line);

        scanner.close();

        baekjoonLogic(N);
    }

    public static void baekjoonLogic(long N) {
        long compare = 1;
        int count = 0, i = 1;
        while (compare <= N) {
            count++;
            i++;
            compare = i * i;
        }

        System.out.println(count);
    }
}
