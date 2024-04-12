import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
 * 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
 * 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
 */
public class Main {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            result(str);
        }

    }

    private static void result(String str) {
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        boolean check = false;
        int count = 0;
        String accept = "> is acceptable.";
        String not = "> is not acceptable.";
        
        for (char ch : str.toCharArray()) {
            if (isVowels(ch)) {
                check = true;
            }
            if (isVowels(ch) != isVowels(prev)) {
                count = 1;
            } else {
                count++;
            }

            if (count > 2 || ch == prev) {
                if (ch != 'e' && ch != 'o') {
                    check = false;
                    break;
                }
            }
            prev = ch;
        }

        if (check) {
            sb.append('<').append(str).append(accept);
        } else {
            sb.append('<').append(str).append(not);
        }

        System.out.println(sb);

    }

    private static boolean isVowels(char ch) {
        for (char v : vowels) {
            if (ch == v) {
                return true;
            }
        }
        return false;
    }
}
