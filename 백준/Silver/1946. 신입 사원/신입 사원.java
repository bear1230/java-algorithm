import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 * 서류 심사 기준으로  sort -> 1등의 면접성적보다 등수가 낮다면 선발 x
 * 1 4
 * 2 3 (면접 4>3등 선발)
 * 3 2 (면접 3>2등 선발)
 * 4 1 (면접 2>1등 선발)
 * 5 5 (선발 x)
 */
public class Main {
    static int T, N;
    static int[] arr; //arr[서류] = 면접등수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a - 1] = b;
            }

            int count = 1;
            int rank = arr[0];
            
            for (int i = 1; i < N; i++) {
                if (arr[i] < rank) {
                    count++;
                    rank = arr[i];
                }
            }
            
            System.out.println(count);
        }
    }
}
