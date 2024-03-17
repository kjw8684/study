// https://www.acmicpc.net/problem/20920

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_20920 {

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

    public static void test() throws IOException {
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

    public static void main(String[] args) throws IOException {
        test();
        //baekjoon();
    }

    public static void baekjoon() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        int len = Integer.parseInt(split[0]), string_len = Integer.parseInt(split[1]);
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++) {
            line = br.readLine();
            if(line.length() < string_len) {
                continue;
            }
            if(!map.containsKey(line)) {
                map.put(line, 1);
                continue;
            }

            map.put(line, map.get(line) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return map.get(o2) - map.get(o1);
            }
        });

        for (String key : list) {
            sb.append(key).append('\n');
        }

        baekjoonLogic(sb);
    }

    public static void baekjoonLogic(StringBuilder sb) {
        System.out.print(sb);
    }

}