
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int money[] = new int[N+1];

        arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b, money);
        }
        int sum = 0;
        for(int i=1; i<=N; i++) {
            if(arr[i] == i) {
                sum += money[i];
            }
        }
        if(k - sum < 0) {
            System.out.println("Oh no");
        }
        else {
            System.out.println(sum);
        }

    }

    private static void union(int a, int b, int[] money) {
        int numA = find(a);
        int numB = find(b);
        
        if(numA != numB) {
            if(money[numA] > money[numB]) {
                arr[numA] = numB;
            }
            else {
                arr[numB] = numA;
            }
        }
    }

    private static int find(int a) {
        if(arr[a] == a){
            return a; 
        } 
        
        return arr[a] = find(arr[a]);
    }
}
