import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s =0;
        int e =N-1;
        int answer = 0;
        
        while (s<e){
            answer = Math.max(answer,Math.min(arr[s],arr[e])*(e-s-1));
            //더 큰값을 움직이게 되면 최소값은 arr[s]이고 간격이 더 줄어들기 때문에 작은값이 나옴
            if(arr[s]<arr[e]){
                s++;
            }else {
                e--;
            }
        }

        System.out.println(answer);
    }
}
