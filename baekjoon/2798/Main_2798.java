// https://www.acmicpc.net/problem/2798

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2798 {

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
        public static void baekjoon() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String firstLines[] = line.split(" ");

        int cardsLen = Integer.parseInt(firstLines[0]);
        int sum = Integer.parseInt(firstLines[1]);
        int[] cards = new int[cardsLen];

        // 다음 줄이 있을 경우 계속 읽어들인다.
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // 공백을 기준으로 문자열을 분리해 숫자로 만들어 배열에 추가한다.
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int i = 0; i < cardsLen; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
        }
        scanner.close();

        baekjoonLogic(cards, sum);
    }

    public static void baekjoonLogic(int[] cards, int limit) {
        int max = 0;

        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum > limit) {
                        continue;
                    }
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }

}