import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 정해진 총액 이하에서 가능한 한 최대의 총 예산
 */
public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        int e = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            e = Math.max(arr[i], e);
        }

        M = Integer.parseInt(br.readLine());

        int mid;
        int s = 0;

        while (s <= e) {
            mid = (s + e) / 2;
            long budget = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    budget += mid;
                } else {
                    budget += arr[i];
                }
            }

            if (budget <= M) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println(e);

    }
}
