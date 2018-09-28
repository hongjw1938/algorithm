package data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

enum Type {
	A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);
	
	// 이와 같이 이름을 붙일 수 있음.
	final private int name;
	private Type(int num) {
		this.name = num;
	}
}
public class GraphImpl {
	private int nV; // 정점(vertex)의 개수
	private int nE; // 간선(edge)의 개수
	private List<ArrayList<Integer>> adList = new ArrayList<>();
	
	GraphImpl(int v_num, int e_num){
		this.nV = v_num;
		this.nE = e_num;
	}
	
	
	public void addEdge(Type fromV, Type toV) {
		adList.get(fromV.ordinal()).add(toV.ordinal());
		nE++;
	}
	
	public void ShowGraphEdgeInfo() {
		Type[] types = Type.values();

		
		for(int i=0; i < nV; i++) {
			Iterator<Integer> iter = adList.get(i).iterator();
			System.out.print(types[i] + "에 저장된 정점 : ");
			if(iter.hasNext()) {
				System.out.print(types[iter.next()] + " ");
			}
			while(iter.hasNext()) {
				System.out.print(types[iter.next()] + " ");
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		
		// 정점의 개수
		int vertex_num = 10;
		// 간선의 개수
		int edge_num = 0;
		
		// 그래프 생성
		GraphImpl graph = new GraphImpl(vertex_num, edge_num);
		
		// 각 정점에 인접한 vertext를 표현한 리스트를 추가한다.
		for(int i=0; i < vertex_num; i++) {
			graph.adList.add(new ArrayList<>());
		}
		
		
		// edge를 계속 추가해준다.
		graph.addEdge(Type.A, Type.B);
		graph.addEdge(Type.A, Type.C);
		graph.addEdge(Type.B, Type.C);
		graph.addEdge(Type.C, Type.D);
		graph.addEdge(Type.D, Type.E);
		graph.addEdge(Type.E, Type.A);
		
		graph.ShowGraphEdgeInfo();

	}
	

}
