

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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = N - 1;
        int answerS = 0;
        int answerE = 0;
        int min = Integer.MAX_VALUE;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answerS = s;
                answerE = e;
            }
            if (Math.abs(sum) == 0) {
                break;
            }
            if (sum > 0) {
                e--;
            } else {
                s++;
            }

        }
        System.out.println(arr[answerS]+" "+arr[answerE]);


    }
}


