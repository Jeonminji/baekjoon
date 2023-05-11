import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 1;
		int start = 1;
		int end = 1;
		int sum = 1;
		
		while (end != n) {
			if (sum == n) {		// n이랑 연속 합이랑 같음
				count++;
				end++;
				sum += end;
			} else if (sum < n) {	// n이 더 큰 경우
				end++;
				sum += end;
			} else {	// 연속 합이 더 큰 경우
				sum -= start;
				start++;
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}