import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//I/O for Lucas Numbers
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter number (Lucas numbers)");
		int n = in.nextInt();
		Lucas luke = new Lucas(n);
		System.out.println(luke.finalnums);
		System.out.println("Time: " + (luke.afterTime - luke.beforeTime) + " nanoseconds!");
		System.out.println("The order of growth of this algorithm is O(2^n)");
		System.out.println();
		
		//I/O for Myles Numbers
		
		Scanner in2 = new Scanner(System.in);
				
		System.out.println("enter number (Myles numbers)");
		int m = in2.nextInt();
		Myles myles = new Myles(m);
		System.out.println(myles.finalnums);
		System.out.println("Time: " + (myles.afterTime - myles.beforeTime) + " nanoseconds!");
		System.out.println("The order of growth of my algorithm is O(2^n)");
		System.out.println();
		
		
		//average ratio of successive calculations L(n+1) / (L(n)
		
		int i = 0;
		double totalR = 0.0;
		
		while (i<40) {
			Lucas lucas1 = new Lucas(i);
			Lucas lucas2 = new Lucas(i+1);
			totalR += ( (double)(lucas2.finalnums.get(lucas2.finalnums.size()-1)) / (double)(lucas1.finalnums.get(lucas1.finalnums.size()-1)));
			i++;
		}
		
		double averageR = totalR/40;
		System.out.println("Average ratio of successive calculations (Lucas) = " + averageR);
		
		
		//average ratio of successive calculation times Time[L(n+1)] / Time[(L(n)]
		
		int j = 0;
		double totalTimeR = 0.0;
		
		while (j<40) {
			Lucas lucas3 = new Lucas(j);
			Lucas lucas4 = new Lucas(j+1);
			totalTimeR += ( (double)(lucas4.afterTime - lucas4.beforeTime) / (double)(lucas3.afterTime - lucas3.beforeTime));
			j++;
		}
		
		double averageTimeR = totalTimeR/40;
		System.out.println("Average ratio of successive calculation times (Lucas) = " + averageTimeR);
		
		
		//average ratio of successive calculations M(n+1) / (M(n)
		
				int k = 0;
				double mtotalR = 0.0;
				
				while (k<40) {
					Myles myles1 = new Myles(k);
					Myles myles2 = new Myles(k+1);
					mtotalR += ( (double)(myles2.finalnums.get(myles2.finalnums.size()-1)) / (double)(myles1.finalnums.get(myles1.finalnums.size()-1)));
					k++;
				}
				
				double maverageR = mtotalR/40;
				System.out.println("Average ratio of successive calculations (Myles) = " + maverageR);
				
				
				//average ratio of successive calculation times Time[M(n+1)] / Time[(M(n)]
				
				int p = 0;
				double mtotalTimeR = 0.0;
				
				while (p<40) {
					Myles myles3 = new Myles(p);
					Myles myles4 = new Myles(p+1);
					mtotalTimeR += ( (double)(myles4.afterTime - myles4.beforeTime) / (double)(myles3.afterTime - myles3.beforeTime));
					p++;
				}
				
				double maverageTimeR = mtotalTimeR/40;
				System.out.println("Average ratio of successive calculation times (Myles) = "+ maverageTimeR);
				
		
	}

}
