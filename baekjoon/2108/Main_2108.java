// https://www.acmicpc.net/problem/2108

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Main_2108 {

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
                "input3.txt",
                "input4.txt",
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
        int nums_len = Integer.parseInt(line), max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0, current = 0, small = 0, count = Integer.MIN_VALUE;
        int[] middle = new int[nums_len];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums_len; i++) {
            line = scanner.nextLine();
            current = Integer.parseInt(line);

            if(max < current) {
                max = current;
            }

            if(min > current) {
                min = current;
            }

            sum += current;
            middle[i] = current;

            if(!map.containsKey(current)){
                map.put(current, 1);
                continue;
            }

            map.put(current, map.get(current) + 1);
        }
        Arrays.sort(middle);

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Comparator를 이용하여 값으로 정렬
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });

        // 정렬된 결과 출력
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if(count == entry.getValue()) {
                small = entry.getKey();
                break;
            }

            if(count < entry.getValue()) {
                count = entry.getValue();
                small = entry.getKey();
                continue;
            }
            break;
        }

        scanner.close();

        baekjoonLogic((int)Math.round(sum / (double)nums_len), middle[nums_len / 2], small, max - min);
    }

    public static void baekjoonLogic(int average, int middle, int small, int range) {
        System.out.println(average);
        System.out.println(middle);
        System.out.println(small);
        System.out.println(range);
    }

}
