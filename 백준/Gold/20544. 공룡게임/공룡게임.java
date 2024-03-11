import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 높이가 1 또는 2인 선인장(장애물)으로 이루어진다. 시작 지점은 1
 * 최대 2개의 인접한 선인장을 뛰어 넘을 수 있으며 인접한 두 선인장의 높이의 합이 4 이상이면 뛰어넘을 수 없다.
 * 높이가 2인 선인장이 적어도 하나는 등장
 * N+1의 지점으로 도착하면 깰 수 있다고 정의
 * 인접한 선인장이 존재하면 반드시 한번에 뛰어넘어야 한다
 */
public class Main {
    static int N;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3][2][2];
        for (int[][][] a : dp) {
            for (int[][] a1 : a) {
                for (int[] a2 : a1) {
                    Arrays.fill(a2, -1);
                }
            }
        }

        System.out.println(recur(1, 0, 0, 0));
    }


    // cnt1 : 연속한 선인장 개수
    // cnt2 : 높이 2짜리 선인장 개수
    // two : 높이 2짜리 선인장 유무
    private static long recur(int cur, int cnt1, int cnt2, int two) {
        if (cnt1 > 2 || cnt2 >= 2) {
            return 0;
        }

        if (cur == N) {
            return two;
        }

        if (dp[cur][cnt1][cnt2][two] != -1) {
            return dp[cur][cnt1][cnt2][two];
        }

        // 장애물 설치 X , 1짜리 장애물 설치, 2짜리 장애물 설치
        dp[cur][cnt1][cnt2][two] = (int)((recur(cur + 1, 0, 0, two)
                + recur(cur + 1, cnt1 + 1, 0, two)
                + recur(cur + 1, cnt1 + 1, cnt2 + 1, 1)) % 1000000007);

        return dp[cur][cnt1][cnt2][two];
    }
}
