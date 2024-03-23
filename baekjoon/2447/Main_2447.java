// https://www.acmicpc.net/problem/2447

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_2447 {

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

    static char[][] array;
    public static void main(String[] args) {
        test();
        //baekjoon();
    }

    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        array = new char[number][number];

        scanner.close();

        baekjoonLogic(number);
    }

    public static void star(int x, int y, int N, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    array[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            array[x][y] = '*';
            return;
        }

        int size = N / 3, count = 0;

        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                }
                else{
                    star(i, j, size, false);
                }
            }
        }
    }

    public static void baekjoonLogic(int number) {
        star(0, 0, number, false);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                sb.append(array[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}