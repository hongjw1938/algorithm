package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MST_Node{
	int from, to, weight;
	
	public MST_Node(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class PrimMST {
	static int n; // 정점의 개수
	static int e; // 간선의 개수
	static ArrayList<MST_Node>[] nodeList; // 각 노드를 저장해 놓는 배열리스트
	static boolean visit[]; // 방문여부 확인
	static int ans;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0;
		n = Integer.valueOf(br.readLine());
		e = Integer.valueOf(br.readLine());
		visit = new boolean[n+1]; // 방문 체크용
		
		nodeList = new ArrayList[n+1];
		
		for(int i=1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		String[] tempStr;
		int from;
		int to;
		int weight;
		for(int i=0; i < e; i++) {
			tempStr = br.readLine().split(" ");
			from = Integer.valueOf(tempStr[0]);
			to = Integer.valueOf(tempStr[1]);
			weight = Integer.valueOf(tempStr[2]);
			nodeList[from].add(new MST_Node(from, to, weight));
			
			nodeList[to].add(new MST_Node(to, from, weight));
		}
		
		MST();
		
	}
	
	public static void MST() {
		Comp cp = new Comp();
		
		// 우선순위 큐를 이용해 최소힙 구성
		PriorityQueue<MST_Node> pq = new PriorityQueue<>(cp);
		
		// 양쪽에서 꺼내고 쓸 수 있는 queue 자료구조
		// 검사할 정점들을 계속해서 넣음
		Deque<Integer> dq = new ArrayDeque<>();
		
		// 시작은 1부터
		dq.add(1);
		
		// 각 정점에 인접한 정점을 저장함
		ArrayList<MST_Node> tempList;
		MST_Node tempNode;
		
		while(!dq.isEmpty()) {
			int currentNode = dq.poll();
			visit[currentNode] = true;
			tempList = nodeList[currentNode];
			for(int i=0; i < tempList.size(); i++) {
				if(!visit[tempList.get(i).to]) {
					pq.add(tempList.get(i));
				}
			}
			
			while(!pq.isEmpty()) {
				tempNode = pq.poll();
				if(!visit[tempNode.to]) {
					visit[tempNode.to] = true;
					ans += tempNode.weight;
					dq.add(tempNode.to);
					break;
				}
			}
		}
		
		System.out.println(ans);
	}

}

class Comp implements Comparator<MST_Node>{

	@Override
	public int compare(MST_Node arg0, MST_Node arg1) {
	
		return arg0.weight > arg1.weight ? 1: -1;
	}
	
}


/*
7
11
1 2 2
2 3 5
1 3 20
1 4 10
4 5 1
5 6 23
3 6 3
3 5 6
7 6 9
7 3 2
2 7 7
*/