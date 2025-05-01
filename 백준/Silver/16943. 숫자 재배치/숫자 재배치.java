import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static char[] chNum;
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        String str = Integer.toString(A);
        chNum = str.toCharArray();
        len = chNum.length;
        visited = new boolean[len];

        recur(0,"");
        if(answer == Integer.MIN_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void recur(int cur, String s) {
        if (cur == len) {
            int maxS = Integer.parseInt(s);
            if(maxS < B){
                answer = Math.max(maxS,answer);
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if(visited[i]) continue;
            if(s.equals("") && chNum[i] == '0'){
                continue;
            }
            visited[i] = true;
            recur(cur +1,s + chNum[i]);
            visited[i] = false;

        }
    }
}
