import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        
        int min = Integer.MAX_VALUE;
        int max = -1;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, land[i][j]);
                max = Math.max(max, land[i][j]);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        
        for (int k = min; k <= max; k++) {
            int second = 0;
            int block = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (k > land[i][j]) {
                        second = second + (k - land[i][j]);
                        block = block - (k - land[i][j]);
                    } else {
                        second = second + (land[i][j] - k) * 2;
                        block = block + (land[i][j] - k);
                    }
                }
            }

            if (block < 0) {
                continue;
            }

            if (time >= second) {
                time = second;
                height = Math.max(height, k);
            }
        }

        System.out.println(time + " " + height);
    }
}
