import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* 투포인터
*   1. 기둥 위치 순 정렬
 * 2. 현재기둥 i , j 다음 기둥 ~ N번째 기둥
 * 3. 현재 기둥 i보다  j 보다 작을때까지 탐색
 *    i보다 크지않은 값중 max값 기록
 *    누적합
 *    1. 왼쪽 누적합 , 오른쪽 누적합 계산
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[1002];
        StringTokenizer st;
        for (int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        int[] prefixMax = new int[1001];
        int[] suffixMax = new int[1002];
        for (int i=1; i<=1000; i++){
            prefixMax[i] = Math.max(prefixMax[i-1],map[i]);
        }
        for (int i =1000; i>=1; i--){
            suffixMax[i] = Math.max(suffixMax[i+1],map[i]);

        }
        int answer =0;
        for(int i=1; i<=1000; i++){
            answer+= Math.min(prefixMax[i],suffixMax[i]);
        }
        System.out.println(answer);
    }
}
