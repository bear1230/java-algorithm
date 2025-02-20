
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 홀수 짝수 계산
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] odd = new int[N / 2 + 1]; //홀수
        int[] even = new int[N / 2 + 1]; //짝수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N/2; i++) {
            odd[i] = odd[i - 1] + Integer.parseInt(st.nextToken());
            even[i] = even[i - 1] + Integer.parseInt(st.nextToken());
        }

        int tmp =0;
        int answer = odd[N/2];
        
        for(int i=0; i<N; i++){
            if(i%2==1){
                tmp = odd[i/2]+(even[N/2]-even[i/2]);
            }else {
                tmp = odd[i/2+1]+(even[N/2-1]-even[i/2]);
            }
            answer = Math.max(answer,tmp);
        }
        
        System.out.println(answer);

    }
}

