package data_structure;

class Node<T>{
	private Node leftSub;
	private Node rightSub;
	private T data;
	
	Node(T data){
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getLeftSub() {
		return leftSub;
	}

	public Node getRightSub() {
		return rightSub;
	}

	public void setLeftSub(Node left) {
		this.leftSub = left;
	}

	public void setRightSub(Node right) {
		this.rightSub = right;
	}

}



public class BinaryTreeImpl<T> {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node1.setLeftSub(node2);
		node1.setRightSub(node3);
		
		inorderTraverse(node1);
		System.out.println("-------------------");
		preorderTraverse(node1);
		System.out.println("-------------------");
		postorderTraverse(node1);
	}
	
	public static void inorderTraverse(Node startNode) {
		if(startNode == null) {
			return;
		}
		
		inorderTraverse(startNode.getLeftSub());
		System.out.println(startNode.getData());
		inorderTraverse(startNode.getRightSub());
	}
	
	public static void preorderTraverse(Node startNode) {
		if(startNode == null) {
			return;
		}
		
		System.out.println(startNode.getData());
		preorderTraverse(startNode.getLeftSub());
		preorderTraverse(startNode.getRightSub());
	}
	
	public static void postorderTraverse(Node startNode) {
		if(startNode == null) {
			return;
		}
		
		postorderTraverse(startNode.getLeftSub());
		postorderTraverse(startNode.getRightSub());
		System.out.println(startNode.getData());
	}
}
