
import java.util.*;
import java.io.*;

class Solution
{
	static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static HashSet<Integer> hash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            map = new int[4][4];
            hash = new HashSet<>();
            StringTokenizer st;
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                   dfs(i,j,0,map[i][j]);
                }
            }

            System.out.println("#" + t + " " + hash.size());
        }
    }

    private static void dfs(int x, int y, int depth, int num) {
        if (depth == 6) {
            hash.add(num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx, ny, depth + 1, num * 10 + map[nx][ny]);
            }
        }
    }
}