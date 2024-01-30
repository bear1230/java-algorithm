
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] prefix = new int[N];
        prefix[0] = arr[0];
        int answer = arr[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = Math.max(prefix[i - 1] + arr[i], arr[i]);
            answer = Math.max(answer, prefix[i]);
        }
        System.out.println(answer);
    }
}
