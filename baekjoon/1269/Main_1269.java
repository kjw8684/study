// https://www.acmicpc.net/problem/1269

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main_1269 {

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
        int len1 = Integer.parseInt(array[0]);
        int len2 = Integer.parseInt(array[1]);
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        line = scanner.nextLine();
        String[] array1 = line.split(" ");
        for (int i = 0; i < len1; i++) {
            map.put(array1[i], 1);
        }

        line = scanner.nextLine();
        String[] array2 = line.split(" ");
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(array2[i])) {
                map.remove(array2[i]);
                continue;
            }
            count++;
        }

        count += map.size();

        scanner.close();

        baekjoonLogic(count);
    }

    public static void baekjoonLogic(int count) {
        System.out.println(count);
    }

}