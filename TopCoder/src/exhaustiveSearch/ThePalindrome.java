package exhaustiveSearch;

public class ThePalindrome {
	//생성가능한 가장 짧은 회문의 길이를 리턴
	public static int find(String s) {
		int leng = s.length();
		
		//1글자면 그냥 리턴
		if(leng == 1) {
			return 1;
		}
		
		int checked = 0;
		int retVal = 0;
		
		//회문을 체크하고 아니라면 길이를 늘려간다.
		for(int i=0; i < s.length(); i++) {
			if(leng - i - 1 < s.length() && s.charAt(i) != s.charAt(leng - i -1)) {
				leng++;
				i = 0;
			}
		}
		
		return leng;
	}
	
	public static int find2(String s) {
		
		for(int i=s.length(); ; i++) {
			boolean flag = true;
			
			for(int j=0; j < s.length(); j++) {
				if((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			
			if(flag) return i;
		}
	}
}
