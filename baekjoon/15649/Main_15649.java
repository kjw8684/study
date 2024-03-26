// https://www.acmicpc.net/problem/15649

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Main_15649 {

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

    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb_temp = new StringBuilder();

    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        sb.setLength(0);
        set.clear();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();

        scanner.close();

        baekjoonLogic(N, M);
    }

    public static void baekjoonLogic(int N, int M) {
        forN(N, M);

        System.out.print(sb);
    }

    public static void forN(int N, int M) {
        if(M == 1) {
            for(int i = 0; i < N; i++) {
                if(set.contains(i)) {
                    continue;
                }

                sb.append(sb_temp).append(i + 1).append('\n');
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(set.contains(i)) {
                continue;
            }

            set.add(i);
            sb_temp.append(i + 1).append(" ");
            forN(N, M - 1);
            sb_temp.delete(sb_temp.length() - 2, sb_temp.length());
            set.remove(i);
        }
    }

}