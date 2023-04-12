import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
	static boolean visited[];
	
	public static void DFS(int v) {		// 깊이 우선 탐색 : 재귀 호출
		
		System.out.print(v + " ");    // 방문한 노드 출력
		visited[v] = true;	// 방문했으니까 true로
		
		for (int i : arr[v]) {
			if (visited[i] == false) {    // 방문 안 했으니까 다시 DFS 호출
				DFS(i);
			}
		}
	}
	
	public static void BFS(int v) {		// 너비 우선 탐색 : 큐 이용
		Queue<Integer> queue = new LinkedList<Integer>();    // int 타입의 큐 선언
		queue.add(v);        // 큐에 방문한 노드 삽입
		visited[v] = true;   // 방문했으니까 true로
		
		while (!queue.isEmpty()) {            // 큐가 비어있지 않을 때까지 반복
			int now_node = queue.poll();      // 큐에서 노드 데이터 가져오기
			System.out.print(now_node + " ");
			for (int i : arr[now_node]) {
				if (visited[i] == false) {    // 방문하지 않은 노드들
					visited[i] = true;
					queue.add(i);             // 노드 삽입
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();	// 노드 개수
		int n2 = sc.nextInt();	// 에지 개수
		int n3 = sc.nextInt();	// 시작점
		
		arr = new ArrayList[n1 + 1];	    // 선언
		
		for (int i = 1; i <= n1; i++) {     // 초기화
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n2; i++) {	// 인접 리스트에 노드 저장
			int f = sc.nextInt();
			int s = sc.nextInt();
			
			arr[f].add(s);
			arr[s].add(f);
		}
		
		// 리스트 정렬
		for (int i = 1; i <= n1; i++) {
			Collections.sort(arr[i]);
		}
		
		visited = new boolean[n1 + 1];	// 초기화
		DFS(n3);
		System.out.println();
		
		visited = new boolean[n1 + 1];	// 초기화
		BFS(n3);
			
		
		sc.close();
	}
}