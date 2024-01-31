

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 완탐 -> 시간초과
 * 1. A배열의 부분합 모두 구하기, 횟수 기록 -> Map 사용
 * 2. B배열의 부분합 모두 구하기, 횟수 기록
 * 3. A배열 + B배열 중 합 T인 경우 세기
 * **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M+1];
        Map<Long, Long> sumA = new HashMap<>();
        Map<Long, Long> sumB = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=N; i++){
            long sum =0;
            for (int j =i; j<=N; j++){
                sum+=A[j];
                sumA.put(sum,sumA.getOrDefault(sum,0L)+1);
            }
        }


        for(int i=1; i<=M; i++){
            long sum =0;
            for (int j =i; j<=M; j++){
                sum+=B[j];
                sumB.put(sum,sumB.getOrDefault(sum,0L)+1);
            }
        }
        long cnt =0;
        for(Map.Entry<Long,Long> entry: sumA.entrySet()){
            long bKey = T-entry.getKey();
            if(sumB.containsKey(bKey)){
                cnt+= entry.getValue()*sumB.get(bKey);
            }

        }
        System.out.println(cnt);
    }
}
