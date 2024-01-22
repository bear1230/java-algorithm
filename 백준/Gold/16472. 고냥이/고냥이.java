import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] alphabet = new int[26];
        int answer = 0;
        int s = 0;
        int e = 0;
        int count = 1;
        alphabet[str.charAt(s) - 'a']++;
        while (e < str.length()-1) {
            if(count<=N){
                e++;
                if (alphabet[str.charAt(e) - 'a'] == 0) {
                    count++;
                }
                alphabet[str.charAt(e) - 'a']++;
            }

            while (count > N && s < e) {
                alphabet[str.charAt(s) - 'a']--;
                if (alphabet[str.charAt(s) - 'a'] == 0) {
                    count--;
                }
                s++;
            }
            answer = Math.max(answer, e - s+1);

        }


        System.out.println(answer);
    }

}
