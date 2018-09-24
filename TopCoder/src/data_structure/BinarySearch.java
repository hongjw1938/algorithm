package data_structure;

public class BinarySearch {

	public static void main(String[] args) {
		// ���ĵ� ������ �迭���� Ž���ϴ� ���
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("target index : " + binarySearch(arr, 4));
		System.out.println("target index : " + binarySearch(arr, 6));
		System.out.println("target index : " + binarySearch(arr, 3));
	}
	
	public static int binarySearch(int[] arr, int target) {
		int first = 0;
		int last = arr.length - 1;
		int mid;
		
		while(first <= last) {
			mid = (first + last) / 2;
			
			if(arr[mid] == target) {
				return mid;
			} else {
				if(arr[mid] > target) {
					last = mid-1;
				} else {
					first = mid+1;
				}
			}
		}
		
		// ã�� ���Ͽ��ٸ� -1�� ��ȯ�Ѵ�.
		return -1;
	}

}
