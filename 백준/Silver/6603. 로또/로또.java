

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
 * S = 6
 */
public class Main {
    static int[] arr;
    static int[] ans;
    static int K;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K==0){
                break;
            }
            arr = new int[K];
            ans = new int[6];

            for (int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            recur(0,0);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void recur(int s, int depth) {
        if(depth==6){
            for(int num : ans){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=s; i<K; i++){
            ans[depth] = arr[i];
            recur(i+1,depth+1);
        }
    }
}
