package sort_algorithm;

public class SortAlgorithm {

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
	
	
	// ��������
	// �ð����⵵ : O(n^2), �������⵵ : O(n)
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
		
//		���������� ���Ľ�		
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
	
	// ��������
	// �ð����⵵ : O(n^2)
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
	
	// ��������
	// �ð����⵵ : O(n^2)
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

}
