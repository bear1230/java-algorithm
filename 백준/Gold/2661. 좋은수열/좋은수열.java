import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자 1, 2, 3으로만 이루어지는 수열
 * 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면, 나쁜수열
 * 그렇지 않은 수열은 좋은 수열
 * <p>
 * 길이가 N인 좋은 수열 중 가장 작은 수
 */
public class Main {
    static boolean[] visited;
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        recur(0, "");

        System.out.println(min);

    }

    private static void recur(int cur, String s) {
        if (!isGood(cur, s)) {
            return;
        }

        if (cur == N) {
            System.out.println(s);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            arr[cur] = i;
            recur(cur + 1, s + i);

        }

    }

    private static boolean isGood(int cur, String s) {
        int len = s.length();
        for (int i = 1; i <= len/2; i++) {
            String a = s.substring(len - i);
            String b = s.substring(len - 2*i, len-i);
            if(a.equals(b)){
                return false;
            }
        }
        return true;
    }
}
