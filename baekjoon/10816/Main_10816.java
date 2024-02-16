// https://www.acmicpc.net/problem/10816

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main_10816 {

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
        line = scanner.nextLine();
        String [] array = line.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
                continue;
            }
            map.put(array[i], map.get(array[i]) + 1);
        }

        line = scanner.nextLine();
        len = Integer.parseInt(line);
        int[] answer = new int[len];
        line = scanner.nextLine();
        String [] array2 = line.split(" ");
        for (int i = 0; i < len; i++) {
            if (map.get(array2[i]) != null) {
                answer[i] = map.get(array2[i]);
                continue;
            }
            answer[i] = 0;
        }

        scanner.close();

        baekjoonLogic(answer, len);
    }

    public static void baekjoonLogic(int[] array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array[i]).append(' ');
        }

        System.out.println(sb);
    }

}