import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sour;
    static int[] bitter;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0, 1,0);
        
        System.out.println(answer);
    }

    private static void recur(int cur, int count, int s, int b)  {
        if (cur == N){
            if(count!=0){
                answer = Math.min(answer,Math.abs(s-b));
            }
            
            return;
        }

        recur(cur+1,count+1,sour[cur]*s, bitter[cur]+b);
        recur(cur+1,count,s,b);
    }
}