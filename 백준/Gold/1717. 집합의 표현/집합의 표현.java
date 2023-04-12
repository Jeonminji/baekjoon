import java.util.*;

public class Main {
    public static int arr[];

	public static void main(String[] args) {	// 유니온 파인드
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();	// 원소 개수
		int n2 = sc.nextInt();	// 질의 개수
		
		arr = new int[n1 + 1];
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < n2; i++) {
			int q = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (q == 0) {
				unione(x,y);
			} else if (q == 1) {
				System.out.println(checkSame(x, y) ? "YES" : "NO");
			}
		}
		
		sc.close();
	}
	
	public static void unione(int x, int y) {	// union 연산 : 대표 노드끼리 연결
		x = find(x);	// 대표 노드 찾음
		y = find(y);	// 대표 노드 찾음
		if (x != y) {
			arr[y] = x;
		}
	}
	
	public static int find(int v) {		// find 연산 : 매개변수가 속한 집단의 대표 노드 반환
		if (arr[v] == v) {
			return v;
		} else {
			return arr[v] = find(arr[v]);	// 재귀 함수의 형태로 구현 -> 경로 압축 부문
		}
	}
	
	public static boolean checkSame(int x, int y) {	// 대표 노드 같으면 true, 다르면 false (두 원소가 같은 집합인지 확인)
		x = find(x);
		y = find(y);
		
		if (x == y)
			return true;
		else
			return false;
	}
}