package exhaustiveSearch;

public class CorporationSalary {
	
	long[] sals;
	
	public static void main(String[] args) {
		String[] relations = {"NNYN", "NNYN", "NNNN", "NYYN"};
		String[] relations2 = {
				"NNNNNN",
				"YNYNNY",
				"YNNNNY",
				"NNNNNN",
				"YNYNNN",
				"YNNYNN"
		};
		CorporationSalary sal = new CorporationSalary();
		System.out.println(sal.totalSalary(relations2));
	}
	
	//급여의 합계를 구하는 메소드
	//깊이 우선 탐색으로 진행하는 경우
	public long totalSalary(String[] relations) {
		
		sals = new long[relations.length]; 
		
		getSalary(0, relations);
		
		long hap = 0;
		for(int i=0; i < sals.length; i++) {
			System.out.println("sals[" + i + "] = " + sals[i] );
			hap += sals[i];
		}
		
		return hap;
	}
	
	public void getSalary(int i, String[] relations) {
		System.out.println("i = " + i);
		if(i >= relations.length) return;
		if(sals[i] != 0) return;
		
		
		int count = 0;
		for(int j=0; j < relations[i].length(); j++) {
			
			
			if(relations[i].charAt(j) == 'Y') {
				getSalary(j, relations);
				sals[i] += sals[j];
			} else {
				count++;
			}
			
			if(count == relations.length && i != 0) {
				sals[i] = 1L;
				return;
			} else if(count == relations.length && i == 0) {
				sals[i] = 1L;
				break;
			}
			
		}
		
		while(i < relations.length) {
			i++;
			getSalary(i, relations);
		}
		
		
	}

}
