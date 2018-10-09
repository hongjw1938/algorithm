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
	
	// red-black tree ��ȸ�� ����
	public void rotateRight(Node<Integer> parent) {
		// ���� �θ� ����� ���� �ڽ� ��带 ����
		Node<Integer> leftChild = parent.left;
		
		// ���� �ڽ� ����� ���� �ڽĳ�带 ���� �θ� ����� ���� �ڽ� ���� ����
		parent.left = leftChild.right;
		
		// ���� ���� �ڽ� ����� ���� �ڽĳ�尡 null�� �ƴ϶��
		if(leftChild.right != null) {
			// �ش� ����� �θ� ���� �θ� ���� ����
			leftChild.right.parent = parent;
		}
		
		// ���� �θ����� �θ� �ٷ� ���� �ڽ� ����� �θ� �ȴ�.
		leftChild.parent = parent.parent;
		
		// ���� ���� �θ��尡 root �����, ���� �ڽĳ�尡 �θ��尡 �ȴ�.
		if(parent.parent == null) {
			root = leftChild;
		} else {
			// ���� ���� �θ� ����� �θ� �����Ѵٸ�, ��, parent�� root�� �ƴ϶��
			// �ش� �θ����� �ڽ����ν� ���� �ڽĳ�带 �����ؾ� �Ѵ�.
			// �� ��, ���� �θ� ��尡 �ڽ��� �θ����� ���� �ڽ�����, ���� �ڽ������� ���� �б��Ѵ�.
			if(parent == parent.parent.left) {
				parent.parent.left = leftChild;
			} else {
				parent.parent.right = leftChild;
			}
		}
		
		// ����������, ���� �ڽĳ���� ���� �ڽ��� ������ �θ��尡 �ǵ��� �����ϰ� ���� �θ����� �θ��尡 ���� �ڽĳ�尡 �ǵ��� �Ѵ�.
		leftChild.right = parent;
		parent.parent = leftChild;
		
	}
	
	// ��ȸ���ϴ� ����� ����
	public void rotateLeft(Node<Integer> parent) {
		// ���� �θ����� ������带 �����Ѵ�.
		Node<Integer> rightChild = parent.right;
		
		// �ش� ���� ����� ���� �ڽĳ�带 �θ����� �������� �����Ѵ�.
		parent.right = rightChild.left;
		
		// ���� �θ����� �θ��带 ���� �ڽĳ���� �θ���� �����Ѵ�.
		rightChild.parent = parent.parent;
		
		// ���� �ش� �θ��尡 null�̸� parent�� root������� �ǹ��Ѵ�.
		if(parent.parent == null) {
			root = rightChild;
		} else {
			// ���� parent�� �ֻ��� ��尡 �ƴϾ��ٸ� �ش� �θ����� �� Ȥ�� �����ڽ����� rightChild�� �����ؾ� �Ѵ�.
			if(parent == parent.parent.left) {
				parent.parent.left = rightChild;
			} else {
				parent.parent.right = rightChild;
			}
		}
		
		// ���������� ���� �θ� ���� ���� �ڽĳ�带 ��ȣ �������ش�.
		rightChild.right = parent;
		parent.parent = rightChild;
	}
	
	// ��� ����
	public void insertNode(int data) {
		Node<Integer> newNode = new Node<>(data);
		newNode.color = Color.RED;
		insertHelper(root, newNode);
		
		rebuildAfterInsert(newNode);
	}
	
	// ������ �����ϴ� �޼ҵ�
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
	
	// ������ ��Ģ�� �����·� �ϱ� ���� ������ �޼ҵ�
	public void rebuildAfterInsert(Node<Integer> node) {
		
		// ���� ���Ե� ��尡 �ֻ��� ��尡 �ƴϰ� ������ ���������� �����Ǵ� ����
		while(node != root && node.parent.color == Color.RED) {
			// �θ��尡 �Ҿƹ��� ����� ���� �ڽ��� ��쿡
			if(node.parent == node.parent.parent.left) {
				// ���� ��带 ����
				Node<Integer> uncle = node.parent.parent.right;
				
				// ���� ���� ��嵵 �������̶��
				if(uncle.color == Color.RED) {
					// �θ� ����� ���� ����������
					node.parent.color = Color.BLACK;
					
					// ���� ��嵵 ����������
					uncle.color = Color.BLACK;
					
					// �Ҿƹ����� ����������
					node.parent.parent.color = Color.RED;
					
					// ���� �� �Ҿƹ����� �������� ��Ģ ���ݿ� ���� �˻縦 �ٽ� �����ؾ� �ϹǷ� �Ҿƹ��� ��带 ����
					node = node.parent.parent;
				} else {
					// ���� ���� �������̶��
					// ���� ���� ��尡 ���� �ڽ��̶��
					if(node == node.parent.right) {
						node = node.parent;
						// �ش� �θ� ��带 �������� ��ȸ��
						rotateLeft(node);
						
						// �̷� ���� �θ� �ڽ��� �ٲ�鼭 ���� �ڽĳ��� �θ� ��尡 �������� �Ǿ���.
					}
					
					// �θ����� ���� ����������, �Ҿƹ����� ����������
					node.parent.color = Color.BLACK;
					node.parent.parent.color = Color.RED;
					
					// �Ҿƹ����� ��带 �������� ��ȸ��
					rotateRight(node.parent.parent);
				}
			// �θ� ��尡 �Ҿƹ��� ����� ���� �ڽ��� ��쿡
			} else {
				// ���� ��带 �����Ѵ�.
				Node<Integer> uncle = node.parent.parent.left;
				
				// ���� ���� ��尡 ������ �̶��
				if(uncle.color == Color.RED) {
					// �θ� ���� ���� ����� ���� BLACK���� �����ϰ� �Ҿƹ��� ��带 ���������� �����Ѵ�.
					uncle.color = Color.BLACK;
					node.parent.color = Color.BLACK;
					node.parent.parent.color = Color.RED;
					
					// ���� �Ҿƹ��� ��带 �������� ��Ģ ���� ���θ� Ȯ���Ѵ�.
					node = node.parent.parent;
				// ���� ���� ���� ������ �̶��
				} else {
					// ���� ���� �߰��� ��尡 �θ� ����� ���� �ڽ��̶��
					if(node.parent.left == node) {
						// �θ� ��带 �������� ��ȸ��
						node = node.parent;
						rotateRight(node);
						
					// ���� �ڽ� ��忴�ٸ�
					} else {
						// �θ� ����� ������ ���������� �����ϰ� �Ҿƹ��� ����� ������ ���������� �����Ѵ�.
						node.parent.color = Color.BLACK;
						node.parent.parent.color = Color.RED;
						
						// �Ҿƹ��� ��带 �������� ��ȸ�� �Ѵ�.
						rotateLeft(node.parent.parent);
					}
				}
			}
		}
		
		// ���� ��Ʈ ������ �� ��쿡��, ��Ʈ ����� ������ �ٽ� ���������� �����ؾ� �Ѵ�.
		root.color = Color.BLACK;
	}
	
	// �����ϰ� ���� �������ϱ� ���� �޼ҵ�
	public void rebuildAfterRemove(Node<Integer> node) {
		Node<Integer> sibling = null;
		
		// �ش� ����� �θ��尡 �ֻ��� ����̰ų� �ش� ����� ���� �������� �ƴ� ��� ����ؼ� ������.
		while(node.parent != null && node.color == Color.BLACK) {
			
			// ��尡 ���� �ڽ��� �����
			if(node == node.parent.left) {
				sibling = node.parent.right;
				
				// ���� ��尡 �������̶��
				if(sibling.color == Color.RED) {
					
					// ���� ���� ����������, �θ� ���� ���������� ĥ�Ѵ�.
					sibling.color = Color.BLACK;
					node.parent.color = Color.RED;
					
					rotateLeft(node.parent);
				
				// ���� ��尡 �������̸�
				} else {
					
					// ���� ������ �� �� �ڽ��� ��� �������̶��
					if(sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
						sibling.color = Color.RED;
						
						// �θ� ��带 �������� ��Ģ ���� ���� Ȯ��
						node = node.parent;
					} else {
						// ���� �ڽ��� �������ΰ��
						if(sibling.left.color == Color.RED) {
							sibling.left.color = Color.BLACK;
							sibling.color = Color.RED;
							
							rotateRight(sibling);
							sibling = node.parent.right;
						// ���� �ڽ��� �������ΰ��
						} else {
							sibling.color = node.parent.color;
							node.parent.color = Color.BLACK;
							sibling.right.color = Color.BLACK;
							
							rotateLeft(node.parent);
							node = root;
						}
					}
				}
				
			// ��尡 ���� �ڽ��� ���
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
	
	
	// ��带 ã�� �޼ҵ�
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
	
	// �ֿ켱������ ���� ��带 ��ȯ�ϴ� �޼ҵ�
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
