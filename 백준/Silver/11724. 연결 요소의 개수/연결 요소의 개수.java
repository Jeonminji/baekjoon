import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;	// 그래프 데이터 저장 리스트(ArrayList: 크기가 가변인 배열)
	static boolean visited[];			// 각 노드 방문했는지 배열
	
	public static void DFS(int v) {
		if (visited[v]) {	// 방문한 적 있으면 그냥 종료
			return;
		}
		
		visited[v] = true;	// 메소드 실행하면서 방문 X -> 방문 O 라 true로 변경
		
		for (int i : arr[v]) {	// 방문하지 않은 노드 있나 탐색
			if (visited[i] == false) {	// 연결 노드 중 방문하지 않았던 노드만 탐색하기
				DFS(i);		// 재귀
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt(); // 노드 개수
		int n2 = sc.nextInt(); // 에지(연결) 개수
		
		arr = new ArrayList[n1 + 1];	// 선언
		visited = new boolean[n1 + 1];	// 선언
		
		for (int i = 1; i < n1 + 1; i++) {		// 인접 리스트 초기화
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n2; i++) {
			int f = sc.nextInt();	// 노드2
			int s = sc.nextInt();	// 노드2
			
			arr[f].add(s);	// 양방향이므로 양쪽에 더하기
			arr[s].add(f);
		}
		
		int count = 0;
		
		for (int i = 1; i < n1 + 1; i++) {
			if(!visited[i]) {	// 방문한적 없는 노드라면 dfs
				count++;
				DFS(i);
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}