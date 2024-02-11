

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * A[i] != A[i+1]
 * 만약 같지 않다면 최소값 -> i+1
 * Ai = Aj 라면 Aj의 idx값을 가져온다.
 *
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = -1;

        int[] answer = new int[N+1];
        answer[N] =-1;
        for(int i = N-1; i>0; i--){
            if(arr[i]!= arr[i+1]){
                answer[i] = i+1;
            }else {
                answer[i] = answer[i+1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i =1; i<=N; i++){
            sb.append(answer[i]+" ");
        }
        System.out.println(sb);

    }
}
