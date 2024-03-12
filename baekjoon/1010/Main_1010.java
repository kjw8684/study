// https://www.acmicpc.net/problem/1010

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Scanner;


public class Main_1010 {

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
        String[] split = new String[2];
        int test_len = Integer.parseInt(line);
        BigInteger result;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < test_len; i++) {
            line = scanner.nextLine();
            split = line.split(" ");
            result = calculateFactorial(Integer.parseInt(split[1])).divide(calculateFactorial(Integer.parseInt(split[1]) - Integer.parseInt(split[0])).multiply(calculateFactorial(Integer.parseInt(split[0]))));
            sb.append(result).append('\n');
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static BigInteger calculateFactorial(int n){
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}