// https://www.acmicpc.net/problem/14888

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_14888 {

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
        };
        for (String filename : filenames) {
            if (setStdin(filename) == false) {
                System.out.println("Failed to open file: " + filename);
                continue;
            }
            baekjoon();
        }
    }
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] number = new int[Integer.parseInt(line)], sign = new int[4];

        line = scanner.nextLine();
        String[] split = line.split(" ");

        for(int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(split[i]);
        }

        line = scanner.nextLine();
        split = line.split(" ");

        for(int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(split[i]);
        }


        scanner.close();

        baekjoonLogic(number, sign);
    }

    public static void baekjoonLogic(int[] number, int[] sign) {
        calculate(number, sign, 1, number[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int[] number, int[] sign, int depth, int cal) {
        if (depth == number.length) {
            if (cal > max) {
                max = cal;
            }
            if (cal < min) {
                min = cal;
            }

            return;
        }

        if (sign[0] > 0) {
            sign[0]--;
            calculate(number, sign, depth + 1, cal + number[depth]);
            sign[0]++;
        }

        if (sign[1] > 0) {
            sign[1]--;
            calculate(number, sign, depth + 1, cal - number[depth]);
            sign[1]++;
        }

        if (sign[2] > 0) {
            sign[2]--;
            calculate(number, sign, depth + 1, cal * number[depth]);
            sign[2]++;
        }

        if (sign[3] > 0) {
            sign[3]--;
            calculate(number, sign, depth + 1, cal / number[depth]);
            sign[3]++;
        }
    }

}
