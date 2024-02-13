

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
완탐 -> 나무길이 1부터 냅다 잘라보기
K*L*W-(C*자른 횟수)
예외 -> 나무를 잘라서 벌 수 있는 돈이 음수일 경우 자르지 않는다

* **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무 개수
        int C = Integer.parseInt(st.nextToken()); // 나무자를때 비용
        int W = Integer.parseInt(st.nextToken()); //나무 한 단위의 가격
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        long answer = Integer.MIN_VALUE;
        for (int i = 1; i <= max; i++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                int count = 0;
                if (arr[j] >= i) {
                    if (arr[j] % i == 0) {
                        count = arr[j] / i - 1;
                    } else {
                        count = arr[j] / i;
                    }
                }
                //나무의 길이*개수*가격 - 자른횟수*자를때 비용
                int tmp = (arr[j] / i) * W * i - (count * C);
                if (tmp > 0) {
                    sum += tmp;
                }
            }
            answer = Math.max(sum,answer);

        }
        System.out.println(answer);
    }
}
