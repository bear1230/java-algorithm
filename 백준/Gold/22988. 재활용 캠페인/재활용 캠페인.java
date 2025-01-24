

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 재활용 캠페인
 * 용량이 A와 B가 남은 헤어에센서를 가져가면 min(A+B+X/2,X) 의 헤어에센스가 새로 담긴 용기로 바꿔준다
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        int length = N;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == X) {
                cnt++;
                length--;
            } else {
                break;
            }
        }

        int s = 0, e = length - 1;
        int left = 0;

        while (s <= e) {
            if (s == e) {
                left++;
                break;
            }
            long tmp = arr[s] + arr[e];
            if (tmp * 2 >= X) {
                e--;
                s++;
                cnt++;
            } else {
                left++;
                s++;
            }
        }

        System.out.println(cnt + left / 3);


    }
}
