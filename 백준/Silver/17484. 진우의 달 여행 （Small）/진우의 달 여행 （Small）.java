
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {0, 1, -1};

    static int[][][] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        //출발점 초기화
        for (int i = 0; i < M; i++) {
            dp[0][i][0] = map[0][i]; //왼쪽 대각선
            dp[0][i][1] = map[0][i]; //가운데
            dp[0][i][2] = map[0][i]; //오른쪽 대각선
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
                } else if(j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + map[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < M; j++) {
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, dp[N - 1][j][i]);
            }
        }

        System.out.println(min);


    }
}


