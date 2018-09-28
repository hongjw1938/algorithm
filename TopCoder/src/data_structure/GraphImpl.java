package data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

enum Type {
	A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);
	
	// �̿� ���� �̸��� ���� �� ����.
	final private int name;
	private Type(int num) {
		this.name = num;
	}
}
public class GraphImpl {
	private int nV; // ����(vertex)�� ����
	private int nE; // ����(edge)�� ����
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
			System.out.print(types[i] + "�� ����� ���� : ");
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
		
		// ������ ����
		int vertex_num = 10;
		// ������ ����
		int edge_num = 0;
		
		// �׷��� ����
		GraphImpl graph = new GraphImpl(vertex_num, edge_num);
		
		// �� ������ ������ vertext�� ǥ���� ����Ʈ�� �߰��Ѵ�.
		for(int i=0; i < vertex_num; i++) {
			graph.adList.add(new ArrayList<>());
		}
		
		
		// edge�� ��� �߰����ش�.
		graph.addEdge(Type.A, Type.B);
		graph.addEdge(Type.A, Type.C);
		graph.addEdge(Type.B, Type.C);
		graph.addEdge(Type.C, Type.D);
		graph.addEdge(Type.D, Type.E);
		graph.addEdge(Type.E, Type.A);
		
		graph.ShowGraphEdgeInfo();

	}
	

}
