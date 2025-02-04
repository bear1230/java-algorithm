

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1번부터 N번까지의 번호가 붙은 횡단보도 N개
 * <p>
 * 연속한 K개의 신호등이 존재하도록 신호등 수리
 * B줄 -> 고장난 신호등의 번호
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] broken = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            broken[num] = true;
        }

        int count = 0;
        for (int i = 1; i <= K; i++) {
            if (broken[i]) count++;
        }


        int min = K;
        int s = 1;
        int e = K;
        while (e < N) {
            if (broken[s++]) count--;
            if (broken[++e]) count++;

            min = Math.min(count, min);
        }

        System.out.println(min);


    }
}
