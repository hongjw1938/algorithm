package exhaustiveSearch;

import java.util.*;

public class Cryptography {
	public static long encrypt(int[] numbers){
		
		int i=0;
		Long maxVal = 0L;
		Long times;
		
		times = (numbers[i]+1L); 
		for(int j=0; j < numbers.length; j++) {
			if(i==j) {
				continue;
			}
			times *= numbers[j];
			
			if(j == numbers.length-1 && i != numbers.length-1) {
				j = 0;
				i++;
				maxVal = Math.max(maxVal, times);
				times = numbers[i] + 1L;
			}
		}
		return maxVal;
	}
	
	public static long encrypt2(int[] numbers) {
		HashMap<Integer, Integer> number = new HashMap();
		
		int i = 0;
		
		//각 수치를 index기반 dictionary에 넣는다.
		for(int num : numbers) {
			number.put(i++, num);
		}
		
		int minNum = number.get(0);
		int index = 0;
		
		//가장 작은 숫자의 index를 찾는다.
		for(int num : number.keySet()) {
			minNum = Math.min(number.get(num), minNum);
			if(number.get(num) == minNum) {
				index = num;
			} else {
				continue;
			}
			
		}
		
		Long maxNum = 1L;
		//그 작은 숫자에 1을 더한 후 전체를 곱합
		for(int num : number.keySet()) {
			
			if(num == index) {
				maxNum *= number.get(num) + 1L;
			} else {
				maxNum *= number.get(num);
			}
			
		}
	
		return maxNum;
	}
	
	
	//encrypt2의 코드를 줄여보자.
	public static long encrypt3(int[] numbers) {
		
		long maxNum = 1;
		
		//정렬해서 가장 작은 수치 구하기
		Arrays.sort(numbers);
		numbers[0]++;
		
		for(int i=0; i < numbers.length; i++) {
			maxNum *= numbers[i];
		}
		
		return maxNum;
	}
}
