package data_structure;

public class BinarySearchTreeImpl<T extends Integer> {
	private class BtreeNode<T> {
		private BtreeNode<T> left;
		private BtreeNode<T> right;
		
		T data;
		
		BtreeNode(T data) {
			left = null;
			right = null;
			this.data = data;
		}
	}
	
	private BtreeNode<T> rootNode;
	private int node_num;
	
	public BinarySearchTreeImpl() {
		rootNode = null;
		node_num = 0;
	}
	
	// 노드를 생성한다.
	public BtreeNode<T> createNode(T data) {
		BtreeNode<T> newNode = new BtreeNode<T>(data);
		
		return newNode;
	}
	
	// 노드를 삽입
	public void insertNode(BtreeNode<T> node) {
		// 루트가 비어있으면
		if(rootNode == null) {
			rootNode = node;
		// 루트가 존재하면
		} else {
			BtreeNode<T> pNode = rootNode;
			while(pNode != null) {
				if(pNode.data > node.data) {
					if(pNode.left == null) {
						pNode.left = node;
						break;
					} else {
						pNode = pNode.left;
					}
				} else if(pNode.data < node.data) {
					if(pNode.right == null) {
						pNode.right = node;
						break;
					} else {
						pNode = pNode.right;
					}
				} else {
					return;
				}
			}
			
			pNode = node;
		}
		node_num++;
	}
	
	// 노드 제거
	public BtreeNode<T> removeNode(T target){
		
		// 최상위 노드가 null인 경우 제거할 것 없음
		if(rootNode == null) {
			return null;
		}
		
		BtreeNode<T> target_node = rootNode;
		BtreeNode<T> removed = null;
		BtreeNode<T> parent = null;
		while(target_node != null) {
			if(rootNode.data > target) {
				parent = target_node;
				target_node = target_node.left;
			} else if(rootNode.data < target) {
				parent = target_node;
				target_node = target_node.right;
			} else {
				break;
			}
		}
		
		if(target_node == null) return null;
		else {
			// 단말 노드인 경우 단순 삭제
			if(target_node.left == null && target_node.right == null) {
				if(parent.left == target_node) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else {
				
				// 양 쪽 자식이 다 있다면
				if(target_node.left != null && target_node.right != null) {
					BtreeNode<T> minNode = searchMinNode(target_node.right);
					removed = removeNode(minNode.data);
					target_node.data = minNode.data;
					
				} else {
					BtreeNode<T> temp;
					// 자식이 하나인 경우
					if(target_node.left != null) {
						temp = target_node.left;
					} else {
						temp = target_node.right;
					}
					
					if(parent.left == target_node) {
						parent.left = temp;
					} else {
						parent.right = temp;
					}
				
				}
			}
			
		}
		return removed;
	}
	
	// 노드 찾기
	public BtreeNode<T> searchNode(T target) {
		BtreeNode<T> current = rootNode;
		while(current.data != target && current != null) {
			if(current.data > target) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		return current;
	}
	
	// 최소값 노드를 찾아 반환
	public BtreeNode<T> searchMinNode(BtreeNode<T> targetNode){
		if(targetNode == null) return null;
		
		BtreeNode<T> current = targetNode;
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	// 값이 작은 것부터 큰 순서대로 출력
	public void inorderPrintTree(BtreeNode<T> node) {
		if(node == null) {
			return;
		}
		
		inorderPrintTree(node.left);
		
		System.out.print(node.data + ", ");
		
		inorderPrintTree(node.right);
	}
	
	public static void main(String[] args) {
		BinarySearchTreeImpl<Integer> newTree = new BinarySearchTreeImpl<>();
		newTree.insertNode(newTree.createNode(30));
		newTree.insertNode(newTree.createNode(150));
		newTree.insertNode(newTree.createNode(20));
		newTree.insertNode(newTree.createNode(5));
		newTree.insertNode(newTree.createNode(15));
		newTree.insertNode(newTree.createNode(70));
		
		newTree.inorderPrintTree(newTree.rootNode);
		
	}
	
	// 노드의 데이터를 반환
//	public T getData(BtreeNode<T> node) {
//		return node.data;
//	}
}
