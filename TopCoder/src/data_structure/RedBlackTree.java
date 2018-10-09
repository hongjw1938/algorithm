package data_structure;

enum Color {
	BLACK(0), RED(1);
	
	final private int color;
	private Color (int num) {
		this.color = num;
	}
}

public class RedBlackTree<Integer> {
	class Node<Integer>{
		Node<Integer> parent;
		Node<Integer> left;
		Node<Integer> right;
		
		int data;
		
		Color color;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node<Integer> root = null;
	private int node_num = 0;
	
	// red-black tree 우회전 구현
	public void rotateRight(Node<Integer> parent) {
		// 현재 부모 노드의 좌측 자식 노드를 저장
		Node<Integer> leftChild = parent.left;
		
		// 좌측 자식 노드의 우측 자식노드를 현재 부모 노드의 좌측 자식 노드로 지정
		parent.left = leftChild.right;
		
		// 만약 좌측 자식 노드의 우측 자식노드가 null이 아니라면
		if(leftChild.right != null) {
			// 해당 노드의 부모를 현재 부모 노드로 변경
			leftChild.right.parent = parent;
		}
		
		// 현재 부모노드의 부모가 바로 좌측 자식 노드의 부모가 된다.
		leftChild.parent = parent.parent;
		
		// 만약 현재 부모노드가 root 노드라면, 좌측 자식노드가 부모노드가 된다.
		if(parent.parent == null) {
			root = leftChild;
		} else {
			// 만약 현재 부모 노드의 부모가 존재한다면, 즉, parent가 root가 아니라면
			// 해당 부모노드의 자식으로써 좌측 자식노드를 지정해야 한다.
			// 이 때, 현재 부모 노드가 자신의 부모노드의 좌측 자식인지, 우측 자식인지에 따라 분기한다.
			if(parent == parent.parent.left) {
				parent.parent.left = leftChild;
			} else {
				parent.parent.right = leftChild;
			}
		}
		
		// 마지막으로, 좌측 자식노드의 우측 자식이 현재의 부모노드가 되도록 지정하고 현재 부모노드의 부모노드가 좌측 자식노드가 되도록 한다.
		leftChild.right = parent;
		parent.parent = leftChild;
		
	}
	
	// 좌회전하는 경우의 구현
	public void rotateLeft(Node<Integer> parent) {
		// 현재 부모노드의 우측노드를 저장한다.
		Node<Integer> rightChild = parent.right;
		
		// 해당 우측 노드의 좌측 자식노드를 부모노드의 우측노드로 지정한다.
		parent.right = rightChild.left;
		
		// 현재 부모노드의 부모노드를 우측 자식노드의 부모노드로 지정한다.
		rightChild.parent = parent.parent;
		
		// 만약 해당 부모노드가 null이면 parent가 root노드임을 의미한다.
		if(parent.parent == null) {
			root = rightChild;
		} else {
			// 만약 parent가 최상위 노드가 아니었다면 해당 부모노드의 좌 혹은 우측자식으로 rightChild를 지정해야 한다.
			if(parent == parent.parent.left) {
				parent.parent.left = rightChild;
			} else {
				parent.parent.right = rightChild;
			}
		}
		
		// 마지막으로 현재 부모 노드와 우측 자식노드를 상호 변경해준다.
		rightChild.right = parent;
		parent.parent = rightChild;
	}
	
	// 노드 삽입
	public void insertNode(int data) {
		Node<Integer> newNode = new Node<>(data);
		newNode.color = Color.RED;
		insertHelper(root, newNode);
		
		rebuildAfterInsert(newNode);
	}
	
	// 실제로 삽입하는 메소드
	public void insertHelper(Node<Integer> tree, Node<Integer> node) {
		if(tree == null) {
			tree = node;
			node_num++;
			return;
		}
		
		if(tree.data < node.data) {
			if(tree.right == null) {
				tree.right = node;
				node.parent = tree;
				node_num++;
			} else {
				insertHelper(tree.right, node);
			}
		} else if(tree.data > node.data) {
			if(tree.left == null) {
				tree.left = node;
				node.parent = tree;
				node_num++;
			} else {
				insertHelper(tree.left, node);
			}
		}
		
	}
	
