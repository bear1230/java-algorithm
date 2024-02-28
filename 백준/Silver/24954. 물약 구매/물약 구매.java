import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] portion, select;
    static ArrayList<Info>[] discount;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    static class Info {
        int num;//물약 번호
        int dis; //할인 금액

        Info(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        portion = new int[N];
        visited = new boolean[N];
        select = new int[N];
        discount = new ArrayList[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            portion[i] = Integer.parseInt(st.nextToken());
            discount[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine());

            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                discount[i].add(new Info(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
            }
        }
        recur(0,0);
        System.out.println(answer);
    }

    private static void recur(int cur,int sum) {
        if (cur == N) {
            answer = Math.min(answer,sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            for (Info info : discount[i]){
                portion[info.num] -= info.dis;
            }

            recur(cur + 1, sum+Math.max(1,portion[i]));

            for (Info info : discount[i]){
                portion[info.num] += info.dis;
            }
            visited[i] = false;
        }
    }
}
