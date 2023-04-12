import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {    
	        // 위상 정렬: 사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt(); // 건물 종류 수

	        ArrayList<Integer> arr[] = new ArrayList[n + 1];
	        int indegree[] = new int[n + 1];      // 진입 차수 배열
	        int value[] = new int[n + 1];       // 본인 건물 짓는 데 걸리는 시간
	        int result[] = new int[n + 1];      // 최종 시간

	        for (int i = 1; i <= n; i++) {		// 초기화
	            arr[i] = new ArrayList<Integer>();
	        }

	        int temp = 0;
	        for (int i = 1; i <= n; i++) {
	            value[i] = sc.nextInt();
	            temp = sc.nextInt();
	            while (temp != -1) {
	            	indegree[i]++;			// temp가 아닌 i 값으로 받음
	            	arr[temp].add(i);		// 리스트에 저장될 temp와 i 값 바뀜
	            	temp = sc.nextInt();
	            }
	        }
	        
	        // 위상 정렬(입력)
	        Queue<Integer> queue = new LinkedList<Integer>();
	        for (int i = 1; i <= n; i++) {
	        	if (indegree[i] == 0) {
	        		queue.add(i);
	        		result[i] = value[i];
	        	}
	        }
	        
	        while(!queue.isEmpty()) {
	        	int now = queue.poll();
	        	for (int i = 0; i < arr[now].size(); i++) {
	        		int next = arr[now].get(i);
	        		indegree[next]--;
	        		
	        		// 자신의 건물을 짓기 전 이저에 가장 오랜 시간이 걸린 값을 찾음
	        		result[next] = Math.max(result[next], result[now] + value[next]);
	        		
	        		if (indegree[next] == 0) {
	        			queue.add(next);
	        		}
	        	}
	        }
	        
	        for (int i = 1; i <= n; i++) {
	        	System.out.println(result[i]);
	        }
	        
	        
	        sc.close();
	 }	
}