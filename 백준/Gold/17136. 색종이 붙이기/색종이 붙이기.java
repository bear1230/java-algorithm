import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void recur(int cur, int cnt) {
        if (cur == 100) {
            ans = Math.min(cnt, ans);
            return;
        }

        if (ans <= cnt)
            return;

        int x = cur / 10;
        int y = cur % 10;

        if (map[x][y] == 1) {
            for (int i = 5; i > 0; i--) {

                if (paper[i] > 0 && check(x, y, i)) {
                    paper[i] -= 1;
                    fill(x, y, i, 0);
                    recur(cur + 1, cnt + 1);
                    fill(x, y, i, 1);
                    paper[i] += 1;
                }
            }
        } else
            recur(cur + 1, cnt);

    }

    static void fill(int x, int y, int size, int num) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = num;
            }
        }

    }

    static boolean check(int x, int y, int size) {

        if (x + size > 10 || y + size > 10)
            return false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
}
