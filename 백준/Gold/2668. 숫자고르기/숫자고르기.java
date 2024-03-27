import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int last;
    static ArrayList<Integer> list;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<Integer>();
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= N; i++) {
            visited[i] = true;    
            last = i;
            DFS(i);
            visited[i] = false; 
        }
        
        Collections.sort(list);   
        System.out.println(list.size());
        
        for (int i : list) {
            System.out.println(i);  
        }
    }

    public static void DFS(int cur) {
        if (!visited[arr[cur]]) {
            visited[arr[cur]] = true;
            DFS(arr[cur]);
            visited[arr[cur]] = false;
        }
        
        if (arr[cur] == last) {
            list.add(last);
        }
    }
}
