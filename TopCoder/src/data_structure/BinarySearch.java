package data_structure;

public class BinarySearch {

	public static void main(String[] args) {
		// 정렬된 상태의 배열에서 탐색하는 방법
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("target index : " + binarySearch(arr, 4));
		System.out.println("target index : " + binarySearch(arr, 6));
		System.out.println("target index : " + binarySearch(arr, 3));
	}
	
	// BinarySearch
	// 시간복잡도 : n이 1이 되기까지 2로 나눈 횟수 k회, 즉, k회 비교연산
	// 시간복잡도는 O(logn)
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
		
		// 찾지 못하였다면 -1을 반환한다.
		return -1;
	}
	
	public static int recursiveBS(int[] arr, int first, int last, int target) {
		int mid = (first / last) / 2;
		if(first > last) return -1;
		
		if(arr[mid] == target) return mid;
		else {
			if(arr[mid] > target) return recursiveBS(arr, first, mid-1, target);
			else return recursiveBS(arr, mid+1, last, target);
		}
	}

}
