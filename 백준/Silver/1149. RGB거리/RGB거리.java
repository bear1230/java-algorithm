import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int[][] dp;

	/*
	 *
	 * 1. 한 노드에 중복적으로 탐색을 하는가.
	2. 한 번 탐색이 완료 된 노드의 값은 불변하는가.

	--- RGB 거리 ---
	집의 개수 N, 거리는 선분
	빨강 초록 파랑 --> 비용 주어짐
	1. 1번의 집 색은 2번의 집 색과 같지 않다
	2. N번의 집색은 N-1번 집 색과 같지 않다
	3. i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
	
	cost[N][0] = min(cost[N-1][1],cost[N-1][2])+cost[N][0]
	  */

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		dp = new int[N][3];
		StringTokenizer st;
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		
		int answer = Math.min(Solution(N-1,0),Math.min(Solution(N-1,1),Solution(N-1,2)));
		System.out.println(answer);
	}

	private static int Solution(int N, int color) {
		if(dp[N][color] ==0) {
			
			if(color == 0) {
				dp[N][0] = Math.min(Solution(N-1,1), Solution(N-1,2))+ map[N][0];
			}else if(color ==1) {
				dp[N][1] = Math.min(Solution(N-1,0), Solution(N-1,2))+map[N][1];
			}else {
				dp[N][2] = Math.min(Solution(N-1,0), Solution(N-1,1))+map[N][2];
			}
		}
		return dp[N][color];
	}

}


