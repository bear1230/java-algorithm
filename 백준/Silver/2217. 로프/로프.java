import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr, Collections.reverseOrder());  
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, arr[i] * (i+1));
        }
        
        System.out.print(answer);
    }
}
