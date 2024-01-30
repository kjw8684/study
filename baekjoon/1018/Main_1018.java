// https://www.acmicpc.net/problem/1018

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main_1018 {

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
                "input6.txt",
                "input7.txt",
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
        String firstLines[] = line.split(" ");

        int M = Integer.parseInt(firstLines[0]);
        int N = Integer.parseInt(firstLines[1]);
        char[][] board = new char[M][N];

        for (int i = 0; i < M; i++) {
            line = scanner.nextLine();

            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        scanner.close();

        baekjoonLogic(M, N, board);
    }

    public static void baekjoonLogic(int M, int N, char[][] board) {
        int min = 64, count = 0;

        for (int start_row = 0; start_row < M - 7; start_row++) {
            for (int start_col = 0; start_col < N - 7; start_col++) {
                count = counting(start_row, start_col, board);
                if (min > count) {
                    min = count;
                }
            }
        }

        System.out.println(min);

    }

    public static int counting(int Sr, int Sc, char[][] board) {
        char cheak = 'W';
        int count = 0;

        for (int i = Sr; i < Sr + 8; i++) {
            for (int j = Sc; j < Sc + 8; j++) {
                if (board[i][j] != cheak) {
                    count++;
                }

                if (cheak == 'W') {
                    cheak = 'B';
                }
                else {
                    cheak = 'W';
                }
            }

            if (cheak == 'W') {
                cheak = 'B';
            }
            else {
                cheak = 'W';
            }
        }

        if (count > 32) {
            return 64 - count;
        }

        return count;
    }

}