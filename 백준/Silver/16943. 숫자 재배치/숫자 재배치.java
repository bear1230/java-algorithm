import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b;
    static int len;
    static char[] arr;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // a의 자리 수 => string 변환
        String str = Integer.toString(a);
        len = str.length();

        arr = new char[len];
        visited = new boolean[len];

        char[] chArr = str.toCharArray();

        for(int i = 0; i < len; i++) {
            arr[i] = chArr[i];
        }

        recur(0, "");

        if(max == Integer.MIN_VALUE) max = -1;
        System.out.println(max);
    }

    static void recur(int depth, String num) {

        if(depth == len) {
            int sum = Integer.parseInt(num);
            if(sum < b) {
                max = Math.max(max, sum);
            }
            return;
        }

        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                if(num.equals("") && arr[i] == '0') continue;
                visited[i] = true;
                recur(depth+1, num + arr[i]);
                visited[i] = false;
            }
        }
    }
}
