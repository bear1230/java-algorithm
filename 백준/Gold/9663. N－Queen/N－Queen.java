import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 체스룰로 퀸은 상하좌우, 대각선, 거리제한 없이 한 방향으로 이동 가능.
 * 퀸이 놓여져 있는부분에 이동할 수 있는 방향은 X표시, 남는 칸에만 퀸 놓을 수 있음
 */
public class Main {
    static int[] map;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        dfs(0);
        System.out.println(count);

    }

    private static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[depth] = i;
            if (possible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            //같은 행인지 체크
            if(map[i] == map[col]){
                return false;
            }

            //대각선 ㅊ ㅔ크
            else if (Math.abs(col-i)== Math.abs(map[col]-map[i])) {
                return false;

            }
        }
        return true;
    }
}
