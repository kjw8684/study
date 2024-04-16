// https://www.acmicpc.net/problem/14889

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_14889 {

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
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = Integer.parseInt(line);
        String[] split = new String[len];
        int[][] table = new int[len][len];

        for(int i = 0; i < len; i++) {
            line = scanner.nextLine();
            split = line.split(" ");
            for(int j = 0; j < len; j++) {
                table[i][j] = Integer.parseInt(split[j]);
            }
        }
        int[] team_a = new int[len / 2], team_b = new int[len / 2];

        scanner.close();

        baekjoonLogic(table, team_a, team_b);
    }

    public static void baekjoonLogic(int[][] table, int[] team_a, int[] team_b) {
        calculate(table, team_a, team_b, table.length - 1, table.length / 2, table.length / 2);

        System.out.println(min);
    }

    public static void calculate(int[][] table, int[] team_a, int[] team_b, int depth, int count_a, int count_b) {
        if (depth == -1) {
            int answer = 0;
            for(int i = 0; i < table.length / 2; i++) {
                for (int j = 0; j < table.length / 2; j++) {
                    answer += table[team_a[i]][team_a[j]];
                    answer -= table[team_b[i]][team_b[j]];
                }
            }

            if (Math.abs(answer) < min) {
                min = Math.abs(answer);
            }

            return;
        }

        if (count_a > 0) {
            int[] a = team_a;
            a[count_a - 1] = depth;
            calculate(table, a, team_b, depth - 1, count_a - 1, count_b);
        }

        if (count_b > 0) {
            int[] b = team_b;
            b[count_b - 1] = depth;
            calculate(table, team_a, b, depth - 1, count_a, count_b - 1);
        }

    }

}
