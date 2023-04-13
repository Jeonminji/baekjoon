import java.io.*;
import java.util.*;

public class Main {
	// 세그먼트 트리 자료구조
	static long tree[];
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 노드 개수
		int m = sc.nextInt();	// 변경이 일어나는 횟수
		int k = sc.nextInt();	// 구간 합을 구하는 횟수
		
		int treeH = 0;	// 트리 높이
		int length = n;
		while (length != 0) {	// 이진 트리의 높이 구함
			length /= 2;
			treeH++;	// 나머지가 0이 아니면 자식 노드가 더 있다는 얘기니까 트리 높이 증가
		}
		
		int treeSize = (int) Math.pow(2, treeH + 1);	// 2^k >= n 만족해야하므로 무조건 커야하니까 + 1
		int leNodeStartIndex = treeSize / 2 - 1; 
		tree = new long[treeSize +1];
		
		// 데이터를 리프 노드의 다음 인덱스부터 입력 받기
		for (int i = leNodeStartIndex + 1; i <= leNodeStartIndex + n; i++) {
			tree[i] = sc.nextLong();
		}
		
		setTree(treeSize - 1);	// tree 초기화
		
		for (int i = 0; i < m + k; i++) {
			int c = sc.nextInt();
			int a = sc.nextInt();
			long b = sc.nextLong();
			
			if (c == 1) {	// 1이면 값 변경 실행
				change(leNodeStartIndex + a, b);
			} else if (c == 2) {	// 2이면 구간 합 실행
				a = a + leNodeStartIndex;
				b = b + leNodeStartIndex;
				System.out.println(getSum(a, (int)b));
			} else {
				return;
			}
		}
		
		
		sc.close();
	}
	
	// c: 선택, s: 시작 노드, e: 끝 노드
	private static long getSum(int s, int e) {		// 구간 합 구하기 메소드
		long partSum = 0;
		
		while (s <= e) {
			if (s % 2 == 1) {	// 노드 선택
				partSum = partSum + tree[s];
				s++;
			}
			
			if (e % 2 == 0) {	// 노드 선택
				partSum = partSum + tree[e];
				e--;
			}
			
			s = s / 2;	// 다음 노드로
			e = e / 2;	// 다음 노드로
		}
		return partSum;
	}
	
	// i: 변경할 인덱스, v: 변경할 값
	private static void change(int i, long v) {		// 값 변경 메소드
		long diff = v - tree[i];
		while (i > 0) {
			tree[i] = tree[i] + diff;
			i = i / 2;
		}
	}
	
	private static void setTree(int i) { 			// 초기 트리 구성 메소드(값 없는 인덱스에다가 넣기)
		while (i != 1) {
			tree[i / 2] += tree[i];
			i--;
		}
	}
}