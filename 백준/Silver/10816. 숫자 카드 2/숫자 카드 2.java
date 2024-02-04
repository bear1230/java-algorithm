

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[20000001];
        StringBuilder  sb = new StringBuilder();
        for(int i =0; i<N;i++){
            card[Integer.parseInt(st.nextToken())+10000000] +=1 ;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i =0; i<M; i++){
            int num = card[Integer.parseInt(st.nextToken())+10000000];
            if(num >= 1){
                sb.append(num).append(" ");
            }else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

    }
}
