import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 완탐 -> 0부터 9까지 다 돌리기
 */
public class Main {
    static int N;
    static char[] arr;
    static boolean[] visited = new boolean[10]; // 0~9
    static ArrayList ansswer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        recur("", 0);
        Collections.sort(ansswer);
        System.out.println(ansswer.get(ansswer.size()-1));
        System.out.println(ansswer.get(0));
    }

    private static void recur(String s, int depth) {
        if (depth == N + 1) {
            ansswer.add(s);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (depth == 0 || !visited[i] && check(s.charAt(s.length() - 1) - '0', i, arr[depth - 1])) {
                visited[i] = true;
                recur(s + i, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, char c) {
        if (c == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}
