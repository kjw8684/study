// https://www.acmicpc.net/problem/1929

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_1929 {

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
        String[] blank = line.split(" ");

        int first_num = Integer.parseInt(blank[0]);
        int second_num = Integer.parseInt(blank[1]);
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = first_num; i < second_num + 1; i++) {
            if (isPrime(i)){
                answer.add(i);
            }
        }

        int len = answer.size();

        scanner.close();

        baekjoonLogic(answer, len);
    }

    public static boolean isPrime(int number) {
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

    public static void baekjoonLogic(ArrayList<Integer> answer, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(answer.get(i)).append('\n');
        }

        System.out.print(sb);
    }

}

