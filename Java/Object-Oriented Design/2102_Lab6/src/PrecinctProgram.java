import java.util.Scanner;

public class PrecinctProgram {
	
	public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		
		Precinct worcester12;
		worcester12 = new Precinct("Worcester12", "130 Winter Street", 1673);
		
		System.out.println(worcester12);
		System.out.print("enter population increase");
		System.out.println(worcester12.grow(keyboard.nextInt()));
		
		System.out.println("");
		
		String name;
		String address;
		int pop;
		
		System.out.print("enter pop");
		pop = keyboard.nextInt();
		String dummy = keyboard.nextLine();
		System.out.print("enter address");
		address = keyboard.nextLine();
		System.out.print("enter name");
		name = keyboard.nextLine();
		
		System.out.println(new Precinct(name, address, pop));


		
		
	}

}
