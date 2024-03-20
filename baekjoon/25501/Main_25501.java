// https://www.acmicpc.net/problem/25501

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_25501 {

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

    public static int[] isPalindrome(String s, int l, int r, int count) {
        if(l >= r) return new int[] {1, count};
        else if(s.charAt(l) != s.charAt(r)) return new int[]{0, count};
        else return isPalindrome(s, l + 1, r - 1, count + 1);
    }

    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        int commend_len = scanner.nextInt(), len = 0;
        String line = scanner.nextLine();
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < commend_len; i++) {
            line = scanner.nextLine();
            len = line.length();
            answer = isPalindrome(line, 0, len - 1, 1);
            sb.append(answer[0]).append(" ").append(answer[1]).append('\n');
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}