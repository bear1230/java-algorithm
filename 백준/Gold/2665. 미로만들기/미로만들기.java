import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int[][] cnt;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        cnt = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                cnt[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=1; i<=N; i++) {
            String input = br.readLine();
            for(int j=1; j<=N; j++) {
                map[i][j] = 1 - (input.charAt(j-1) - '0');
            }
        }
        bfs(1, 1);
        System.out.println(cnt[N][N]);
    }

    public static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        cnt[1][1]=0;
        while(!queue.isEmpty()) {
            Pair p = queue.poll();

            for(int i=0; i<4; i++) {
                int X = p.x+dx[i];
                int Y = p.y+dy[i];

                if(X>=1 && Y>=1 && X<=N && Y<=N) {
                    if(cnt[X][Y] > cnt[p.x][p.y]+map[X][Y]) {
                        cnt[X][Y] = cnt[p.x][p.y]+map[X][Y];
                        queue.add(new Pair(X, Y));
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}