

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다.  (r, c)
 * 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다
 * 도시의 치킨 거리는 모든 집의 치킨 거리의 합 -> 0은 빈 칸, 1은 집, 2는 치킨집
 * 치킨집과 집의 위치 따로 저장
 */
public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> house = new ArrayList<>();
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        arr = new int[M];
        recur(0, 0);
        System.out.println(answer);

    }

    private static void recur(int start, int cur) {
        if (cur == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int dist = Integer.MAX_VALUE;
                int hx = house.get(i).x;
                int hy = house.get(i).y;
                for (int j = 0; j < M; j++) {
                    int cx = chicken.get(arr[j]).x;
                    int cy = chicken.get(arr[j]).y;
                    dist = Math.min(dist, Math.abs(hx - cx) + Math.abs(hy - cy));
                }
                sum += dist;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            arr[cur] = i;
            recur(i + 1, cur + 1);
        }
    }

}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
