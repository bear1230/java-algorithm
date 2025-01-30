import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] colors;
    static boolean[] visited;
    static int R, G, B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        colors = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        recur(0, 0);
        
        System.out.println(answer);

    }

    private static void recur(int cur, int cnt) {
        if (cnt > 7) {
            return;
        }
        
        if (cur == N) {
            if (cnt < 2) {
                return;
            }

            int r = 0;
            int g = 0;
            int b = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    r += colors[i][0];
                    g += colors[i][1];
                    b += colors[i][2];
                }
            }
            
            answer = Math.min(answer, Math.abs(R - r / cnt) + Math.abs(G - g / cnt) + Math.abs(B - b / cnt));
            return;
        }
        
        visited[cur] = true;
        recur(cur + 1, cnt + 1);
        visited[cur] = false;
        recur(cur + 1, cnt);

    }
}