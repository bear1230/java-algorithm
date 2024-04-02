import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N, M;
    static char[][] arr;
    static int[][] dist;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        arr = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dijkstra();

        System.out.print(dist[N - 1][M - 1]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dy[i];
                int ny = cur.y + dx[i];
                int next = cur.cnt;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (arr[nx][ny] == '1')
                    next++;
                if (dist[nx][ny] > next) {
                    dist[nx][ny] = next;
                    pq.offer(new Node(nx, ny, next));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            return this.cnt - n.cnt;
        }
    }
}
