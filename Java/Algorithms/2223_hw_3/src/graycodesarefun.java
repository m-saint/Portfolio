import java.util.ArrayList;

public class graycodesarefun {
	
	static ArrayList<String> BRGC(int n) {
		
		if (n==1) {
			ArrayList<String> L = new ArrayList<String>();
			L.add("0");
			L.add("1");
			return L;
		}
		
		else {
			ArrayList<String> L1 = BRGC(n-1);
			ArrayList<String> L2 = new ArrayList<String>();
			
			for (int i = L1.size()-1; i>=0; i--) {
				L2.add(L1.get(i));
			}
			for (int j = 0; j < L1.size(); j++) {
				L1.set(j,"0"+L1.get(j));
			}
			for (int k = 0; k < L2.size(); k++) {
				L2.set(k,"1"+L2.get(k));
			}
			
			ArrayList<String> L = new ArrayList<String>();
			
			for (String s1 : L1) {
				L.add(s1);
			}
			for (String s2 : L2) {
				L.add(s2);
			}
			
			return L;
		}
	}
	
	static void printAllTheThings(ArrayList<String> L, int n) {
		
		System.out.println("Codes:");
		
		for (int i = 0; i < L.size(); i++) {
			System.out.println(L.get(i));
		}
		
		System.out.println();
		System.out.println("Sequence and Pictures:");
		
		if (n==4) {
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
			
		for (int j = 1; j < L.size(); j++) {
			
			ArrayList<String> children = new ArrayList<String>();
			
			if (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 1) {
				if (a%2==0) {
					System.out.println("*Alice in*");
				}
				else System.out.println("*Alice out*");
				a++;
			}
			else if (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 10) {
				if (b%2==0) {
					System.out.println("*Bob in*");
				}
				else System.out.println("*Bob out*");
				
				b++;
			}		
			else if (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 100) {
				if (c%2==0) {
					System.out.println("*Chris in*");
				}
				else System.out.println("*Chris out*");
				
				c++;
			}
			else if  (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 1000) {	
				if (d%2==0) {
					System.out.println("*Dylan in*");
				}
				else System.out.println("*Dylan out*");
				
				d++;
			}
			
			if (a%2!=0) children.add("Alice");
			if (b%2!=0) children.add("Bob");
			if (c%2!=0) children.add("Chris");
			if (d%2!=0) children.add("Dylan");
			
			System.out.print("-> Pictured: ");
			for (String child : children) {
				System.out.print(child + " ");
			}
			
			System.out.println();
			
		}
		
		}
		
		else if (n==5) {
			
			int z = 0;
			int y = 0;
			int x = 0;
			int w = 0;
			int v = 0;
				
			for (int j = 1; j < L.size(); j++) {
				
				ArrayList<String> children = new ArrayList<String>();
				
				if (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 1) {
					if (z%2==0) {
						System.out.println("*Zalice in*");
					}
					else System.out.println("*Zalice out*");
					z++;
				}
				else if (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 10) {
					if (y%2==0) {
						System.out.println("*Yob in*");
					}
					else System.out.println("*Yob out*");
					
					y++;
				}		
				else if (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 100) {
					if (x%2==0) {
						System.out.println("*Xhris in*");
					}
					else System.out.println("*Xhris out*");
					
					x++;
				}
				else if  (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 1000) {	
					if (w%2==0) {
						System.out.println("*Wylan in*");
					}
					else System.out.println("*Wylan out*");
					
					w++;
				}
				
				else if  (Math.abs(Integer.parseInt(L.get(j)) - Integer.parseInt(L.get(j-1))) == 10000) {	
					if (v%2==0) {
						System.out.println("*Veve in*");
					}
					else System.out.println("*Veve out*");
					
					v++;
				}
				
				if (z%2!=0) children.add("Zalice");
				if (y%2!=0) children.add("Yob");
				if (x%2!=0) children.add("Xhris");
				if (w%2!=0) children.add("Wylan");
				if (v%2!=0) children.add("Veve");
				
				System.out.print("-> Pictured: ");
				for (String child : children) {
					System.out.print(child + " ");
				}
				
				System.out.println();
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		printAllTheThings(BRGC(4), 4);
	  //printAllTheThings(BRGC(5), 5); //(TRY ME)
	}
	
}
