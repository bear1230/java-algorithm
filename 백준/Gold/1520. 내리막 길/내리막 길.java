import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳
 * 2. 항상 높이가 더 낮은 지점으로만 이동
 */
public class Main {
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp = new int[N][M];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        
        System.out.println(recur(0, 0));
    }

    private static int recur(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1;
        }
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            
            if (map[x][y] > map[nx][ny]) {
                tmp += recur(nx, ny);
            }

        }
        
        dp[x][y] = tmp;
        
        return dp[x][y];
    }
}
