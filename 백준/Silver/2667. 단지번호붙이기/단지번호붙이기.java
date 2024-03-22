import java.io.*;
import java.util.*;

/*
 * 1 : 집 O, 2: 집 X
 * 좌 우 아래 위 다른집 , 대각선 연결 X
 * 
 * */
public class Main {
	static int[][] map;
	static int N;
	static boolean[][] visited = new boolean[25][25];
	static int apartNum = 0;
	static int[] aparts = new int[25*25];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N]; 

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j =0; j<N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
			
		}
		
		for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    dfs(i,j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            }else{               
                System.out.println(aparts[i]);
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        aparts[apartNum]++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < N && ny < N){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
 


