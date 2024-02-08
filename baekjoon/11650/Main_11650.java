// https://www.acmicpc.net/problem/11650

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_11650 {

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
        int [][] array = new int[len][2];

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            String firstLines[] = line.split(" ");
            array[i][0] = Integer.parseInt(firstLines[0]);
            array[i][1] = Integer.parseInt(firstLines[1]);
        }
        scanner.close();

        Arrays.sort(array, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            else {
                return e1[0] - e2[0];
            }
        });

        baekjoonLogic(array, len);
    }

    public static void baekjoonLogic(int[][] array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array[i][0]).append(' ').append(array[i][1]).append('\n');
        }

        System.out.print(sb);
    }

}