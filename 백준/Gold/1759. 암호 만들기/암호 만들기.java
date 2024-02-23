import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, S;
    static char[] arr;
    static char[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new char[S];
        ans = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        recur(0, 0);
        System.out.println(sb);
    }

    private static void recur(int cur, int count) {
        if (count == L) {
            if (check(ans)) {
                for (char c : ans) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        
        if(cur ==S){
            return;
        }

        ans[count] = arr[cur];
        recur(cur + 1, count + 1);
        recur(cur + 1, count);
    }

    private static boolean check(char[] ans) {
        int c = 0;
        int v = 0;
        
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
