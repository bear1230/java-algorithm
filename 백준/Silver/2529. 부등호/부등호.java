import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 0부터 9까지의 정수 -> 숫자는 중복 x,  선택된 숫자는 모두 달라야 한다
 */
public class Main {
    static ArrayList<String> list = new ArrayList<>();
    static int N;
    static char[] sign;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[10];
        sign = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sign[i] = st.nextToken().charAt(0);
        }
        arr = new int[N + 1];

        recur(0);

        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));

    }

    private static boolean check(int cur) {

        if (cur <= 1) return true;

        if (sign[cur - 2] == '<' && arr[cur - 2] > arr[cur - 1]) {
            return false;
        } else if (sign[cur - 2] == '>' && arr[cur - 2] < arr[cur - 1]) {
            return false;

        }


        return true;
    }

    private static void recur(int cur) {

        if (!check(cur)) {
            return;
        }

        if (cur == N + 1) {
            String tmp = "";
            for (int a : arr) {
                tmp += a;
            }
            list.add(tmp);

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arr[cur] = i;
            recur(cur + 1);
            visited[i] = false;

        }
    }
}
