import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
        
		/*
		  range : -1000 ~ 1000
		  0 은 index[1000] 을 의미
		*/
		int[] arr = new int[20000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken()) + 10000000]+= 1;
		}
		int M = Integer.parseInt(br.readLine());
		// 정렬 과정이 따로 필요 없음
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			if(arr[Integer.parseInt(st.nextToken())+10000000] > 0) {
				sb.append(1).append(' ');
			} else {
				sb.append(0).append(' ');
			}
		}
		System.out.println(sb);

	}

}
