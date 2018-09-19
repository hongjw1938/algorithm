package sort_algorithm;

public class SortAlgorithm {
	public static int[] sorted = new int[] { 9, 3, 8, 2, 1, 6, 5, 4, 7, 0 };
	public static void main(String[] args) {
		int[] numbers = new int[] { 9, 3, 8, 2, 1, 6, 5, 4, 7, 0 };
//		selectionSort(numbers);
//		bubbleSort(numbers);
		insertionSort(numbers);
		for(int i=0; i < numbers.length; i++) {
			if(i == 0) System.out.print("[");
			if(i == numbers.length-1) {
				System.out.print(numbers[i] + "]");
				break;
			}
			System.out.print(numbers[i] + ", ");
		}
	}
	
	
	// 선택정렬
	// 시간복잡도 : O(n^2), 공간복잡도 : O(n)
	public static void selectionSort(int[] numbers) {
		int length = numbers.length;
		int min;
		int tmp;
		
		for(int i = 0; i < length - 1; i++) {
			min = i;
			for(int j = i+1; j < length; j++) {
				if(numbers[j] < numbers[min]) {
					min = j;
				}
			}
			tmp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = tmp;
		}
		
//		끝에서부터 정렬시		
//		int max;
//
//		for(int i=length-1; i > 0; i--) {
//			max = i;
//			for(int j=i-1; j >= 0; j--) {
//				if(numbers[j] > numbers[max]) {
//					max = j;
//				}
//			}
//			tmp = numbers[i];
//			numbers[i] = numbers[max];
//			numbers[max] = tmp;
//		}
	}
	
	// 버블정렬
	// 시간복잡도 : O(n^2)
	public static void bubbleSort(int[] input) {
		int tmp;

		for(int i=input.length-1; i >= 0; i--) {
			for(int j=0; j < i; j++ ) {
				if(input[j] > input[j+1]) {
					tmp = input[j];
					input[j] = input[j+1];
					input[j+1] = tmp;
				}
			}
		}
	}
	
	// 삽입정렬
	// 시간복잡도 : O(n^2)
	public static void insertionSort(int[] input) {
		int tmp;
		for(int i=1; i < input.length; i++) {
			tmp = input[i];
			int aux = i-1;
			
			while(aux >= 0 && tmp < input[aux]) {
				input[aux + 1] = input[aux];
				
				aux--;
			}
			input[aux+1] = tmp;
		}
	}
	
	// 병합정렬
	// 시간복잡도 : O(nlogn)
	public static void mergeSort(int[] input, int m, int n) {
		int middle;
		
		if(m < n) {
			middle = (m + n) / 2;
			mergeSort(input, m, middle);
			mergeSort(input, middle+1, n);
			merge(input, m, middle, n);
		}
	}
	
	public static void merge(int[] input, int m, int middle, int n) {
		int i, j, k, t;
		
		i = m;
		j = middle + 1;
		k = m;
		
		while(i <= middle && j <= n) {
			if(input[i] <= input[j])
				sorted[k] = input[i++];
			else
				sorted[k] = input[j++];
			k++;
		}
		
		for(t = m; t <= n; t++) {
			input[t] = sorted[t];
		}
	}

}
