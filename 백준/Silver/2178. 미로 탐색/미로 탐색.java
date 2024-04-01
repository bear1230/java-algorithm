import java.util.*;
import java.io.*;
/*1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸
 *  (1, 1)에서 출발하여 (N, M)의 위치로 이동
 *  https://leeeehhjj.tistory.com/12
 *  https://infodon.tistory.com/100
*/

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				
			}
		}
		
		bfs(0,0);
        System.out.println(map[N-1][M-1]);

	}

	private static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		visited[x][y] = true;
		que.add(new Node(x,y));
		while(!que.isEmpty()) {
			Node node = que.poll();
			for(int i =0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if( nx >= 0 && ny >=0 && nx < N && ny < M) {
					if(visited[nx][ny] == false && map[nx][ny] ==1) {
						que.add(new Node(nx,ny));
						map[nx][ny] = map[node.x][node.y] +1;
						visited[nx][ny] = true;
					}
					
				}
			}
		}
		
	}

}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
