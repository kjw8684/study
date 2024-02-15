// https://www.acmicpc.net/problem/7785

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main_7785 {

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
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            String [] array = line.split(" ");
            if (array[1].equals("enter")) {
                hashMap.put(array[0], 1);
                continue;
            }
            hashMap.remove(array[0]);
        }
        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());

        Collections.sort(arrayList, Collections.reverseOrder());

        scanner.close();

        baekjoonLogic(arrayList);
    }

    public static void baekjoonLogic(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        int len = list.size();

        for (int i = 0; i < len; i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.print(sb);
    }

}