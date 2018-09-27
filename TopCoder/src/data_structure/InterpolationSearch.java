package data_structure;

public class InterpolationSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("target index : " + interpolationSearch(arr, 4));
		System.out.println("target index : " + interpolationSearch(arr, 6));
		System.out.println("target index : " + interpolationSearch(arr, 3));
		System.out.println("target index : " + interpolationSearch(arr, 10));
		System.out.println("target index : " + interpolationSearch(arr, -1));
	}
	
	public static int interpolationSearch(int arr[], int target) {
		int first = 0;
		int last = arr.length - 1;
		int mid;
		
		while(first <= last) {
			mid = (int)Math.round((double)(target - arr[first]) / (arr[last] - arr[first]) * (last - first) + first);
			if(mid > last || mid < first) return -1;
			if(arr[mid] == target) return mid;
			else {
				if(arr[mid] > target) last = mid-1;
				else first = mid+1;
			}
		}
		
		return -1;
	}
	
	public static int recursiveBS(int arr[], int first, int last, int target) {
		int mid = (first + last) / 2;
		if(first > last) return -1;
		
		if(arr[mid] == target) return mid;
		else {
			if(arr[mid] > target) return recursiveBS(arr, first, mid-1, target);
			else return recursiveBS(arr, mid+1, last, target);
		}
	}

}
