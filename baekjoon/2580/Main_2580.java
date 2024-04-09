// https://www.acmicpc.net/problem/2580

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;


public class Main_2580 {

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

    public static void test() throws IOException{
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
    static Stack<Integer[]> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        test();
        //baekjoon();
    }
    public static void baekjoon() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] split = new String[9];
        int[][] boerd = new int[9][9];
        int current = 0;

        for (int i = 0; i < 9; i++) {
            line = br.readLine();
            split = line.split(" ");
            for (int j = 0; j < 9; j++) {
                current = Integer.parseInt(split[j]);
                if(current == 0) {
                    stack.push(new Integer[] {i, j});
                }
                boerd[i][j] = current;
            }
        }

        baekjoonLogic(boerd);
    }

    public static void baekjoonLogic(int[][] boerd) {
        StringBuilder sb = new StringBuilder();

        sudoku(boerd);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(boerd[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static boolean sudoku(int[][] boerd) {
        Integer[] current = new Integer[2];
        while (!stack.isEmpty()) {
            current = stack.pop();
            guess(boerd, current);
            if(boerd[current[0]][current[1]] == 0) {
                stack.push(current);
        	    return false;
            }
        }
        return true;
    }

    public static boolean guess(int[][] boerd, Integer[] current) {
        int x = current[0] / 3 * 3, y = current[1] / 3 * 3;
        HashSet<Integer> localset = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            localset.add(i);
        }
        for (int i = 0; i < 9; i++) {
            localset.remove(boerd[current[0]][i]);
            localset.remove(boerd[i][current[1]]);
            localset.remove(boerd[x][y]);
            y++;
            if (i % 3 == 2) {
                y -= 3;
                x++;
            }
        }

        if(localset.size() == 0) {
    	    return false;
        }

        for (Integer element : localset) {
            boerd[current[0]][current[1]] = element;
            if (sudoku(boerd)) {
                return true;
            }
            boerd[current[0]][current[1]] = 0;
        }

        return false;
    }

}
