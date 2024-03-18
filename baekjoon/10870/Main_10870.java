// https://www.acmicpc.net/problem/10870

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_10870 {

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
        int number = Integer.parseInt(line);

        scanner.close();

        baekjoonLogic(number);
    }

    public static void baekjoonLogic(int number) {
        if(number == 0){
            System.out.println(0);
            return;
        }

        if(number < 3) {
            System.out.println(1);
            return;
        }
        int num1 = 1, num2 = 1, temp = 0;

        for (int i = 2; i < number; i++) {
            temp = num1;
            num1 += num2;
            num2 = temp;
        }

        System.out.println(num1);
    }

}