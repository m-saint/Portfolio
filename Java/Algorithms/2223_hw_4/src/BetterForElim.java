
public class BetterForElim {

	public static void main (String[] args) {
		
		int[][] A = {{1,1,1,6}, {1,1,2,9}, {2,2,3,15}};
		
		for (int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 4; j++){
			System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int n = 3;
	
		for (int i=0; i < n - 1; i++) {
			
			int pivotrow = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(A[j][i]) > Math.abs(A[pivotrow][i])){
					pivotrow = j;
				}
			}
			
			for (int k = i; k < n+1; k++) {
				
				int temp = A[i][k];
				A[i][k] = A[pivotrow][k];
				A[pivotrow][k] = temp;
			}
			
			for (int j = i + 1; j < n; j++) {
				int temp = A[j][i] / A[i][i];
						for (int k = n; k >= i; k--) {
							A[j][k] = A[j][k] - A[i][k] * temp;
						}
						
			}
			
			
		}
			
		
		for (int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 4; j++){
			System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}

	}
	
}
