// https://www.acmicpc.net/problem/1436

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main_1436 {

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
                "input5.txt",
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
        int N = Integer.parseInt(input);

        scanner.close();

        baekjoonLogic(N);
    }

    public static void baekjoonLogic(int N) {
        int count = 0, i = 0;
        while (true) {
            i++;
            if (Integer.toString(i).contains("666")) {
                count++;
            }

            if (count == N) {
                System.out.println(i);
                break;
            }
        }
    }

}