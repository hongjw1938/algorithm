package exhaustiveSearch;

import java.util.*;

public class InterestingDigits {
	public static int[] digits(int base) {
		
		List<Integer> retVal = new ArrayList<>();
		
		for(int i=2; i < base; i++) {
			retVal.add(i);
		}
		//System.out.println(retVal);
		
		int checkNum;
		//1~999까지 각 숫자를 진법을 고려하여 푼다., 2이상 base미만의 배수
		for(int i=2; i < base; i++) {
			
			//i에 해당하는 배수만 고려
			for(int j=0; j < 1000; j += i) {
				int k = j;
				checkNum = 0;
				
				while(k / base >= base) {
					checkNum += k % base;
					k = k / base;
				}
				//마지막 몫도 더해줌
				checkNum += k;
				
				if(checkNum % i != 0) {
					//System.out.println(i);
					//System.out.println(retVal.indexOf(i));
					retVal.remove(retVal.indexOf(i));
					break;
				}
			}
		}
		
		int[] ret = new int[retVal.size()];
		for(int i=0; i < retVal.size(); i++) {
			ret[i] = retVal.get(i);
		}
		return ret;		
	}
	
	//위 방식은 각 진법에 대해 1~999까지 모두 체크해야 하므로 시간이 오래 걸린다.
	//따라서 시간을 조금 줄이는 방식의 코드를 작성해 본다.
	public static int[] digits2(int base) {
		List<Integer> times = new ArrayList<>();
		
		//배수는 2부터 시작한다. 진법은 3~30진법
		for(int n=2; n < base; n++) {
			boolean ok = true;
			for(int k1 = 0; k1 < base; k1++) {
				for(int k2 = 0; k2 < base; k2++) {
					for(int k3 = 0; k3 < base; k3++) {
						if((k1 + k2*base + k3*base*base) % n == 0 && (k1 + k2 +k3) % n != 0){
							ok = false;
							break;
						}
					}
					if(!ok) break;
				}
				if(!ok) break;
			}
			if(ok) {
				times.add(n);
			}
		}
		
		int[] ans = new int[times.size()];
		for(int i=0; i < times.size(); i++) ans[i] = times.get(i);
		
		return ans;
	}
	
	
	//수학적 풀이 방법
	public static int[] digits3(int base) {
		/* 
		 * a * n^2 + b * n + c
		 * = a * (n-1)^2 + (b-2a) * (n-1) + (a+b+c)
		 * = ((a * (n-1) + b-2a) * (n-1)) + (a+b+c)
		 * 즉, a+b+c가 n-1의 배수이면 된다.
		 * 
		 * 즉, a+b+c가 어떤 값으로 주어지더라도 n-1이 base미만의 값들의 배수인 경우만 해당
		 * */
		Vector<Integer> v = new Vector<>();
		
		for(int i=2; i < base; i++) {
			if(((base-1) % i) == 0) v.add(i); 
		}
		
		int[] ans = new int[v.size()];
		for(int i=0; i < v.size(); i++) ans[i] = v.get(i);
		
		return ans;
		
	}
}
