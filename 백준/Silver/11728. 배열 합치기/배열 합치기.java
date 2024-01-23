import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arrN[] = new int[n];
		int arrM[] = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {arrN[i] = Integer.parseInt(st.nextToken());}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {arrM[i] = Integer.parseInt(st.nextToken());}
		StringBuilder sb = new StringBuilder();
		
		int Nindex = 0;
		int Mindex = 0;
		
		while(Nindex + Mindex < m+n) {
			if(Nindex ==n) {
				sb.append(arrM[Mindex++]+" ");
			} else if(Mindex==m) {
				sb.append(arrN[Nindex++]+" ");
			} else {
				if(arrM[Mindex] > arrN[Nindex]) {
					sb.append(arrN[Nindex++]+" ");
				} else {
					sb.append(arrM[Mindex++]+" ");
				}
			}
		}
		System.out.println(sb.toString());
			
	}

}