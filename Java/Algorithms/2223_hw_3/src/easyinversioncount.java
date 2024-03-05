
public class easyinversioncount {
	
	static void ezInvCt(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j<arr.length; j++) {
				if (arr[i]>arr[j]) {
					count++;
				}
			}
			
		}
		System.out.println("array contains " + count + " inversions");
	}
	
	public static void main(String[] args) {
		int[] testArr1 = {1,2,3,4,4};
		ezInvCt(testArr1);
		int[] testArr2 = {5,4,3,2,1};
		ezInvCt(testArr2);
		int[] testArr3 = {1,2,3,5,4};
		ezInvCt(testArr3);
		int[] testArr4 = {2,1,3,5,4};
		ezInvCt(testArr4);
		int[] testArr5 = {2,3,5,4,1};
		ezInvCt(testArr5);
	}

}
