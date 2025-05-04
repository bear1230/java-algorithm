
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 알파벳 순서대로 숫자
 * 사전순으로 앞서는 방법.
 */

public class Main {
    static int count;
    static int sum;
    static String[] str;
    static boolean[] visited;
    static int[][] map = {{0, 2, 5, 7},
            {1, 2, 3, 4},
            {0, 3, 6, 10},
            {7, 8, 9, 10},
            {1, 5, 8, 11},
            {4, 6, 9, 11}};
    static int[] alphabet;
    static int[] arr;
    static int[] position = new int[12];

    public static void main(String[] args) throws IOException {
        str = new String[5];
        sum = 0;
        count = 0;

        visited = new boolean[12];
        alphabet = new int[12];
        arr = new int[12];

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            str[i] = br.readLine();
        }


        int num = 0;

        for (String s : str) {
            for (char c : s.toCharArray()) {
                if (c == 'x') {
                    position[count++] = num;
                    num++;// x자리 기록
                } else if (c != '.' && c != 'x') {
                    alphabet[num] = c - 'A';
                    visited[c - 'A'] = true;
                    num++;
                }

            }
        }

        recur(0);
    }

    private static void recur(int cur) {
        if (cur == count) {
            if (isMagicStar()) {
                printMagicStar();
                System.exit(0);
            }

            return;
        }

        for (int i = 0; i < 12; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arr[cur] = i; //어떤 알파벳 선택했는지 저장
            alphabet[position[cur]] = i; // 매직보드의 인덱스에 어떤 알파벳이 들어갈지 체크
            recur(cur + 1);
            visited[i] = false;

        }

    }

    private static void printMagicStar() {
        int idx = 0;

        for(int i =0; i<5; i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0; j<9; j++){
                char ch = str[i].charAt(j);
                if(ch == 'x' || ch >= 'A' && ch <='L'){
                    sb.append((char)(alphabet[idx++] + 'A'));
                } else {
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean isMagicStar() {
        for (int i = 0; i < map.length; i++) {
            int sum = 0;
            for (int j = 0; j < map[i].length; j++) {
                sum += alphabet[map[i][j]] + 1;
            }
            if (sum != 26) {
                return false;
            }
        }
        return true;
    }

}
