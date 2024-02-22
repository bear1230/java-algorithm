

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * , 새로운 R 값은 혼합할 모든 물감의 R 값을 더한 후 이를 물감의 개수로 나누어 구한다. 이때 소수점은 버린다. G와 B 값도 동일한 방법으로 구한다.
 * <p>
 * 각 R G B 값을 각각 더해주고 N만큼 나눠준다 -> 문두리값
 * 물감은 2~7까지
 * ans += abs(곰두리 - 문두리)
 */
public class Main {
    static int n;
    static int[][] colors;
    static int R, G, B;
    static int[] num;
    static int answer = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        colors = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());

        }
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int limit = Math.min(n, 7);
        for (int i = 2; i <= limit; i++) {
            recur(0, 0, i);
        }
        System.out.println(answer);
    }

    private static void recur(int start, int cur, int count) {
        if (cur == count) {
            int r = 0;
            int g = 0;
            int b = 0;
            for (int i = 0; i < count; i++) {
                r += colors[num[i]][0];
                g += colors[num[i]][1];
                b += colors[num[i]][2];
            }
            answer= Math.min(answer,Math.abs(R-r/count)+Math.abs(G-g/count)+Math.abs(B-b/count));
            return;
        }
        for (int i = start; i < n; i++) {
            num[cur] = i;
            recur(i + 1, cur + 1, count);
        }
    }
}
