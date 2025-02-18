
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hoof는 scissors를 이김
 * scissors는 Paper를 이김
 * Paper는 Hoof를 이김
 * <p>
 * 비기는 경우 O
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] prefix = new int[N + 1][3];
        
        String H = "H";
        String P = "P";
        String S = "S";


        for (int i = 1; i < N + 1; i++) {
            String input = br.readLine();
            
            if (input.equals(H)) {
                prefix[i][0]++;
            } else if (input.equals(P)) {
                prefix[i][1]++;
            } else if (input.equals(S)) {
                prefix[i][2]++;
            }
            
            prefix[i][0] += prefix[i - 1][0];
            prefix[i][1] += prefix[i - 1][1];
            prefix[i][2] += prefix[i - 1][2];
        }
        
        int answer = Math.max(prefix[N][0], Math.max(prefix[N][1], prefix[N][2]));

        for (int i = 2; i <= N+1; i++) {
            int left = Math.max(prefix[i - 1][0], Math.max(prefix[i - 1][1], prefix[i - 1][2]));
            int right = Math.max(prefix[N][0] - prefix[i - 1][0], Math.max(prefix[N][1] - prefix[i - 1][1], prefix[N][2] - prefix[i - 1][2]));
            answer = Math.max(answer, left + right);
        }
        
        System.out.println(answer);
        
    }
}
