// https://www.acmicpc.net/problem/2346

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main_2346 {

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
        int len = Integer.parseInt(line);
        line = scanner.nextLine();
        String[] split = line.split(" ");
        int[] balloon = new int[len];

        for (int i = 0; i < len; i++) {
            balloon[i] = Integer.parseInt(split[i]);
        }

        scanner.close();

        baekjoonLogic(balloon, len);
    }

    public static void baekjoonLogic(int[] balloon, int len) {
        StringBuilder sb = new StringBuilder("1");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0;  i < len; i++) {
            deque.addLast(i);
        }
        int move = 0, current = 0;
        boolean cheak = true;

        for (int i = 1; i < len; i++) {
            if (cheak) {
                current = deque.removeFirst();
            }
            else{
                current = deque.removeLast();
            }

            move = balloon[current];
            if (move > 0) {
                cheak = true;
                while(move != 1) {
                    deque.addLast(deque.removeFirst());
                    move--;
                }
                sb.append(" ").append(deque.peekFirst() + 1);
                continue;
            }
            cheak = false;

            while (move != -1) {
                deque.addFirst(deque.removeLast());
                move++;
            }
            sb.append(" ").append(deque.peekLast() + 1);
        }

        System.out.println(sb);
    }

}

