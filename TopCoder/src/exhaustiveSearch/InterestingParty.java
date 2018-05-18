package exhaustiveSearch;

import java.util.*;

public class InterestingParty {
	public static int bestInvitation(String[] first, String[] second) {
		int common = 0;
		int retVal = 0;
		
		for(int i=0; i < first.length; i++) {
			String firstH = first[i];
			String secondH = second[i];
			for(int j=0; j < first.length; j++) {
				if(i==j) {
					common++;
				} else {
					if(first[j].equals(firstH)) common++;
					if(second[j].equals(secondH)) common++;
					if(first[j].equals(secondH)) common++;
					if(second[j].equals(firstH)) common++;
				}
			}
			retVal = Math.max(retVal, common);
			common = 0;
			
		}
		
		return retVal;
	}
	
	public static int bestInvitation2(String[] first, String[] second) {
		HashMap<String, Integer> dic = new HashMap();
		for(int i=0; i < first.length; i++) {
			dic.put(first[i], 0);
			dic.put(second[i], 0);
		}
		
		for(int j=0; j < first.length; j++) {
			dic.put(first[j], dic.get(first[j])+1);
			dic.put(second[j], dic.get(second[j])+1);
		}
		
		int ans = 0;
		for(String key : dic.keySet()) {
			ans = Math.max(ans, dic.get(key));
		}
		return ans;
	}
	public static int bestInvitation3(String[] first, String[] second) {
		int start = 0;
		int retVal = 0;
		int common = 0;
		
		for(int i=0; i < first.length; i++) {
			if(first[i].equals(first[start])) common++;
			if(first[i].equals(second[start])) common++;
			if(second[i].equals(first[start])) common++;
			if(second[i].equals(second[start])) common++;
			
			if(i == first.length-1 && start != first.length-1) {
				retVal = Math.max(retVal, common);
				
				i = 0;
				common = 0;
				start++;
			}
		}
		
		return retVal-1;
	}
}
