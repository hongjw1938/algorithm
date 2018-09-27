package data_structure;

// ���� ���� ��� �켱������ ���ٰ� ����
public class HeapImpl<T extends Integer> {
	
	private int data_num;
	private T arr[];
	
	HeapImpl(){
		arr = (T[]) new Object[100];
	}
	
	HeapImpl(int num) {
		arr = (T[]) new Object[num];
	}
	
	// ���� ����ִ��� Ȯ���ϴ� �޼ҵ�
	public boolean isEmpty() {
		return data_num == 0;
	}
	
	
	// ���� �Էµ� �������� ������ �ľ��ϴ� �޼ҵ�
	public int sizeOf() {
		return data_num;
	}
	
	// �θ� ����� �ε����� ��ȯ�ϴ� �޼ҵ�
	public int getParentIdx(int idx) {
		return idx/2;
	}
	
	// ���� �ڽ� ����� �ε����� ��ȯ�ϴ� �޼ҵ�
	public int getLChildIdx(int idx) {
		return idx * 2;
	}
	
	// ������ �ڽ� ����� �ε����� ��ȯ�ϴ� �޼ҵ�
	public int getRChildIdx(int idx) {
		return idx * 2 + 1;
	}
	
	// �� ���� �ڽ� ��� �� �켱������ ���� ����� �ε��� �� ��ȯ
	public int getHigherPriChildIdx(int idx) {
		
		// ���� �ڽ� ��尡 �������� �ʴ´ٸ� 0�� ��ȯ
		if(getLChildIdx(idx) > data_num) {
			return 0;
		// ���� �ڽĳ�尡 ���� �ڽ� ��� �ϳ� ���̶��,
		} else if(getLChildIdx(idx) == data_num) {
			return getLChildIdx(idx);
		// �ڽĳ�尡 �� �� �����Ѵٸ�
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
