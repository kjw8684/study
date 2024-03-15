// https://www.acmicpc.net/problem/26069

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Main_26069 {

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
        String[] split = new String[2];
        int commend_len = Integer.parseInt(line);
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");

        for(int i = 0; i < commend_len; i++) {
            line = scanner.nextLine();
            split = line.split(" ");

            if(set.contains(split[0]) || set.contains(split[1])){
                set.add(split[0]);
                set.add(split[1]);
            }
        }

        scanner.close();

        baekjoonLogic(set.size());
    }

    public static void baekjoonLogic(int answer) {
        System.out.println(answer);
    }

}