import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }

        int count = N;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                
                if (map.containsKey(token)) {
                    map.remove(token);
                    count--;
                }
            }
            System.out.println(count);

        }

    }
}
