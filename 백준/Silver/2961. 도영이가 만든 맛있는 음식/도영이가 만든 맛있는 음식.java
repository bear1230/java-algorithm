import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] S;
    static int[] B;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        //신맛은 곱이기 때문에 1
        recur(0, 0, 1, 0);

        System.out.println(min);
    }

    private static void recur(int cur, int cnt, int sNum, int bNum) {
        if (cur == N) {
            if (cnt != 0) {
                int sub = Math.abs(sNum - bNum);
                min = Math.min(min, sub);
            }
            return;
        }

        //재료를 고른경우
        recur(cur + 1, cnt + 1, sNum * S[cur], bNum + B[cur]);
        //안고른 경우
        recur(cur + 1, cnt, sNum, bNum);
    }
}
