import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 개수
		int m = sc.nextInt();	// 나눌 수
		
		long arr[] = new long[m];	// 나머지 인덱스 카운트 배열
		long sum[] = new long[n];	// 합 배열
		long result = 0;
		
		sum[0] = sc.nextInt();
		for (int i = 1; i < n; i++) {	// 합 배열
			sum[i] = sum[i - 1] + sc.nextInt();
		}
		
		
		for (int i = 0; i < n; i++) {
			int remainder = (int)(sum[i] % m);	// 나머지 구함
			
			// 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
			if (remainder == 0) {
				result++;
			}
			
			// 나머지가 같은 인덱스의 개수 카운팅
			arr[remainder]++;
		}
		
		for (int i = 0; i < m; i++) {
			if (arr[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기	3C2 / 2C2
				result = result + (arr[i] * (arr[i] - 1) / 2);
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
}
