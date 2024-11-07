import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int cnt = 0;
        int total = arr[0];
        
        while (e < N) {
            if (total < M) {
                e++;
                total += arr[e];
                
            } else if (total > M) {
                total -= arr[s];
                s++;
                
            } else {
                cnt++;
                
                total -= arr[s];
                s++;
                e++;
                total += arr[e];
            }
        }
        
        System.out.println(cnt);

    }
}
