
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
 * 암호에서 증가하는 순서로
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] ans;
    static char[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new char[C];
        ans = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            ch[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(ch);
        recur(0, 0);
        System.out.println(sb);

    }

    private static void recur(int start, int cur) {
        if (cur == L) {
            if (check(ans)) {
                for (char c : ans) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            ans[cur] = ch[i];
            recur(i + 1, cur + 1);
        }
    }

    private static boolean check(char[] ans) {
        int c = 0;// 자음
        int v = 0;//모음
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u') {
                c++;
            } else {
                v++;
            }
        }
        if (c >= 1 && v >= 2) {
            return true;
        }
        return false;
    }
}
