

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int map[] = new int[N];
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        int answer =1;
        int count=0;
        for(int i=0; i<N;i++){
            int temp = map[i];
            int curNum = 0;
            for (int j =1; j<N; j++){
                if(temp==map[j]){
                    continue;
                }
                if(map[j]!= curNum){
                    answer = Math.max(count,answer);
                    curNum = map[j];
                    count = 1;
                } else {
                    count++;
                }
            }
            answer = Math.max(count,answer);
        }
        System.out.println(answer);
    }
}
