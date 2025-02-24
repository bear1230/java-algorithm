import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   
        
        int[] pre = new int[N + 2];
        int[] post = new int[N + 2];
        
        pre[1] = arr[1];
        post[N] = arr[N];
        
        for (int i = 2; i < N; i++) {
            pre[i] = gcd(pre[i - 1], arr[i]);
        }
        
        for (int i = N - 1; i >= 1; i--) {
            post[i] = gcd(post[i + 1], arr[i]);
        }   
        
        int K = -1;
        int max = -1;
        
        for (int i = 1; i <= N; i++) {
            int temp = gcd(pre[i - 1], post[i + 1]);
            if (temp > max) {
                if (arr[i] % temp != 0) {
                    max = temp;
                    K = arr[i];
                }
            }
        }
        
        if (max == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(max + " " + K);
        }
    }
    
    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    
    }
}