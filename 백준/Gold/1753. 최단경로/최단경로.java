import java.util.*;

public class Main {
    private static int V;	// 노드 개수
	private static int E;	// 에지 개수
	private static int s;	// 시작 노드
	private static int distance[];	// 최단 거리 배열
	
	private static int INF = Integer.MAX_VALUE;
	static ArrayList<Node> arr[];	// Node 타입 정점 인접리스트
	
	public static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
	    queue.add(new Node(s, 0));
	    while (!queue.isEmpty()) {
	    	Node node = queue.poll();	// poll : 큐 맨 앞에 있는 값 반환 후 삭제
	        int vertex = node.vertex;	// 노드
	        int weight = node.weight;	// 가중치
			
			if (distance[vertex] < weight) {	// 현재 가중치가 더 크면 갱신할 필요 없음(최단 거리 구하는거라)
				continue;
			}
			for (int i = 0; i < arr[vertex].size(); i++) {	// 해당 정점과 연결된 것들 탐색
				int vertex2 = arr[vertex].get(i).vertex;
				int weight2 = arr[vertex].get(i).weight + weight;
				if (distance[vertex2] > weight2) {	// 새로운 가중치가 더 최단 경로라면 갱신
					distance[vertex2] = weight2;
					queue.add(new Node(vertex2, weight2));	// 노드 추가
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		s = sc.nextInt();
		arr = new ArrayList[V + 1];
		distance = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {	// 인접 리스트 초기화
			arr[i] = new ArrayList<>();
		}
		
		Arrays.fill(distance, INF);
		distance[s] = 0;		// 시작 노드의 가중치는 0
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			arr[u].add(new Node(v ,w));	// 노드 추가
		}
		
		dijkstra();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");	// 최대값이라고 표현
			} else {
				System.out.println(distance[i]);	// 시작 노드부터 각 노드까지의 최단 거리 표현
			}
		}
		
		sc.close();
	}
	
	private static class Node implements Comparable<Node> {		// 우선 순위 큐로 성능 개선(안하면 시간초과)
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override	// 오버라이드: 재정의
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}