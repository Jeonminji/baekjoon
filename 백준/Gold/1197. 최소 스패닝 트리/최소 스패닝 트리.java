import java.util.*;

public class Main {
    private static int uf[];	// 유니온 파인드 배열
	private static PriorityQueue<pEdge> queue;
	
	public static void main(String[] args) {	
		// 최소 신장 트리(방향 X): 그래프에서 모든 노드를 연결할 때 사용된 에지들의 가중치의 합을 최소로 하는 트리
		// - 사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않는다.
		// - N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N - 1개
		
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();	// 노드 개수
		int E = sc.nextInt();	// 에지 개수
		queue = new PriorityQueue<>();	// 자동 정렬을 위해 우선 순위 큐 자료구조 선택
		uf = new int[V + 1];
		
		for (int i = 0; i < V; i++) {	// 유니온 파인드 배열 각 인덱스 값과 동일한 값으로 초기화(사이클 확인 용도)
			uf[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();	// 노드1
			int b = sc.nextInt();	// 노드2
			int w = sc.nextInt();	// 가중치
			queue.add(new pEdge(a, b, w)); // 그래프 에지 리스트에 추가
		}
		
		int useEdge = 0;	// 사용한 에지 개수
		int result = 0;
		
		while (useEdge < V - 1) {
			pEdge now = queue.poll();
			if (find(now.a) != find(now.b)) {
				union(now.a, now.b);
				result = result + now.w;	// 가중치 더함
				useEdge++;	// 유니온 했으니까 에지 개수 증가
			}
		}
		
		System.out.println(result);
	}
	
	public static void union(int n1, int n2) {	// 대표 노드끼리 연결
		n1 = find(n1);
		n2 = find(n2);
		
		if (n1 != n2) {
			uf[n2] = n1;
		}
	}
	
	public static int find(int n) {
		if (uf[n] == n) {
			return n;
		} else {
			return uf[n] = find(uf[n]);		// 재귀 함수, 경로 압축 부분
		}
	}
}

class pEdge implements Comparable<pEdge> {
	int a, b, w;
	pEdge(int a, int b, int w) {
		this.a = a;
		this.b = b;
		this.w = w;
	}
	
	@Override
	public int compareTo(pEdge o) {
		// 가중치를 기준으로 오름차순 정렬을 하기 위해 compareTo 재정의
		return this.w - o.w;
	}
}