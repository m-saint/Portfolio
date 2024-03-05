
public class DoubleTrouble {

	int green;
	int yellow;
	int orange;

	public DoubleTrouble(){
		
		this.green = 3;
		this.yellow = 7;
		this.orange = 5;
	}
	
	 void remove(String color, int num) {
		if( color.toLowerCase().equals("green")){
			this.green -= num;
		}
		if( color.toLowerCase().equals("yellow")){
			this.yellow -= num;
		}
		if( color.toLowerCase().equals("orange")){
			this.orange -= num;
		}
	 }
	 
	 boolean isOver() {
			
			if(this.green == 0 && this.yellow == 0 && this.orange == 0) {
				
				return true;
			}
			else return false;
		}
	 
	 boolean zeroPosition() {
		 if ((this.green ^ this.yellow ^ this.orange) == 0) {
			 return true;
		 } else return false;
	 }

	
}
