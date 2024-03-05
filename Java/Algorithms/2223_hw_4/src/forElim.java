
public class forElim {
	
	public static void main (String[] args) {
		
		int[][] A = {{1,1,1,6}, {1,1,2,9}, {1,2,3,14}};
		
		int n = 3;
		
		for (int i = 0; i < n-1; i++) {
			
			for (int j = i + 1; j < n; j++) {
				for (int k = n; k >= i; k--) {
					A[j][k] = A[j][k] - A[i][k] * A[j][i] / A[i][i];
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
