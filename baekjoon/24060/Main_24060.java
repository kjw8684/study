// https://www.acmicpc.net/problem/24060

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Main_24060 {

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

    public static void main(String[] args) {
        test();
        //baekjoon();
    }

    static int count = 0, current = 0, answer = -1;

    public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int len = Integer.parseInt(split[0]);
        count = Integer.parseInt(split[1]);
        int[] A = new int[len];
        line = scanner.nextLine();
        split = line.split(" ");
        for(int i = 0; i < len; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        mergeSort(A, 0, len - 1);

        scanner.close();

        baekjoonLogic();
    }


    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1, index = 0;

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= end) {
            temp[index++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            current++;
            if(current == count) {
                answer = temp[i];
            }
            arr[start + i] = temp[i];
        }
    }

    public static void baekjoonLogic() {
        System.out.println(answer);
    }

}