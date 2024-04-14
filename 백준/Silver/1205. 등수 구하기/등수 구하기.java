import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 위에서부터 몇 번째 있는 점수인지로 결정,
 * 랭킹 리스트에 올라 갈 수 있는 점수의 개수 P
 * 태수의 새로운 점수가 랭킹 리스트에서 몇등 인지
 */
public class Main {
    static int N, tae, P;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tae = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        score = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && score[N - 1] >= tae) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (score[i] > tae) {
                rank++;
            }else {
                break;
            }
        }

        System.out.println(rank);

    }
}
