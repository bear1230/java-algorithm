import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visited;
    static int[][] map;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점
        M = Integer.parseInt(st.nextToken()); // 간선
        
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            map[x][y] = map[y][x] = 1;
        }
        int ans = 0;
        
        for(int i = 1; i<= N; i++){
            //방문 x -> 정점 방문
            if(!visited[i]){
                dfs(i);
                ans++;
            }
        }
        
		System.out.print(ans);
        
    }
    
    public static void dfs(int n){
        visited[n] = true;
        for(int i =1; i <= N; i++){
            if(map[n][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}