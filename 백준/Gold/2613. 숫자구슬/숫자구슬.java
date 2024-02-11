import java.util.*;
import java.io.*;

public class Main {

	static int size, m, result;
	static int[] list;
	static int[] countList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new int[size];
		countList = new int[m + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		parametric();
		System.out.println(result);
		noZeroGroup();
		
		for (int i = 0; i < m; i++) {
			System.out.print(countList[i] + " ");
		}
	}
	
	private static void parametric() {
		int left = 1;
		int right = size * 100;

		while (left < right) {
			int mid = (left + right) >> 1;

			if (isPossible(mid)) {

				result = mid;
				right = mid;
			} else {
				left = mid + 1;
			}
		}
	}

	private static boolean isPossible(int mid) {
		int count = 0;
		int tempSum = 0;
		int[] tempCount = new int[m + 1];
		for (int i = 0; i < size; i++) {
			if (list[i] > mid) {
				return false;
			}
			if (tempSum + list[i] > mid) {
				tempSum = list[i];
				count++;
			} else {
				tempSum += list[i];
			}
			if (count >= m) {
				return false;
			}
			tempCount[count]++;
		}
		countList = tempCount;
		return true;

	}
	
	private static void noZeroGroup() {
		int index;
		for (int i = 0; i < m; i++) {
			if (countList[i] == 0) {
				index = i - 1;
				countList[i]++;
				while (true) {
					if (countList[index] == 1) {
						index--;
						continue;
					}
					break;
				}
				countList[index]--;
			}
		}
	}

}
