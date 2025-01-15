import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * 벽 높이 : [3, 1, 2, 3, 4, 1, 1, 2]
 * 왼 -> 오
 * 최대 높이 : [3, 3, 3, 3, 4, 4, 4, 4]
 * 오-> 왼
 * 최대 높이 : [4, 4, 4, 4, 4, 2, 2, 2]
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] left = new int[W];
        int[] right = new int[W];
        int height = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            left[i] = Integer.parseInt(st.nextToken());
            height = Math.max(height,left[i]);
            right[i] = height;

        }
        height = 0;
        int answer= 0;
        for(int i =W-1; i>=0; i--){
            height = Math.max(height,left[i]);
            right[i] = Math.min(height,right[i]);
            answer += right[i]- left[i];
        }
        System.out.println(answer);

    }
}
