import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        // 좋은 수 구하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);	// 오름차순 정렬
		
		for (int k = 0; k < n; k++) {			
			int sum = arr[k];
			int i = 0;		// 처음 인덱스로 초기화
			int j = n-1;	// 가장 큰 인덱스로 초기화
            
            // 투 포인터 알고리즘
			while (i < j) {							
				if (arr[i] + arr[j] == sum) {		// 찾는 값과 각 인덱스 값이 같지 않아야 count 증가(서로 다른 두 수의 합)
					if (i != k && j != k) {
						count++;
						break;
					} else if (i == k) {	// 작은 값 i가 찾는 값과 같으면 i 증가
						i++;
					} else {	// 큰 값 j가 찾는 값과 같으면 j 증가
						j--;
					}
				} else if (arr[i] + arr[j] < sum) {		// 번호의 합이 sum보다 작으므로 작은 번호 index를 올린다.
					i++;
				} else {					// 번호의 합이 sum보다 크므로 큰 번호 index를 내린다,
					j--;
				}
			}
		}
		
		
		System.out.println(count);
		sc.close();
		
	}
}