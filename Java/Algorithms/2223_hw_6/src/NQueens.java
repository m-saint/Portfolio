
public class NQueens {

	static boolean boardFull (int[] posArr, int n) {
		
		boolean isFull = true;
		for (int i = 0; i < n; i++) {
			if (posArr[i] == -666) {
				isFull = false;
			}
		}
		return isFull;
	}
	
	static boolean isLegal (int[] posArr, int n) {
		boolean isLegal = true;
	
		for (int r = 0; r < n; r++) {
	
			for (int i = 0; i < n; i++) { 
				if (posArr[r] == posArr[i]
						&& posArr[r] != -666
						&& r != i) {
					isLegal = false;
				}
			}
	
			for (int j = 0; j < r; j++) {
				if (j + posArr[j] == r + posArr[r]
						&& posArr[r] != -666
						&& posArr[j] != -666) {
					return false;
				}
			}
	
			for (int k = 0; k < r; k++) {
				if (k - posArr[k] == r - posArr[r]
						&& posArr[r] != -666 
						&& posArr[k] != -666) {
					return false;
				}
			}
		}
		return isLegal;
	}
	
	static boolean checkForLegalPartial (int[] posArr, int n, int r) {
		if (posArr[r] == n - 1) {
			for (int i = r; i < n; i++) {
				posArr[i] = -666;
			}
			
			if (r == 0) {
				return false;
			}
			else return checkForLegalPartial(posArr, n, r-1);
		}
	
		for (int c = posArr[r]+1; c < n; c++) {
			posArr[r] = c;
			if (isLegal(posArr, n)) {
				return true;
			}
		}
	
		for (int i = r; i < n; i++) {
			posArr[i] = -666;
		}
	
		return checkForLegalPartial(posArr, n, r-1);
	}	
	
	static boolean findNextPos(int[] posArr, int n) {
		int r = -1;
	
		for (int i = 0; i < n; i++) {
			if (posArr[i] != -666) {
				r = i;
			}
		}
	
		if (isLegal(posArr, n) && r == n-1) {
			return checkForLegalPartial(posArr, n, r);
	
		}
	
		else if (isLegal(posArr, n)) {
	
			for (int c = 0; c < n; c++) {
				posArr[r+1] = c;
				if (isLegal(posArr, n)) {
					return true;
				}
			}
	
			posArr[r+1] = -666;
			return checkForLegalPartial(posArr, n, r);
		}
	
		else if (posArr[r] < n-1) {
			posArr[r]++;
			
			if (isLegal(posArr, n)) {
				return true;
			}
			else return findNextPos(posArr, n);
		}
		
		else return checkForLegalPartial(posArr, n, r);
	}
	
	static void findFirstSolution (int n) {
			int[] posArr = new int[n];
			for (int i = 0; i < n; i++) {
				posArr[i] = -666;
			}
			
			while (!boardFull(posArr, n)) {
				findNextPos(posArr, n);
			}
			
			System.out.println("first solution for " + n + " queens:");
			for (int i = 0; i < n; i++) {
				System.out.print(posArr[i] + 1 + " ");
			}
			System.out.println();
	}
	
	static void countEverySolution(int n) {
		boolean foundEverySolution = false;
		int count = 0;
		int[] posArr = new int[n];
	
		for (int i = 0; i < n; i++) {
			posArr[i] = -666;
		}
	
		while (!foundEverySolution) {
			while (!foundEverySolution && !boardFull(posArr, n)) {
				if (!findNextPos(posArr, n)) {
					foundEverySolution = true;
				}
			}
	
			if (!foundEverySolution && isLegal(posArr, n)) {
				count++;
				if (!findNextPos(posArr, n)) {
					foundEverySolution = true;
				}
			}
		}
		System.out.println("There are " + count + " solutions for " + n + " queens");
	}
	
	public static void main (String[] args) {
		
		for (int n = 4; n <= 20; n++) {
			findFirstSolution(n);
		}
	
		System.out.println(); System.out.println("All Solutions:");
		
		for (int n = 4; n <= 14; n++) {
			
			countEverySolution(n);
		}
	}

}
