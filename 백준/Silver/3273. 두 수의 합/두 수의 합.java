import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        Arrays.sort(arr);

        int X = Integer.parseInt(br.readLine());

        int s = 0;
        int e = N - 1;
        int cnt = 0;

        while (s < e) {
            if (arr[s] + arr[e] == X) {
                cnt++;
                s++;
                e--;
                
            } else if (arr[s] + arr[e] < X) {
                s++;
                
            } else {
                e--;
            }
        }

        System.out.println(cnt);
    }
}
