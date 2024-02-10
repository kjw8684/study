// https://www.acmicpc.net/problem/1181

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1181 {

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
        String [] array = new String[len];

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            array[i] = line;
        }
        scanner.close();

        Arrays.sort(array, (e1, e2) -> {
            if(e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }
            else {
                return e1.length() - e2.length();
            }
        });

        baekjoonLogic(array, len);
    }

    public static void baekjoonLogic(String[] array, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]).append('\n');

        for (int i = 1; i < len; i++) {
            if (!array[i - 1].equals(array[i])) {
                sb.append(array[i]).append('\n');
            }
        }

        System.out.print(sb);
    }

}