// https://www.acmicpc.net/problem/1037

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_1037 {

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
        int divisor_len = Integer.parseInt(line);
        line = scanner.nextLine();
        String[] split = line.split(" ");
        int min = 1000000, max = 0, current = 0;

        for(int i = 0; i < divisor_len; i++) {
            current = Integer.parseInt(split[i]);
            if(min > current) {
                min = current;
            }
            if(max < current) {
                max = current;
            }
        }

        scanner.close();

        baekjoonLogic(min, max);
    }

    public static void baekjoonLogic(int min, int max) {
        System.out.println(min * max);
    }

}