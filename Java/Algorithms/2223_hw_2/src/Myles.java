import java.util.ArrayList;
import java.util.List;

public class Myles {
	  
	List<Long> nums = new ArrayList<Long>();
	List<Long> finalnums = new ArrayList<Long>();
	int n;
	long beforeTime;
	long afterTime;
	
	public Myles (int n) {
		this.n = n;
		this.beforeTime = System.nanoTime();
		finalnums = MylesNums(0);
		this.afterTime = System.nanoTime();
	}
	
	public List<Long> MylesNums(int i){
		
		
		if (i>this.n) {
			
			
			return this.nums;
		}
		
		else if (i == 0) {
			
			this.nums.add((long) 10);
			return MylesNums(i+1);
		}
		
		else if (i == 1) {
			
			this.nums.add((long) 17);
			return MylesNums(i+1);
		}
		
		else if (i == 2) {
			
			this.nums.add((long) 2002);
			return MylesNums(i+1);
		}
		
		else {
			this.nums.add((this.nums.get(i-2)+this.nums.get(i-3)));
			return MylesNums(i+1);
		}
		
	}
	
}


