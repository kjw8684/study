// https://www.acmicpc.net/problem/1620

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main_1620 {

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

        String [] array = line.split(" ");
        int dic_len = Integer.parseInt(array[0]);
        int qus_len = Integer.parseInt(array[1]);
        String[] answer = new String[qus_len];
        String[] dictionary = new String[dic_len];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < dic_len; i++) {
            line = scanner.nextLine();
            map.put(line, i + 1);
            dictionary[i] = line;
        }

        for (int i = 0; i < qus_len; i++) {
            line = scanner.nextLine();
            try {
                int num = Integer.parseInt(line);
                answer[i] = dictionary[num - 1];
            } catch (NumberFormatException e) {
                answer[i] = String.valueOf(map.get(line));
            }
        }

        scanner.close();

        baekjoonLogic(answer, qus_len);
    }

    public static void baekjoonLogic(String[] array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array[i]).append('\n');
        }

        System.out.print(sb);
    }

}