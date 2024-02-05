
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 완탐 : 막걸리 용량 1부터 끝값까지 나눠주기 (막걸리 2^31 , 친구 K명 -> 시간초과)
 * 주전자 N개 , 친구수 K명( N ≤ K )
 * 접근 방식: 이분탐색
 * 1. mid = 1 + 막걸리 max /2
 * 2. 나눠준 막걸리 주전자의 개수가 K명보다 많으면 mid+1
 * 3. 적으면 mid-1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long e = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, arr[i]);
        }
        long s = 1;
        long answer =0;
        while (s <= e) {
            int count =0;
            long mid=(s+e)/2;
            for(int i=0; i<N; i++){
                count += arr[i]/mid;
            }
            if(count>=K){
                s= mid+1;
                answer = mid;
            }else {
                e= mid-1;

            }
        }
        System.out.println(answer);

    }
}
