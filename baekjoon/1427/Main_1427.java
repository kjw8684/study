// https://www.acmicpc.net/problem/1427

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1427 {

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
        int len = line.length();
        Character[] array = new Character[len];

        for (int i = 0 ; i < len; i++) {
            array[i] = line.charAt(i);
        }

        scanner.close();
        Comparator<Character> reverseOrder = Comparator.reverseOrder();

        Arrays.sort(array, reverseOrder);

        baekjoonLogic(array, len);
    }

    public static void baekjoonLogic(Character[] array, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(array[i]);
        }

        System.out.println(sb);
    }

}