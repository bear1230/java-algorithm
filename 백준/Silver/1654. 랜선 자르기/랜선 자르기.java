
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 냅다 완탐 1부터 잘라보기 -> 개수 11개 이상 나와야 한다
 *
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); //\

        // 필요한 랜선의 개수
        int[] arr = new int[K];
        long e =0;
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(e<arr[i]){
                e = arr[i];
            }
        }
        e++;
        long s =0;
        while (s<e){
            long mid = (s+e)/2;
            int count =0;
            for(int i =0; i<arr.length; i++){
                count += arr[i]/mid;
            }
            if(count<N){
                e = mid;
            }else {
                s = mid+1;
            }
        }
        System.out.println(e-1);


    }
}
