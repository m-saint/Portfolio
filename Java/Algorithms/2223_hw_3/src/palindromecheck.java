import java.util.Scanner;

public class palindromecheck {
	
	static void palCheck(String pPal) {
		
		String pPalClean = pPal.toLowerCase().replaceAll("\\p{Punct}","").replaceAll(" ", "");
		char[] letters = pPalClean.toCharArray();  
		String reverse = "";
		
		for(int i=letters.length-1;i>=0;i--) {  
		        reverse+=letters[i];  
		}  
		
		if (pPalClean.equals(reverse)) {
			System.out.println("palindrome");
		}
		else System.out.println("no");
		
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("enter word or phrase");
		String potentialPalindrome = in.nextLine();
		
		palCheck(potentialPalindrome);
		
	}

}
