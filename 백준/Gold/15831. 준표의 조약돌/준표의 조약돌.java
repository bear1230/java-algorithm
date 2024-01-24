
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 접근 방식
 * 1. 구간 모두 만족 ->  e++, 길이 갱신
 * 2. 만족하지 못할때 -> B가 넘친다면 -> s++ / 아니라면 e++
 * 3.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int s = 0;
        int e = 0;
        int count = 0;
        int cntB = 0;
        int cntW = 0;
        int answer = 0;
        while (e < N) {
            if (cntB > B) {
                if (str.charAt(s) == 'W') {
                    cntW--;
                }
                if (str.charAt(s) == 'B') {
                    cntB--;
                }
                count--;
                s++;

            } else {
                if (str.charAt(e) == 'W') {
                    cntW++;
                }
                if (str.charAt(e) == 'B') {
                    cntB++;
                }
                count++;
                e++;

            }
            if (cntB <= B && cntW >= W) {
                answer = Math.max(answer, count);
            }


        }
        System.out.println(answer);

    }
}





