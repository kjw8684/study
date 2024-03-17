// https://www.acmicpc.net/problem/27433

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Scanner;


public class Main_27433 {

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
        int number = Integer.parseInt(line);

        scanner.close();

        baekjoonLogic(number + 1);
    }

    public static void baekjoonLogic(int number) {
        BigInteger answer = BigInteger.ONE;

        for (int i = 1; i < number; i++) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }

        System.out.println(answer);
    }

}
