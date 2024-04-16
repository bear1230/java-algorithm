import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
    static int N;
    static int[] arr;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if (gender == 1) {
                for (int j = num; j <= N; j += num) {
                    if (arr[j] == 1) {
                        arr[j] = 0;
                    } else {
                        arr[j] = 1;
                    }
                }
            } else {
                int left = num - 1;
                int right = num + 1;
                while (left > 0 && right <= N) {
                    if (arr[left] != arr[right]) {
                        break;
                    }
                    left--;
                    right++;
                }

                for (int j = left + 1; j < right; j++) {
                    if (arr[j] == 1) {
                        arr[j] = 0;
                    } else {
                        arr[j] = 1;
                    }
                }


            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);


    }
}
