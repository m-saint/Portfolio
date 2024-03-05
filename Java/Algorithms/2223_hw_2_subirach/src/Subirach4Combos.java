class Subirach4Combos {

	public static void getCombos(int[] square, int n, int comboSize, int index, int[] currentTempArr, int i) {
		
		if (index == comboSize) {
			
		 if(currentTempArr[0] + currentTempArr[1] + currentTempArr[2] + currentTempArr[3] == 33) {
			 
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
		getCombos(square, n, comboSize, index+1, currentTempArr, i+1);
		
        while (i != 15 && square[i] == square[i+1]) {
        	i++;
        }

		getCombos(square, n, comboSize, index, currentTempArr, i+1);
	}

	static void printCombos(int square[], int n, int comboSize) {
	
		int[] currentTempArr = new int[comboSize];
		getCombos(square, n, comboSize, 0, currentTempArr, 0);
	}

	public static void main (String[] args) {
		int[] square= {1,2,3,4,5,6,7,8,9,10,10,11,13,14,14,15};
		int comboSize = 4;
		int n = square.length;
		printCombos(square, n, comboSize);
	}
}
