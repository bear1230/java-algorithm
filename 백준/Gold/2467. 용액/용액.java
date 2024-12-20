import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고, 알칼리성 용액의 특성값은 -1부터 -1,000,000,000
 * 두 용액 혼합하여 특성값이 0에 가까운 용액 만들기
 **/
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N - 1;

        int min = Integer.MAX_VALUE;

        int answerS = 0;
        int answerE = 0;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answerS = s;
                answerE = e;
            }
            if (Math.abs(sum) == 0) {
                break;
            }
            if (sum < 0) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(arr[answerS] + " " + arr[answerE]);

    }
}
