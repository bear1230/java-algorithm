
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 수로 이루어진 수열 A1, A2, ..., AN
 * 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)
 * <p>
 * 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다.
 * 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
 * <p>
 * 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)
 */
public class Main {
    static int N;
    static int[] arr;
    static int[] oper;// 0 : + , 1 :-, 2: x, 3 : ÷
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        recur(arr[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void recur(int sum, int cur) {
        if (cur ==N){
            MAX = Math.max(MAX,sum);
            MIN = Math.min(MIN,sum);
            return;
        }
            for (int i = 0; i < 4; i++) {
                if (oper[i] > 0) {
                    oper[i]--;
                    switch (i) {
                        case 0:
                            recur(sum + arr[cur], cur + 1);
                            break;
                        case 1:
                            recur(sum - arr[cur], cur + 1);
                            break;
                        case 2:
                            recur(sum * arr[cur], cur + 1);
                            break;
                        case 3:
                            recur(sum / arr[cur], cur + 1);
                            break;
                    }
                    // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구
                    oper[i]++;
                }
            }
    }
}
