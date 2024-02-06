// https://www.acmicpc.net/problem/10989

import java.io.FileInputStream;
import java.io.IOException;
//읽는데 시간이 너무 걸려서 Scanner 사용 불가
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10989 {

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
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in));){
            int len = Integer.parseInt(br.readLine());
		    int[] array = new int[len];

		    for(int i = 0; i < len; i++){
		    	array[i] = Integer.parseInt(br.readLine());
		    }
            Arrays.sort(array);

            baekjoonLogic(array, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void baekjoonLogic(int[] array, int len) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
			sb.append(array[i]).append('\n');
		}
        System.out.print(sb);
    }

}