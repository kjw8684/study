// https://www.acmicpc.net/problem/12789

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import javax.imageio.ImageIO;

public class Main_12789 {

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
        int len = Integer.parseInt(line), current = 0;
        line = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> pass = new Stack<>();
        String[] front = line.split(" ");
        int next = Integer.parseInt(front[0]);
        String answer = "Nice";

        for (int i = 1; i < len; i++) {
            current = next;
            next = Integer.parseInt(front[i]);
            if ((stack.isEmpty() || stack.peek() > current) && current > next) {
                stack.push(current);
                continue;
            }

            if (current < next) {
                if (!pass.isEmpty() && pass.peek() > current) {
                    answer = "Sad";
                    break;
                }
                pass.push(current);
            }
        }

        if (!pass.isEmpty() && pass.peek() > next) {
            answer = "Sad";
        }

        scanner.close();

        baekjoonLogic(answer);
    }

    public static void baekjoonLogic(String answer) {
        System.out.println(answer);
    }

}



