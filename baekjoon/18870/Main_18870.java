// https://www.acmicpc.net/problem/18870

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_18870 {

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

        int len = Integer.parseInt(line);
        int [][] array = new int[len][2];
        int[] answer = new int[len];
        line = scanner.nextLine();
        String[] split = line.split(" ");

        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(split[i]);
            array[i][0] = temp;
            array[i][1] = i;
        }

        Arrays.sort(array, (e1, e2) -> e1[0] - e2[0]);
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (i != 0 && array[i][0] == array[i - 1][0]) {
                count++;
            }
            answer[array[i][1]] = i - count;
        }

        scanner.close();

        baekjoonLogic(answer, len);
    }

    public static void baekjoonLogic(int[] answer, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }

}