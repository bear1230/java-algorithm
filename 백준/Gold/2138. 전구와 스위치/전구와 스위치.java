import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * . i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다.
 * 맨 첫번째 전구, 맨 마지막 전구만 2번 영향받음
 * */
public class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static boolean[] isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String start = br.readLine();
        String target = br.readLine();

        boolean[] cur = new boolean[N];
        boolean[] change = new boolean[N];
        
        isCheck = new boolean[N];

        for(int i = 0; i < N; i++){
            cur[i] = start.charAt(i) == '0';
            change[i] = start.charAt(i) == '0';
            isCheck[i] = target.charAt(i) == '0';
        }

        dfs(1, 0, cur);
        dfs(1, 1, check(0, change));

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void dfs(int num, int count, boolean[] arr){
        if(num == N){
            if(arr[num - 1] == isCheck[num-1]){
                answer = Math.min(count, answer);
            }
            return;
        }

        if(arr[num - 1] != isCheck[num - 1]){
            dfs(num + 1, count + 1, check(num, arr));
        }
        else{
            dfs(num + 1, count, arr);
        }
        
    }

    public static boolean[] check(int num, boolean[] arr){
        for(int i = num - 1; i <= num + 1; i++){
            if(i >=0 && i < N){
                arr[i] = !arr[i];
            }
        }
        return arr;
    }
}
