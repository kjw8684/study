// https://www.acmicpc.net/problem/4779

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_4779 {

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
        StringBuilder sb = new StringBuilder();
        int num;

        while (scanner.hasNext()) {
            num = scanner.nextInt();
            sb.append(kanto(num)).append('\n');
        }

        scanner.close();

        baekjoonLogic(sb);
    }

    public static StringBuilder kanto(int len) {
        StringBuilder sb = new StringBuilder("-");
        StringBuilder temp = new StringBuilder();
        int base = 3, result = 1;

        for(int i = 0; i < len; i++) {
            temp.setLength(0);;
            temp.append(sb);
            sb.setLength(0);
            sb.append(temp);
            for (int j = 0; j < result; j++) {
                sb.append(" ");
            }
            sb.append(temp);
            result *= base;
        }

        return sb;
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}