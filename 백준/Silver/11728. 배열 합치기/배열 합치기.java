import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int numA = 0;
        int numB = 0;
        while (numA < N && numB < M) {
            if (A[numA] < B[numB]) {
                sb.append(A[numA] + " ");
                numA++;
            } else {
                sb.append(B[numB] + " ");
                numB++;
            }
        }

        while (numA < N) {
            sb.append(A[numA] + " ");
            numA++;
        }
        while (numB < M) {
            sb.append(B[numB] + " ");
            numB++;
        }
        System.out.println(sb);

    }
}
