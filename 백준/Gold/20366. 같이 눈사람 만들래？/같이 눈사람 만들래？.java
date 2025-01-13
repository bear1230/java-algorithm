import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] snow = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            snow[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snow);
        int answer = Integer.MAX_VALUE;
        
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(i == j) continue;
                int s =0;
      
                int e = N-1;
                while (s<e){
                    if (s == i || s == j) {
                        s++;
                        continue;
                    }

                    if (e == i || e == j) {
                        e--;
                        continue;
                    }

                    answer = Math.min(answer, Math.abs(snow[i] + snow[j] - (snow[s] + snow[e])));

                    if (snow[s] + snow[e] > snow[i] + snow[j]) {
                        
                        e--;
                    } else {
                        s++;
                    }
                }
            }
        }

        System.out.println(answer);

    }

            
}
        
    

