import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] result;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[3][3];
        visited = new boolean[10];
        result = new int[3][3];
        
        min = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, 0);
        System.out.println(min);

    }

    private static void recur(int x, int y, int sum) {
        if (y == 3) {
            x++;
            y = 0;
        }

        if (x == 3) {
            if (!checked()) {
                return;
            }

            min = Math.min(min, sum);

        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            result[x][y] = i;
            recur(x, y + 1, sum + Math.abs(arr[x][y] - i)); // 매직스퀘어 변경 비용
            visited[i] = false;
        }
    }

    private static boolean checked() {
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += result[i][j];
            }
            if (sum != 15) return false;
        }

        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += result[i][j];
            }
            if (sum != 15) return false;
        }

        if (result[0][0] + result[1][1] + result[2][2] != 15 || result[0][2] + result[1][1] + result[2][0] != 15) {
            return false;
        }

        return true;
    }
}
