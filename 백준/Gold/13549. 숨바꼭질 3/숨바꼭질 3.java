import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치
 * <p>
 * move +1 -> 가중치 1
 * move -1 -> 가중치 1
 * move *2 -> 가중치 0
 **/
public class Main {
    static int N, K;
    static boolean[] visited;
    static int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[max];

        if(N==K){
            System.out.println(0);
        }else {
            bfs(N);
        }
    }

    private static void bfs(int num) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(num, 0));
        visited[num] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.to == K) {
                System.out.println(node.time);
                return;
            }

            int move = node.to * 2;
            if (move < max && !visited[move]) {
                visited[move] = true;
                q.offer(new Node(move, node.time));
            }

            move = node.to - 1;
            if (move >= 0 &&!visited[move]){
                visited[move] = true;
                q.offer(new Node(move,node.time+1));
            }
            
            move = node.to +1;
            if(move <max &&!visited[move]){
                visited[move] = true;
                q.offer(new Node(move,node.time+1));
            }

        }
    }

    static class Node {
        int to;
        int time;

        Node(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
}
