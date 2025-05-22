import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * d 0 북쪽, 1동쪽, 2 남쪽, 3서쪽
 * <p>
 * map[n][m] -> 0 청소x빈칸 , 1벽, 2를 청소로 처리
 * <p>
 * 현재 칸의 주변
 * $4$칸 중 청소되지 않은 빈 칸이 있는 경우,
 * 반시계 방향으로 90도 회전
 */

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                answer++;
            }

            boolean check = false;
            for (int i = 0; i < 4; i++) {
                //칸 청소 후 반시계 90도 회전한다
                d = (d + 3) % 4;
                int nx = x + dx[d]; // d 0 북쪽, 1동쪽, 2 남쪽, 3서쪽
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                    x = nx;
                    y = ny;

                    check = true;
                    break;
                }
            }

            if (!check) {
                int back = (d + 2) % 4;
                int nx = x + dx[back];
                int ny = y + dy[back];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1) break;

                x = nx;
                y = ny;
            }

        }

        System.out.println(answer);
    }


}