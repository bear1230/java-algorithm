

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 캔 Ai개
 * M[i][j] 메리가 i번째날 j번쨰 캔
 * R[i][j] 랑이가 i번째날 j번쨰 캔
 */
public class Main {
    static int N, K;
    static int[] can;
    static int[][] catR, catM;
    static int[] select;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        can = new int[N];
        catM = new int[K][N];
        catR = new int[K][N];
        select = new int[K * 2]; //어떤 캔 선택했는지 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            can[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                catR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                catM[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0);
        System.out.println(MAX);

    }

    private static void recur(int cur) {
        if (cur == 2 * K) {
            int sum = 0;
            for (int i = 0; i < K * 2; i++) {
                if (i % 2 == 0) {
                    sum +=catR[i/2][select[i]];
                }else {
                    sum+= catM[i/2][select[i]];
                }
            }
            MAX = Math.max(MAX,sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (can[i] == 0) {
                continue;
            }
            can[i]--;
            select[cur] = i;
            recur(cur + 1);
            can[i]++;
        }
    }
}
