import java.util.Scanner;

class SubirachAllCombos {

	static void getCombos(int[] square, int n, int comboSize, int index, int[] currentTempArr, int i, int desiredSum){
	
		if (index == comboSize) {
			
		 int sum = 0;
		 for (int w = 0; w < currentTempArr.length; w++) {
			 sum += currentTempArr[w];
		 }
		 if(sum == desiredSum) {
			 
			for (int j=0; j<comboSize; j++) {
				System.out.print(currentTempArr[j] + " ");
			}
			System.out.println();
		 }
		return;
		}

		if (i >= n) {
		return;
		}

		currentTempArr[index] = square[i];
		getCombos(square, n, comboSize, index+1, currentTempArr, i+1, desiredSum);
		
        while (i != 15 && square[i] == square[i+1])
             i++; 

		getCombos(square, n, comboSize, index, currentTempArr, i+1, desiredSum);
	}

	static void printCombos(int square[], int n, int comboSize, int desiredSum) {
		int[] currentTempArr = new int[comboSize];
		getCombos(square, n, comboSize, 0, currentTempArr, 0, desiredSum);
	}

	public static void main (String[] args) {
		int[] square= {1,2,3,4,5,6,7,8,9,10,10,11,13,14,14,15};
		int n = square.length;
		Scanner in = new Scanner(System.in);
		System.out.println("enter desired sum");
		int desiredSum = in.nextInt();
		for (int comboSize = 1; comboSize <= square.length; comboSize++) {
			printCombos(square, n, comboSize, desiredSum);
		}
		System.out.println("the most common sum is 66, AKA half of the max sum");
	}
}
