import java.util.*;

public class Main {
    public static void main(String[] args) {	// 에라토스테네스의 체
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();	// 처음
		int n2 = sc.nextInt();	// 끝
		
		int arr[] = new int[n2 + 1];
		
		for (int i = 2; i <= n2; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(n2); i++) {
			if (arr[i] == 0)
				continue;
			
			for (int j = i + i; j <= n2; j = j + i) {	
				// j = i + i: 몇 배수로 할 건지 정해줌, j = j + 1: 배수만큼 늘어나서 소수 판멸
				arr[j] = 0;
			}
		}
		
		for (int i = n1; i <= n2; i++) {
			if (arr[i] != 0)	// 각 인덱스의 값이 0이 아닌 애들만 출력
				System.out.println(arr[i]);
		}
		
		sc.close();
	}
}