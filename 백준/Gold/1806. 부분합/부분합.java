import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;
        int total = arr[0];
        while (e < N) {
            if (total >= S) {
                min = Math.min(min,e-s+1);
                total -= arr[s];
                s++;

            }else {
                e++;
                if(e==N){
                    break;
                }
                total+= arr[e];
            }

        }
        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min);
        }

    }
}
