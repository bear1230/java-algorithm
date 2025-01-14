

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 횡단보도 N개
 * 연속한 신호등 k개
 * 고장난 시호등 B개
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            visited[num] = true;
        }

        
        int count =0;
        for (int i =1; i<=K; i++){
            if(visited[i]){
                count++;
            }

        }
        int min =count;
        for(int i=K+1;i<=N; i++){
            if(visited[i-K]){
                count--;
            }
            if (visited[i]){
                count++;
            }
            min = Math.min(min,count);
        }

        System.out.println(min);

    }
}
