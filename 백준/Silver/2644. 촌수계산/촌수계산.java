
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Integer>> list;
    static boolean isVisited[];
    static int person1,person2;
    static int size = -1;
    static boolean isFind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        //촌수를 계산해야하는 서로 다른 두 사람의 번호
        st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[N+1];

        M = Integer.parseInt(br.readLine()); //부모자식들 간의 관계의 개수

        for(int i=0;i<=N;i++) list.add(new ArrayList<>());

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //y의 부모
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(person1,0);
        System.out.println(size);

    }

    private static void dfs(int person,int cnt) {
        isVisited[person] = true;

        for(Integer c : list.get(person)){
            if(!isVisited[c]){
                if(c == person2){
                    size = cnt+1;
                    return;
                }

                dfs(c,cnt+1);
            }
        }

    }
}