import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 개수
		int m = sc.nextInt();	// 합
		
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int start = 0;
		int end = n-1;
		
		while (start < end) {
			if (arr[start] + arr[end] < m) {
				start++;
			} else if (arr[start] + arr[end] > m) {
				end--;
			} else {
				end--;
				start++;
				count++;
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}