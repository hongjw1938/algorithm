package data_structure;

// 값이 작은 경우 우선순위가 높다고 가정
public class HeapImpl<T extends Integer> {
	
	private int data_num;
	private T arr[];
	
	HeapImpl(){
		arr = (T[]) new Object[100];
	}
	
	HeapImpl(int num) {
		arr = (T[]) new Object[num];
	}
	
	// 힙이 비어있는지 확인하는 메소드
	public boolean isEmpty() {
		return data_num == 0;
	}
	
	
	// 힙에 입력된 데이터의 개수를 파악하는 메소드
	public int sizeOf() {
		return data_num;
	}
	
	// 부모 노드의 인덱스를 반환하는 메소드
	public int getParentIdx(int idx) {
		return idx/2;
	}
	
	// 왼쪽 자식 노드의 인덱스를 반환하는 메소드
	public int getLChildIdx(int idx) {
		return idx * 2;
	}
	
	// 오른쪽 자식 노드의 인덱스를 반환하는 메소드
	public int getRChildIdx(int idx) {
		return idx * 2 + 1;
	}
	
	// 두 개의 자식 노드 중 우선순위가 높은 노드의 인덱스 값 반환
	public int getHigherPriChildIdx(int idx) {
		
		// 만약 자식 노드가 존재하지 않는다면 0을 반환
		if(getLChildIdx(idx) > data_num) {
			return 0;
		// 만약 자식노드가 왼쪽 자식 노드 하나 뿐이라면,
		} else if(getLChildIdx(idx) == data_num) {
			return getLChildIdx(idx);
		// 자식노드가 둘 다 존재한다면
		} else {
			if(arr[getLChildIdx(idx)] > arr[getRChildIdx(idx)]) {
				return idx * 2 + 1;
			} else {
				return idx * 2;
			}
		}
	}
	
	public void add(T data) {
		int idx = data_num + 1;
		
		while(idx != 1) {
			if(data < arr[getParentIdx(idx)]) {
				arr[idx] = arr[getParentIdx(idx)];
				idx = getParentIdx(idx);
			} else {
				break;
			}
		}
		arr[idx] = data;
		data_num++;
	}
	
	public T remove() {
		T retData = arr[1];
		T lastNode = arr[data_num];
		
		int parentIdx = 1;
		int childIdx;
		
		while(true) {
			childIdx = getHigherPriChildIdx(parentIdx);
			if(lastNode <= arr[childIdx]) {
				break;
			}
			arr[parentIdx] = arr[childIdx];
			parentIdx = childIdx;
		}
		
		arr[parentIdx] = lastNode;
		data_num--;
		return retData;
	}
}
