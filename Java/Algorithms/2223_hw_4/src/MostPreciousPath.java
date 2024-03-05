
public class MostPreciousPath {
	
	static int n = 8;
	static int[][] square = { {35,89,52,66,82,20,95,21}, 
			   {79, 5, 14, 23, 78, 37, 40, 74},
			   {32, 59, 17, 25, 31, 4, 16, 63},
			   {91, 11, 77, 48, 13, 71, 92, 15},
			   {56, 70, 47, 64, 22, 88, 67, 12},
			   {83, 97, 94, 27, 65, 51, 30, 7},
			   {10, 41, 1, 86, 46, 24, 53, 93},
			   {96, 33, 44, 98, 75, 68, 99, 84}
	};
	
	static int[][] max_sums_so_far = new int[n][n];
	static int[][] been_here = new int[n][n];
	static int total_sum = 0;
	
	static int most_precious_path(int row, int col)
	{
		if (row == n - 1) {
			max_sums_so_far[row][col] = square[row][col];
			been_here[row][col] = 1;
			return square[row][col];
		}
	
		if (been_here[row][col] != 0)
			return max_sums_so_far[row][col];
		
		been_here[row][col] = 1;
	
		int total_sum = 0;
		
		if (col == n-1) {
			total_sum = square[row][col] + Math.max(
						most_precious_path(row+1,col),
						most_precious_path(row+1,col-1));
		}
		
		else if (col == 0) {
			total_sum = square[row][col] + Math.max(
						most_precious_path(row+1,col),
						most_precious_path(row+1,col+1));
		}
		
		else {
			total_sum = square[row][col] + Math.max(
						most_precious_path(row+1,col-1),
						Math.max(
						most_precious_path(row+1,col+1),
						most_precious_path(row+1,col)));
		}	
		
		max_sums_so_far[row][col] = total_sum;
	
		return total_sum;
	}
	
	public static void main(String[] args)
	{
	
		int max_sum_1 = most_precious_path(0, 0);
		been_here = new int[n][n];
		int max_sum_2 = most_precious_path(0, 1);
		been_here = new int[n][n];
		int max_sum_3 = most_precious_path(0, 2);
		been_here = new int[n][n];
		int max_sum_4 = most_precious_path(0, 3);
		been_here = new int[n][n];
		int max_sum_5 = most_precious_path(0, 4);
		been_here = new int[n][n];
		int max_sum_6 = most_precious_path(0, 5);
		been_here = new int[n][n];
		int max_sum_7 = most_precious_path(0, 6);
		been_here = new int[n][n];
		int max_sum_8 = most_precious_path(0, 7);
				
	    int max_sum = 
				Math.max(
						Math.max(
						  Math.max(max_sum_1,max_sum_2),
						  Math.max(max_sum_3, max_sum_4)),
						Math.max(
						  Math.max(max_sum_5, max_sum_6),
						  Math.max(max_sum_7, max_sum_8))
			    );
	
		System.out.println("Max Gems: " + max_sum);
		
		System.out.println();
		
		int startingCol = 3; 
		
		int currentCol = startingCol;
		
		int[] path = new int[n];
	
		for (int row = n-1; row >= 0; row--) {
			
			if (currentCol == 0) {
				for (int col = 0; col <= currentCol+1; col++) {
					if (max_sums_so_far[row][col] > max_sums_so_far[row][currentCol]) {
						currentCol = col;
					}
				}
			}
			
			else if (currentCol == n-1) {
				for (int col = n-2; col <= currentCol; col++) {
					if (max_sums_so_far[row][col] > max_sums_so_far[row][currentCol]) {
						currentCol = col;
					}
				}
			}
			
			else {
				for (int col = currentCol-1; col <= currentCol+1; col++) {
					if (max_sums_so_far[row][col] > max_sums_so_far[row][currentCol]) {
						currentCol = col;
					}
				}
			}
			
			path[row]=square[row][currentCol];
		}
		
		
		System.out.print("Path: ");
		for (int i : path) {
			System.out.print(i + " ");
		}
		
		System.out.println();System.out.println();
		
		System.out.println("Starting Square: " + path[0]); System.out.println();
		
		System.out.println("Vault #" + (startingCol + 1) );
		
	}
}
	