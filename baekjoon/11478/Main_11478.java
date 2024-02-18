// https://www.acmicpc.net/problem/11478

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main_11478 {

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
        String S = scanner.nextLine();
        scanner.close();

        baekjoonLogic(S);
    }

    public static void baekjoonLogic(String S) {
        StringBuilder sb = new StringBuilder();
        int len = S.length(), count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            sb.append('X');
            sb.append(S.substring(0, i));

            for (int j = 0; j < len - i; j++) {
                sb.deleteCharAt(0);
                sb.append(S.charAt(i + j));

                if (!map.containsKey(sb.toString())) {
                    count++;
                    map.put(sb.toString(), 1);
                }
            }
            sb.setLength(0);
        }

        System.out.println(count);
    }

}