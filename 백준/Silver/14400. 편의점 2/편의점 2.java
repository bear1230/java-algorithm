
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
        int[] x = new int[N];
        int[] y = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(x);
        Arrays.sort(y);
        
        long answer = 0;
        int dx = x[(N-1)/2];
        int dy = y[(N-1)/2];
        
        for(int i =0; i<N; i++){
            answer += Math.abs(dx-x[i])+Math.abs(dy-y[i]);
        }

        System.out.println(answer);
    }
}