	// 무너진 규칙을 원상태로 하기 위한 리빌딩 메소드
	public void rebuildAfterInsert(Node<Integer> node) {
		
		// 새로 삽입된 노드가 최상위 노드가 아니고 색상이 빨간색으로 유지되는 동안
		while(node != root && node.parent.color == Color.RED) {
			// 부모노드가 할아버지 노드의 좌측 자식인 경우에
			if(node.parent == node.parent.parent.left) {
				// 삼촌 노드를 저장
				Node<Integer> uncle = node.parent.parent.right;
				
				// 만약 삼촌 노드도 빨간색이라면
				if(uncle.color == Color.RED) {
					// 부모 노드의 색을 검은색으로
					node.parent.color = Color.BLACK;
					
					// 삼촌 노드도 검은색으로
					uncle.color = Color.BLACK;
					
					// 할아버지는 빨간색으로
					node.parent.parent.color = Color.RED;
					
					// 이제 그 할아버지를 기준으로 규칙 위반에 대한 검사를 다시 시작해야 하므로 할아버지 노드를 지정
					node = node.parent.parent;
				} else {
					// 삼촌 노드는 검은색이라면
					// 새로 넣은 노드가 우측 자식이라면
					if(node == node.parent.right) {
						node = node.parent;
						// 해당 부모 노드를 기준으로 좌회전
						rotateLeft(node);
						
						// 이로 인해 부모 자식이 바뀌면서 좌측 자식노드와 부모 노드가 빨간색이 되었다.
					}
					
					// 부모노드의 색은 검은새으로, 할아버지는 빨간색으로
					node.parent.color = Color.BLACK;
					node.parent.parent.color = Color.RED;
					
					// 할아버지의 노드를 기준으로 우회전
					rotateRight(node.parent.parent);
				}
			// 부모 노드가 할아버지 노드의 우측 자식인 경우에
			} else {
				// 삼촌 노드를 저장한다.
				Node<Integer> uncle = node.parent.parent.left;
				
				// 만약 삼촌 노드가 빨간색 이라면
				if(uncle.color == Color.RED) {
					// 부모 노드와 삼촌 노드의 색을 BLACK으로 변경하고 할아버지 노드를 빨간색으로 지정한다.
					uncle.color = Color.BLACK;
					node.parent.color = Color.BLACK;
					node.parent.parent.color = Color.RED;
					
					// 이제 할아버지 노드를 기준으로 규칙 위반 여부를 확인한다.
					node = node.parent.parent;
				// 만약 삼촌 노드는 검은색 이라면
				} else {
					// 만약 새로 추가된 노드가 부모 노드의 좌측 자식이라면
					if(node.parent.left == node) {
						// 부모 노드를 기준으로 우회전
						node = node.parent;
						rotateRight(node);
						
					// 우측 자식 노드였다면
					} else {
						// 부모 노드의 색상은 검은색으로 지정하고 할아버지 노드의 색상은 빨간색으로 지정한다.
						node.parent.color = Color.BLACK;
						node.parent.parent.color = Color.RED;
						
						// 할아버지 노드를 기준으로 좌회전 한다.
						rotateLeft(node.parent.parent);
					}
				}
			}
		}
		
		// 만약 루트 노드까지 간 경우에는, 루트 노드의 색상을 다시 검은색으로 지정해야 한다.
		root.color = Color.BLACK;
	}
	
	// 삭제하고 나서 리빌딩하기 위한 메소드
	public void rebuildAfterRemove(Node<Integer> node) {
		Node<Integer> sibling = null;
		
		// 해당 노드의 부모노드가 최상위 노드이거나 해당 노드의 색이 검은색이 아닌 경우 계속해서 진행함.
		while(node.parent != null && node.color == Color.BLACK) {
			
			// 노드가 좌측 자식인 경우라면
			if(node == node.parent.left) {
				sibling = node.parent.right;
				
				// 형제 노드가 빨간색이라면
				if(sibling.color == Color.RED) {
					
					// 형제 노드는 검은색으로, 부모 노드는 빨간색으로 칠한다.
					sibling.color = Color.BLACK;
					node.parent.color = Color.RED;
					
					rotateLeft(node.parent);
				
				// 형제 노드가 검은색이면
				} else {
					
					// 만약 형제의 양 쪽 자식이 모두 검은색이라면
					if(sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
						sibling.color = Color.RED;
						
						// 부모 노드를 기준으로 규칙 위반 여부 확인
						node = node.parent;
					} else {
						// 좌측 자식이 빨간색인경우
						if(sibling.left.color == Color.RED) {
							sibling.left.color = Color.BLACK;
							sibling.color = Color.RED;
							
							rotateRight(sibling);
							sibling = node.parent.right;
						// 우측 자식이 빨간색인경우
						} else {
							sibling.color = node.parent.color;
							node.parent.color = Color.BLACK;
							sibling.right.color = Color.BLACK;
							
							rotateLeft(node.parent);
							node = root;
						}
					}
				}
				
			// 노드가 우측 자식인 경우
			} else {
				sibling = node.parent.right;
				
				if(sibling.color == Color.RED) {
					sibling.color = Color.BLACK;
					node.parent.color = Color.RED;
					rotateRight(node.parent);
				} else {
					if(sibling.right.color == Color.BLACK && sibling.left.color == Color.BLACK) {
						sibling.color = Color.RED;
						node = node.parent;
					} else {
						if(sibling.right.color == Color.RED) {
							sibling.right.color = Color.BLACK;
							sibling.color = Color.RED;
							
							rotateLeft(sibling);
							sibling = node.parent.left;
						}
						
						sibling.color = node.parent.color;
						node.parent.color = Color.BLACK;
						sibling.left.color = Color.BLACK;
						
						rotateRight(node.parent);
						node = root;
					}
				}
			}
		}
		
		node.color = Color.BLACK;
	}
	
	
	// 노드를 찾는 메소드
	public Node<Integer> searchNode(int target){
		if(root == null) {
			return null;
		}
		
		Node<Integer> currentNode = root;
		
		while(currentNode.data != target) {
			if(currentNode.data > target) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		return currentNode;
	}
	
	// 최우선순위를 갖는 노드를 반환하는 메소드
	public Node<Integer> searchFirstPriorityNode(){
		if(root == null) {
			return null;
		}
		
		Node<Integer> currentNode = root;
		
		while(currentNode.left != null) {
			currentNode = currentNode.left;
		}
		
		return currentNode;
	}
	
	public static void main(String[] args) {
		

	}

}
