import java.util.Scanner;

public class Coordinate{
	public static void main(String args[]){
    	Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i=0; i < cases; i++) {
        	int numOfMagneticSubs = scan.nextInt();
        	
        	double[] x_cor = new double[numOfMagneticSubs];
        	double[] mass = new double[numOfMagneticSubs];
        	
        	for(int j=0; j < numOfMagneticSubs; j++) x_cor[j] = scan.nextDouble();
        	for(int j=0; j < numOfMagneticSubs; j++) mass[j] = scan.nextDouble();
        	
        	System.out.printf("#%d", i+1);
        	// °è»ê
        	for(int k=0; k < x_cor.length-1; k++) {
        		
        		double left_cor = x_cor[k];
        		double right_cor = x_cor[k+1];
        		double equilibriumPoint = 0;
        		
        		while(true) {
        			if(Math.abs((left_cor - right_cor)) <= 1e-12) break;
        			double left_force = 0;
            		double right_force = 0;
        			
        			equilibriumPoint = (left_cor + right_cor) / 2.0;
        			
        			for(int m=0; m <= k; m++) left_force += mass[m] / Math.pow((equilibriumPoint - x_cor[m]), 2);
            		for(int m=x_cor.length-1; m > k ;m--) right_force += mass[m] / Math.pow((equilibriumPoint - x_cor[m]), 2);
            		
            		if(left_force > right_force) {
            			left_cor = equilibriumPoint;
            		} else {
            			right_cor = equilibriumPoint;
            		}
        		}
        		System.out.printf(" %.10f", equilibriumPoint);
        	}
        	System.out.println();
        }
        scan.close();
    }
}