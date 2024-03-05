import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		
		DoubleTrouble game = new DoubleTrouble();
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
			System.out.println("player 1 or player 2?");
			int s = in.nextInt();
			
			if (s==1) {
				
				while(game.isOver()!= true) {
					System.out.println("there are " + game.green + " green, " + game.yellow + " yellow, and " + game.orange + " orange");
					System.out.println("color to be removed?");
					String pcolor = in.next();
					if (!"green".equals(pcolor) && !"yellow".equals(pcolor) && !"orange".equals(pcolor)) {
						System.out.println("nope!");
						break;
					}
					System.out.println("how many?");
					int pnum = in.nextInt();
					
					if (pnum <1) {
						System.out.println("nope!");
						break;
					}
					else if (pcolor.equals("green") && pnum > game.green) {
						System.out.println("nope!");
						break;
					}
					else if (pcolor.equals("yellow") && pnum > game.yellow) {
						System.out.println("nope!");
						break;
					}
					else if (pcolor.equals("orange") && pnum > game.orange) {
						System.out.println("nope!");
						break;
					}
					
					game.remove(pcolor,pnum);
					
					if (game.isOver()) {
						System.out.println("you win");
						break;
					}
					else {
						if (game.isOver()) {
							System.out.println("my turn");
						}
					}
					
					String ccolor = "";
					int cnum = -1;
					
					if(game.zeroPosition()) {
						
						ArrayList<String> colors = new ArrayList<String>();
						if (game.green != 0) colors.add("green");
						if (game.yellow != 0) colors.add("yellow");
						if (game.orange != 0) colors.add("orange");
						
						ccolor = colors.get(rand.nextInt(colors.size()));
						if (ccolor.equals("green")) {
							cnum = (rand.nextInt(game.green)) +1 ;
						}
						else if (ccolor.equals("yellow")) {
							cnum = (rand.nextInt(game.yellow)) +1 ;
						}
						else if (ccolor.equals("orange")) {
							cnum = (rand.nextInt(game.orange)) +1;
						}
						
						game.remove(ccolor, cnum);
						
					}	
					else {
						
						if (game.orange > (game.green ^ game.yellow)){
							
							ccolor = "orange";
							cnum = (game.orange - (game.green ^ game.yellow));
							game.remove(ccolor, cnum);
						}
						
						else if (game.yellow > (game.green ^ game.orange)){
							
							ccolor = "yellow";
							cnum = (game.yellow - (game.green ^ game.orange));
							game.remove(ccolor, cnum);
						}
						
						else if (game.green > (game.yellow ^ game.orange)){
							
							ccolor = "green";
							cnum = (game.green - (game.yellow ^ game.orange));
							game.remove(ccolor, cnum);
						}
					}
					
					System.out.println("I removed " + cnum + " " + ccolor);
					if (game.isOver()) {
						System.out.println("I win");
						break;
					}
					else {
						System.out.println("your turn");
					}
				}
			}
			
			else if (s==2) {
				
				while(game.isOver()!= true) {
					
					String ccolor = "";
					int cnum = -1;
					
					if(game.zeroPosition()) {
						
						ArrayList<String> colors = new ArrayList<String>();
						if (game.green != 0) colors.add("green");
						if (game.yellow != 0) colors.add("yellow");
						if (game.orange != 0) colors.add("orange");
						
						ccolor = colors.get(rand.nextInt(colors.size()));
						if (ccolor.equals("green")) {
							cnum = (rand.nextInt(game.green)) +1 ;
						}
						else if (ccolor.equals("yellow")) {
							cnum = (rand.nextInt(game.yellow)) +1 ;
						}
						else if (ccolor.equals("orange")) {
							cnum = (rand.nextInt(game.orange)) +1;
						}						
						game.remove(ccolor, cnum);
					}	
					else {
						
						if (game.orange > (game.green ^ game.yellow)){
							
							ccolor = "orange";
							cnum = (game.orange - (game.green ^ game.yellow));
							game.remove(ccolor, cnum);
						}
						
						else if (game.yellow > (game.green ^ game.orange)){
							
							ccolor = "yellow";
							cnum = (game.yellow - (game.green ^ game.orange));
							game.remove(ccolor, cnum);
						}
						
						else if (game.green > (game.yellow ^ game.orange)){
							
							ccolor = "green";
							cnum = (game.green - (game.yellow ^ game.orange));
							game.remove(ccolor, cnum);
						}
					}
					
					System.out.println("I removed " + cnum + " " + ccolor);
					if (game.isOver()) {
						System.out.println("I win");
						break;
					}
					else {
						System.out.println("your turn");
					}
					
					System.out.println("there are " + game.green + " green, " + game.yellow + " yellow, and " + game.orange + " orange");
					System.out.println("color to be removed?");
					String pcolor = in.next();
					if (!"green".equals(pcolor) && !"yellow".equals(pcolor) && !"orange".equals(pcolor)) {
						System.out.println("nope!");
						break;
					}
					System.out.println("how many?");
					int pnum = in.nextInt();
					if (pnum <1) {
						System.out.println("nope!");
						break;
					}
					if (pcolor.equals("green") && pnum > game.green) {
						System.out.println("nope!");
						break;
					}
					else if (pcolor.equals("yellow") && pnum > game.yellow) {
						System.out.println("nope!");
						break;
					}
					else if (pcolor.equals("orange") && pnum > game.orange) {
						System.out.println("nope!");
						break;
					}
					
					game.remove(pcolor,pnum);
					
					if (game.isOver()) {
						System.out.println("you win");
						break;
					}
					else {
							System.out.println("my turn");			
					}	
				}
			} else System.out.println("nope!");
		
	}
	
}

//The name of the game is Nim, and it was solved by Charles Bouton
