
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = N - 1;
        int answer = 0;
        while (s < e) {
            int min = Math.min(arr[s], arr[e]);
            answer = Math.max((e - s - 1) * min, answer);
            if (arr[s] < arr[e]) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(answer);
    }
}
