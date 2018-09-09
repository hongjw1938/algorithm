package data_structure;

public class LinkedList {
	
	// 첫 번째 노드에 대한 정보, 마지막 노드에 대한 정보, 몇 개의 노드인지 size
	private Node head;
	private Node tail;
	private int size = 0;
	
	// 노드 객체 class
	private class Node{
		
		// 각각의 노드가 저장할 변수
		private Object data;
		
		// 다음 노드에 대한 정보
		private Node next;
		
		// 노드 생성시 초기화
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	// 첫 노드로 추가
	public void addFirst(Object input) {
		// 노드 생성
		Node newNode = new Node(input);
		
		// 새로운 노드의 다음 노드로 헤드 지정
		// 현재가 First이므로 이전에 head에 지정되어 있던 노드를 next로 지정한다.
		newNode.next = head;
		
		// 헤드로 새로운 노드를 지정한다.
		head = newNode;
		size++;
		if(head.next == null) {
			// 다음 노드 null이면, 현재 노드가 마지막 노드 
			tail = head;
		}
	}
	
	// 마지막 노드로 추가
	public void addLast(Object input) {
		//노드 생성
		Node newNode = new Node(input);
		
		// 만약 엘리먼트가 없다면
		if(size == 0) {
			addFirst(input);
		} else {
			// 새로 추가했을 때, 기존 노드가 새로 추가한 노드를 가리키도록 해야 한다.
			tail.next = newNode;
			// 현재가 last이므로 tail변경
			tail = newNode;
			size++;
		}
		
	}
	
	// 특정 위치의 노드를 찾아내는 방법
	Node node(int index) {
		// 가장 첫 노드를 저장
		Node x = head;
		
		// index에 전달된 값보다 작은 동안에 next로 node를 이동시킨다. 
		for(int i=0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	
	// 특정 위치에 Node를 추가하는 방법
	public void add(int k, Object input) {
		// 만약 0이면 처음에 추가하니까 addFirst사용
		if(k == 0) {
			addFirst(input);
		} else {
			// 현재 k-1번째에 위치한 노드를 알아내야 한다.
			// 왜냐하면 해당 노드의 next값을 바꾸어주어야 하기 때문.
			Node temp1 = node(k-1);
			
			// k번째 노드
			Node temp2 = temp1.next;
			
			// 새로운 노드
			Node newNode = new Node(input);
			
			// 각각의 next를 변경
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			// 만약 새로운 노드가 마지막에 추가된다면?, 새로운 노드가 바로 tail
			if(newNode.next == null) {
				tail = newNode;
			}
			
		}
	}
	
	// Node를 확인할 수 있다.
	public String toString() {
		if(head == null) {
			return "[]";
		}
		
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		
		str += temp.data;
		
		return str + "]";
	}
	
	// 제일 첫 노드를 제거
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
	}
	
	// 중간 노드 제거
	public Object remove(int k) {
		if(k == 0) {
			return removeFirst();
		} else {
			// 중간의 노드를 삭제시에는, 현재 삭제하고자 하는 Node의 이전 Node를 찾아야 한다.
			Node temp = node(k-1);
			
			// 삭제될 예정인 노드
			Node tobeDeleted = temp.next;
			
			// 삭제할 노드의 이전 노드의 head를 바꿔주어야 한다.
			temp.next = tobeDeleted.next;
			
			Object returnData = tobeDeleted.data;
			
			// 만약 마지막 노드를 제거한다면, 이전노드가 tail이 된다.
			if(tobeDeleted.next == null) {
				tail = temp;
			}
			tobeDeleted = null;
			size--;
			return returnData;
		}
	}
	
	// element의 크기 알아내기
	public int size() {
		return size;
	}
	
	// 마지막 노드 삭제
	public Object removeLast() {
		return remove(size - 1);
	}
	
	// 특정 노드 data 가져오기
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	// 특정 data가 몇 번째 Node에 존재하는지 반환
	public int indexOf(Object data) {
		// head에서 시작
		Node temp = head;
		
		// 반환하기 위한 값 초기화
		int index = 0;
		
		while(temp.data != data) {
			temp = temp.next;
			index++;
			
			// 가장 끝에 도달한 경우
			if(temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	
	// iterator 객체 반환
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	// iterator inner class
	class ListIterator {
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
		}
		
		// next값
		public Object next() {
			// 현재의 next에 저장된 Node 반환
			lastReturned = next;
			
			// 반환하였으니, 다음 위치로 pointer이동
			next = next.next;
			
			nextIndex++;
			
			return lastReturned.data;
		}
		
		// 다음 값이 있는가?
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		// iterator로 중간에 값을 넣는 경우
		public void add(Object input) {
			// 노드 생성
			Node newNode = new Node(input);
			
			// 처음에 추가하는 경우
			if(lastReturned == null) {
				head = newNode;	
			} else {
				// 중간에 추가하는 경우
				// 방금 반환했던 Node의 next를  새로만든 Node로 지정
				lastReturned.next = newNode;	
			}
			
			// 새로운 노드의 다음 노드는 next
			newNode.next = next;
			
			// 마지막에 추가한 경우
			if(next == null) {
				tail = newNode;
			}
			
			// lastReturned를 새로 추가된 노드로 추가.
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		// lastReturned가 가리키는 Node를 삭제하고 싶다.
		public void remove() {
			// next를 한번도 호출하지 않았다면
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			
			// next가 아닌 이전 값을 삭제해야 한다.
			// 그러나 for문을 돌아서 삭제할 것을 찾기 때문에 매우 비효율적..
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
	
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(30);
		numbers.addLast(20);
		
		LinkedList.ListIterator i = numbers.listIterator();
		i.add(5);
	}

}
