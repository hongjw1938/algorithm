package exhaustiveSearch;

public class NumberMagicEasy {
	
	//main method to execute
	public static void main(String[] args) {
		NumberMagicEasy ans = new NumberMagicEasy();
		long startTime = System.currentTimeMillis();
		System.out.println(ans.theNumber("YNYY"));
		System.out.println(ans.theNumber("YNNN"));
		System.out.println(ans.theNumber("NNNN"));
		System.out.println(ans.theNumber("YYYY"));
		System.out.println(ans.theNumber("NYNY"));
		
		System.out.println("This took about : " + (System.currentTimeMillis() - startTime));
	}
	
	
	//method to get the answer
	public int theNumber(String answer) {
		//생각한 방법 : 16이하의 양의 정수이므로 해당 값들을 배열에 우선 저장
		//int 배열을 만들고 answer가 true면 해당 인덱스의 값을 1씩 더한다.
		//없다고 한다면 일부러 매우 작은 수를 넣어준다. 마지막에 반환할 값은 max값을 찾아 반환.
		
		int[][] cards = {
				{1, 2, 3, 4, 5, 6, 7, 8},
				{1, 2, 3, 4, 9, 10, 11, 12},
				{1, 2, 5, 6, 9, 10, 13, 14},
				{1, 3, 5, 7, 9, 11, 13, 15}
		};
		
		
		//1~16의 숫자를 카운트
		int[] count = new int[16];
		
		
		
		//answer의 값을 다 탐색하기 위해 for문 작성
		for(int i=0; i < answer.length(); i++) {
			for(int j=0; j < cards[i].length; j++) {
				if(answer.charAt(i) == 'Y') {
					count[cards[i][j]-1] += 1;
				} else {
					count[cards[i][j]-1] = -1;
				}
			}
		}
		
		int maxVal = count[0];
		//리턴할 값
		int retVal = 1;
		
		for(int i=0; i < count.length; i++) {
			if(maxVal < count[i]) {
				maxVal = count[i];   
				retVal = i+1;
			}
		}
		
		return retVal;
	}
}
