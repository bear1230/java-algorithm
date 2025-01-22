import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 병사 : 힘 민첩 지능
 * 진수 : 힘 민첩 지능
 * 진수가 병사보다 가진 스탯이 더 크면 병사 이김
 * 적어도 K명의 병사를 이길 수 있는 스탯 포인트 구하기
 * <p>
 * 1.  nCk의 경우의 수를 모두 본다 -> nCk 엄청 크다
 * 2. 힘 민첩 지능을  -> 100만^3 => 백경 => 훨씬 빠르게 만들어야 함
 * 0 0 0 => 몇명 이기나 본다
 * 0 0 1 => 몇명 이기나 본다
 * 0 0 2 => 몇명 이기나 본다
 * ......
 * 0 0 1000000 => 몇명 이기나 본다
 * 0 1 0 => 몇명 이기나본다
 * ......
 * 1000000 1000000 1000000 => 몇명 이기나 본다
 * <p>
 * 어떻게 줄일까?
 * 굳이 주어진 스탯과 관련 없는 숫자를 볼 필요 없다
 * 10 30 50이 힘으로 주어져 있으면 31 35 이런 숫자를 볼 필요는 없음
 * 실제 주어진 숫자 100개만 보면 됨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stats = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stats[i][0] = Integer.parseInt(st.nextToken()); //str
            stats[i][1] = Integer.parseInt(st.nextToken()); //dex
            stats[i][2] = Integer.parseInt(st.nextToken()); //int
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    int count = 0;

                    for (int m = 0; m < N; m++) {
                        if (stats[i][0] >= stats[m][0] && stats[j][1] >= stats[m][1] && stats[k][2] >= stats[m][2]) {
                            count++;
                        }
                    }

                    if (count >= K) {
                        answer = Math.min(answer, stats[i][0] + stats[j][1] + stats[k][2]);
                    }
                }
            }

        }

        System.out.println(answer);


    }
}
