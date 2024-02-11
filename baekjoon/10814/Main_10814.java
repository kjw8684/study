// https://www.acmicpc.net/problem/10814

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_10814 {

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

        int len = Integer.parseInt(line);
        String [][] array = new String[len][2];

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            String firstLines[] = line.split(" ");
            array[i][0] = firstLines[0];
            array[i][1] = firstLines[1];
        }
        scanner.close();


        Arrays.sort(array, (e1, e2) -> {
            return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
        });

        baekjoonLogic(array, len);
    }

    public static void baekjoonLogic(String[][] array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array[i][0]).append(' ').append(array[i][1]).append('\n');
        }

        System.out.print(sb);
    }

}