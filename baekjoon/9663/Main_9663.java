// https://www.acmicpc.net/problem/9663

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_9663 {

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

    static int count = 0;
    public static void main(String[] args) {
        test();
        //baekjoon();
    }
    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        scanner.close();

        baekjoonLogic(N);
    }

    public static void baekjoonLogic(int N) {
        int[][] bored = new int[N][N];
        forN(bored, N, 0);

        System.out.println(count);
    }

    public static void forN(int[][] bored, int len, int x) {
        if(len == x) {
            count++;
            return;
        }

        for(int i = 0; i < len; i++) {
            if(bored[x][i] == 0) {
                insert(bored, x, i, len);
                forN(bored, len, x + 1);
                delete(bored, x + 1, len);
            }
        }
    }

    public static void insert(int[][] bored, int x, int y, int len) {
        int temp_x = x, temp_y = y;
        for(int i = x; i < len; i++) {
            if(bored[i][y] == 0){
                bored[i][y] = x + 1;
            }
        }

        while (temp_x < len && temp_y < len) {
            if(bored[temp_x][temp_y] == 0) {
                bored[temp_x][temp_y] = x + 1;
            }
            temp_x++;
            temp_y++;
        }
        temp_x = x;
        temp_y = y;
        while (temp_x < len && temp_y >= 0) {
            if(bored[temp_x][temp_y] == 0){
                bored[temp_x][temp_y] = x + 1;
            }
            temp_x++;
            temp_y--;
        }
    }

    public static void delete(int[][] bored, int x, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (bored[i][j] == x) {
                    bored[i][j] = 0;
                }
            }
        }
    }
}
