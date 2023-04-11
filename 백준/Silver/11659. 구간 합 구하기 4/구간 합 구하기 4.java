import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();	// 수의 개수
		int n2 = sc.nextInt();	// 합의 횟수
		
		int s[] = new int[n1 + 1];
		
		for (int i = 1; i <= n1; i++) {
			int n = sc.nextInt();
			s[i] = s[i - 1] + n;		// 합 배열 공식
		}
		
		for (int i = 1; i <= n2; i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			System.out.println(s[a2] - s[a1-1]);
		}
		
		sc.close();
		
	}
}