import java.util.ArrayList;
import java.util.List;

public class Lucas {
	  
	List<Long> nums = new ArrayList<Long>();
	List<Long> finalnums = new ArrayList<Long>();
	int n;
	long beforeTime;
	long afterTime;
	
	public Lucas (int n) {
		this.n = n;
		this.beforeTime = System.nanoTime();
		finalnums = LucasNums(0);
		this.afterTime = System.nanoTime();
	}
	
	public List<Long> LucasNums(int i){
		
		
		if (i>this.n) {
			
			
			return this.nums;
		}
		
		else if (i == 0) {
			
			this.nums.add((long) 2);
			return LucasNums(i+1);
		}
		
		else if (i == 1) {
			
			this.nums.add((long) 1);
			return LucasNums(i+1);
		}
		
		else {
			this.nums.add((this.nums.get(i-1)+this.nums.get(i-2)));
			return LucasNums(i+1);
		}
		
	}
	
}


