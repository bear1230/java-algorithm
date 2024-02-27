import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 3개의 연속된 문제의 답은 같지 않게 한다
 * */
public class Main {
    static int[] arr;
    static int[] select;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        select = new int[10];
        
        recur(0, 0);
        System.out.println(answer);

    }

    private static void recur(int cur, int cnt) {
        if (cur == 10) {
            if (cnt < 5) return;
            
            if (cnt >= 5) {
                answer++;
            }
            
            return;
        }
        
        for (int i = 1; i <= 5; i++) {
            if (cur > 1) {
                if (select[cur - 1] == i && select[cur - 2] == i) {
                    continue;
                }
            }

            select[cur] = i;
            
            if (arr[cur] == i) {
                recur(cur + 1, cnt + 1);
            } else {
                recur(cur + 1, cnt);
            }
        }
    }
}