import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int s = 0;

        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input > s) {
                for (int i = s + 1; i <= input; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                s = input;

            } else if (stack.peek() != input) {
                System.out.println("NO");
                return;
            }

            // stack.peek() == num일 경우
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}

