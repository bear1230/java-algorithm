package BOJ.week4.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * N = 성원이 현재 몸무게 ^2 - 성원이가 기억하고 있던몸무게 ^2
 * */
public class BOJ_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long s = 1;
        long e = 2;
        StringBuilder sb =new StringBuilder();
        while (e<100000){
            long numS = s*s;
            long numE = e*e;
            if(numE-numS== N){
                sb.append(e+"\n");
            }
            if(numE-numS>N){
                s++;
            }else {
                e++;
            }
        }
        if(sb.length()==0){
           sb.append(-1);
        }
        System.out.println(sb);

    }
}
