
import java.util.*;
import java.io.*;


class Solution
{
	static int[] arr;
    static int N;
    static HashSet<Integer> hash;
    static int[] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            visited = new boolean[N + 1][sum + 1];

            hash = new HashSet<>();

            recur(0, 0);

            System.out.println("#" +t+ " " + hash.size());
        }
    }

    private static void recur(int cur, int sum) {

        if (visited[cur][sum]) return;
        if (cur == N) {
            hash.add(sum);
            return;
        }


        visited[cur][sum] = true;
        recur(cur + 1, sum + arr[cur]);

        recur(cur + 1, sum);
    }
}