// https://www.acmicpc.net/problem/2751

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2751 {

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
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            array.add(Integer.parseInt(line));
        }
        Collections.sort(array);
        scanner.close();

        baekjoonLogic(array, len);
    }

    public static void baekjoonLogic(List<Integer> array, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(array.get(i)).append('\n');
        }

        System.out.println(sb);
    }

}