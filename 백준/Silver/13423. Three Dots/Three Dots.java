
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 접근방식
 * 완탐 -> for문 3개 돌려서 점의 간격 계산
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int sum = 0;
            int answer = 0;
            for (int i = 0; i < N - 2; i++) {
                for (int j = i+1; j < N - 1; j++) {
                    int diff = arr[j] - arr[i];
                    for (int k = j + 1; k < N; k++) {
                        if (arr[k] - arr[j] > diff) {
                            break;
                        }
                        if (arr[k] - arr[j] == diff) {
                            answer++;
                            break;
                        }
                    }
                }
            }
            System.out.println(answer);
        }

    }
}
