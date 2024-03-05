/*

1. If A[i, i] is 0, we aren’t able to divide by it so we can’t use row i as a pivot for the ith 
iteration. This is what occurs when the forward elimination algorithm tries to find a solution to this
matrix. We can get around this division by zero error by doing a row exchange with the ith row and some
other row below that. But this other row can’t have zero as a coefficient in the ith column, because
then we’d run into the same problem. The better forward algorithm accomplishes this by searching for a
row that has the largest absolute value of the coefficient in the ith column, exchanging it with the 
ith row, and then using the new A[i, i] as the ith iteration’s pivot. This guarantees that the scaling
factor will never exceed a magnitude of 1.  

2. The fact that the leading nonzero coefficient of the third row is not one causes an issue when 
looking for a row with the largest absolute value of the coefficient in the ith column. When It doesn’t 
find such a row, it doesn’t make a swap when it really needs to. This causes the algorithm to not 
provide a solution to this system of equations, because it reintroduces the possibility that the new 
value of A[j, k] might become distorted by a round-off error caused by a scaling factor of more than 1. 
Attempting to check for and print this matrix’s solution results in a non-upper-triangular matrix as 
an output, which means we can’t use back substitution to solve. This can be remedied by either moving
to a Gauss-Jordan approach for elimination as shown or by altering the row exchange stage of the better
forward elimination algorithm to more reliably make the swaps it should to avoid the round-off errors. 

*/

public class GJ{
	
	static float[][] matrix = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 364},
			{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
			{0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 16},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 36},
			{0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 64},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 100},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 79},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 61},
			{0, 0, 0, 0, 0, 4, -3, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 3, -2, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 1, -1, 0, 0, 0},
			{1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, -42} };

    static void gaussJordan() {
        int col = 0;
        
        for (int row=0; row < matrix.length; row++) {
            while (matrix[row][col] == 0){
                
            	boolean swapped = false;
                
                for (int i = row; i < matrix.length; i++) {
                	if (swapped == false && matrix[i][col] != 0) {
                		float[] tempArr = matrix[i];
                        matrix[i]=matrix[row];
                        matrix[row]=tempArr;
                        swapped = true;
                	}
                }
              
                if (matrix[row][col] == 0) {
                    col++;
                }
            }

            if(matrix[row][col] != 1) {
                float p = matrix[row][col];
                for (int i = col; i < matrix[row].length; i++) {
                    matrix[row][i] /= p;
                }
            }
           
            for (int i = 0; i < matrix.length; i++) {
            	 float m = -1 * matrix[i][col];
                if (i != row && matrix[i][col] != 0) {
                    for (int j = col; j < matrix[row].length; j++){
                        matrix[i][j] += matrix[row][j] * m;
                    }
                }
            }
            col++;
        }
    }

    public static void main(String[] args) {
    	
    	for (int row = 0; row < matrix.length; row++) {
    		for (int col = 0; col < matrix[row].length; col++) {
    			System.out.print(matrix[row][col] + "  ");
    		}
    		System.out.println(); System.out.println();
    	}
    	
    	System.out.println("| (elimination)"); System.out.println("V"); System.out.println();
    	
    	gaussJordan();
    	
    	for (int row = 0; row < matrix.length; row++) {
    		for (int col = 0; col < matrix[row].length; col++) {
    			System.out.print(matrix[row][col] + "  ");
    		}
    		System.out.println(); System.out.println();
    	}
    	
    	System.out.println("| (solution -> rounded integers)"); System.out.println("V"); System.out.println();
    	
    	for (int row = 0; row < matrix.length; row++) {
    			int num = Math.round(matrix[row][matrix[row].length - 1]);
    			System.out.print(num + "  ");
    	}
    }
}