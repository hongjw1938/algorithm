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
	
	//�޿��� �հ踦 ���ϴ� �޼ҵ�
	//���� �켱 Ž������ �����ϴ� ���
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
	
	//�ٸ� �ڵ� �ؼ�
	public long totalS(String[] relations) {
		sals = new long[relations.length];
		
		
		//��ȯ�ϱ� ���� ������
		long total = 0;
		
		for(int i=0; i < relations.length; i++) {
			total += getSal(i, relations);
		}
		
		return total;
	}
	
	private long getSal(int i, String[] relations) {
		
		//�ʱ�ȭ�� ���¶��
		if(sals[i] == 0) {
			//�ش� ����� ����
			long sal = 0;
			
			//�ش� ����� ���赵
			String relation = relations[i];
			
			for(int j=0; j < relations.length; j++) {
				
				//�� ���踦 �����Ͽ� �ش� ���谡 Y�� ���
				if(relation.charAt(i) == 'Y') {
					//���ȣ���ϰ� NNNN���� ã�� �ش� ������ ���Ϲ޾� ��� ����
					sal += getSal(j, relations);
				}
			}
			
			//���ȣ��� �Ѿ�� ���� ��� NNNN�� ���� ��� N�̹Ƿ� ���� �Ʒ� ����. ������ 1
			if(sal == 0) sal = 1;
				
			sals[i] = sal;
		}
		return sals[i];
	}

}
