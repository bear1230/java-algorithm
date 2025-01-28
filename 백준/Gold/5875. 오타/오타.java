import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '('){
                left++;
                sum++;
            }
            else{
                right++;
                sum--;
            }

            if(sum == 1){
                left = 0;
            }

            if(sum == -1){
                ans = right;
                break;
            }
        }

        if(sum == 2)
            ans = left;

        System.out.println(ans);
    }
}
