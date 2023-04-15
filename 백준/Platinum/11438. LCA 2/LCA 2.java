import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> tree[];
	static int depth[];
	static int kmax;
	static int parent[][];
	static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		depth = new int[n+1];
		visited = new boolean[n+1];
		int temp = 1;
		kmax = 0;
		
		while (temp <= n) {
			temp <<= 1;
			kmax++;
		}
		
		parent = new int[kmax + 1][n + 1];
		BFS(1);
		
		for (int k = 1; k <= kmax; k++) {
			for (int j = 1; j <= n; j++) {
				parent[k][j] = parent[k - 1][parent[k - 1][j]];
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int LCA = excuteLCA(a, b);
			System.out.println(LCA);
		}
	}
	
	static int excuteLCA(int a, int b) {
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for (int k = kmax; k >= 0; k--) {
			if (Math.pow(2, k) <= depth[b] - depth[a]) {
				if (depth[a] <= depth[parent[k][b]]) {
					b = parent[k][b];
				}
			}
		}
		
		for (int k = kmax; k >= 0; k--) {
			if (parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		
		int LCA = a;
		if (a != b) LCA = parent[0][LCA];
		
		return LCA;
	}
	
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;
		int level = 1;
		int now_size = 1;
		int count = 0;
		
		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (int next : tree[now_node]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					parent[0][next] = now_node;
					depth[next] = level;
				}
			}
			count++;
			
			if (count == now_size) {
				count = 0;
				now_size = queue.size();
				level++;
			}
		}
	}
}