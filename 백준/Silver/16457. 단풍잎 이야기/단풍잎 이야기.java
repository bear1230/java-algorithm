import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 키의 개수 n, 퀘스트의 개수 m, 퀘스트 당 사용해야 하는 스킬의 수 k
 */
public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[2 * N + 1];
        
        recur(0, 0);
        
        System.out.println(answer);

    }

    private static void recur(int cur, int cnt) {
        if (cur == 2 * N + 1) {
            
            if (cnt == N) {
                int sum = 0;
                for (int i=0; i<M; i++){
                    boolean check = true;
                    for (int j=0; j<K; j++){
                        if(!visited[arr[i][j]]){
                            check = false;
                            break;
                        }

                    }
                    
                    if(check){
                        sum++;
                    }
                }
                
                answer = Math.max(sum,answer);
            }
            
            return;
        }
        
        visited[cur] = true;
        recur(cur + 1, cnt + 1);
        visited[cur] = false;
        recur(cur + 1, cnt);
    }
}