
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 보석은 같은 색상만 가져감
 * 보석을 받지 못하는 학생 있어도 됨
 * 접근 방식
 * 완탐 -> 보석 0개부터 소진할때까지 나눠주기 : 학생 수 최대 10억(10^9)-> 시간초과
 * 이분 탐색
 * 1. 각 보석의 개수를 mid값으로 설정한다.
 * 2. s가 최적의 값이 된다.
 * 3. 현재 나눠준 보석의 개수가 학생의 수보다 많으면 -> mid +1;
 * 4. 현재 나눠 준 보석의 개수가 학생의 수보다 적거나 같으면 -> mid-1
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] color = new int[M];
        int e = 0;
        for (int i = 0; i < M; i++) {
            color[i] = Integer.parseInt(br.readLine());
            e = Math.max(color[i], e);
        }
        // 모든 보석을 나눠줘야하기 때문에 최소값 1
        int s = 1;
        int answer =0;
        while (s <= e) {
            int mid = (s+e)/2;
            int sum =0;
            for(int i =0; i<M; i++){
                if(color[i]%mid==0){
                    sum+= color[i]/mid;
                }else {
                    sum+= color[i]/mid +1;
                }
            }
            if(sum>N){
                s = mid+1;
            }else {
                e = mid-1;
                answer = mid;
            }
        }
        System.out.println(answer);


    }
}
