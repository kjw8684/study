// https://www.acmicpc.net/problem/13241

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_13241 {

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
                "input3.txt",
                "input4.txt",
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
        String [] array = line.split(" ");

        long A = Long.parseLong(array[0]);
        long B = Integer.parseInt(array[1]);

        scanner.close();

        baekjoonLogic(A, B);
    }

    public static void baekjoonLogic(long A, long B) {
        long count = 2, answer = 1;
        while (A >= count && B >= count) {
            if (A % count == 0 && B % count == 0) {
                A /= count;
                B /= count;
                answer *= count;
                continue;
            }

            count++;
        }

        System.out.println(A * B * answer);
    }

}