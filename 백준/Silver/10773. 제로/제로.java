import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        //FILO
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                stack.pop();
            }else {
                stack.push(num);
            }
        }


        int answer = 0;
        for (int num : stack) {
            answer += num;
        }

        System.out.println(answer);     
    }
}
