// https://www.acmicpc.net/problem/24416

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_24416 {

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
        };
        for (String filename : filenames) {
            if (setStdin(filename) == false) {
                System.out.println("Failed to open file: " + filename);
                continue;
            }
            baekjoon();
        }
    }

    static int fib_count, fibonacci_count;
    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        scanner.close();

        baekjoonLogic(len);
    }

    public static void baekjoonLogic(int len) {
        fib_count = 0;
        fibonacci_count = 0;
        fib(len);
        fibonacci(len);
        System.out.println(fib_count);
        System.out.println(fibonacci_count);
    }

    public static int fib(int n) {
        if(n == 1 || n == 2) {
            fib_count++;
            return 1;
        }
        else return (fib(n - 1) + fib(n - 2));
    }

    public static int fibonacci(int n) {
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < n; i++) {
            fibonacci_count++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

}
