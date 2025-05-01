
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 퀸은 대각선, 수평선으로 이동 가능
 * 퀸 N개를 서로 공격할 수 없는 위치에 놓기.
 * 0,0에 퀸 있으면 x+1,0 0,y+1, x+1. y+1 증가하는곳에 놓을수 없음
 * */
public class Main {
    static int N;
    static int[] board;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];
        recur(0);
        System.out.println(count);

    }

    private static void recur(int cur) {

        if (cur == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[cur] = i;
            //cur열에서 i번쨰 행에 놓을 수 있는지 체크
            if (check(cur)) {
                recur(cur+1);
            }

        }
    }

    //cur: 열, 값 : 행
    private static boolean check(int cur) {
        for (int i = 0; i < cur; i++) {
            if (board[cur] == board[i]) {
                return false;
            }

            //열의 차이 == 행의 차이 같은 대각선
            if (Math.abs(cur - i) == Math.abs(board[cur] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
