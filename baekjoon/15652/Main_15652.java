// https://www.acmicpc.net/problem/15652

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main_15652 {

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
        };
        for (String filename : filenames) {
            if (setStdin(filename) == false) {
                System.out.println("Failed to open file: " + filename);
                continue;
            }
            baekjoon();
        }
    }

    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb_temp = new StringBuilder();

    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        sb.setLength(0);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();

        scanner.close();

        baekjoonLogic(N, M);
    }

    public static void baekjoonLogic(int N, int M) {
        forN(N, M, 0);

        System.out.print(sb);
    }

    public static void forN(int N, int M, int start) {

        if(M == 1) {
            for(int i = start; i < N; i++) {
                sb.append(sb_temp).append(i + 1).append("\n");
            }
        }

        else{
            for(int i = start; i < N; i++) {
                sb_temp.append(i + 1).append(" ");
                forN(N, M - 1, i);
                sb_temp.delete(sb_temp.length() - 2, sb_temp.length());
            }
        }
    }

}
