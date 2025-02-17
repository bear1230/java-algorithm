import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] arr = new String[C];

        for (int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0;j<C; j++){
                if(i==0){
                    arr[j] = String.valueOf(s.charAt(j));
                }
                else {
                    arr[j] += String.valueOf(s.charAt(j));
                }
            }
        }


        for (int i=1; i<R; i++ ){
            TreeSet<String> set = new TreeSet<>();
            for(int j=0; j<C; j++){
                String str = arr[j].substring(i);
  
                if(set.contains(str)){
                    System.out.println(i-1);
                    return;
                }else {
                    set.add(str);
                }
            }
        }
        
        System.out.println(R-1);

    }
}
