
public class fastinversioncount { 
	
	static int invCt = 0;
	
    public static void mergeSort(int[] arr) { 
       
        if(arr.length == 0) { 
            return; 
        } 
        
        else if (arr.length > 1) { 
        	
            int mP = arr.length / 2; 
   
            int[] Larr = new int[mP]; 
            for(int i = 0; i < mP; i++) { 
                Larr[i] = arr[i]; 
            } 
          
            int[] Rarr = new int[arr.length - mP]; 
            for(int i = mP; i < arr.length; i++) { 
                Rarr[i - mP] = arr[i]; 
            } 
            
            mergeSort(Larr);   
            mergeSort(Rarr); 
   
            int Lindex = 0; 
            int Rindex = 0; 
            int i = 0; 

            while(Lindex < Larr.length && Rindex < Rarr.length) { 
                if(Larr[Lindex] <= Rarr[Rindex]) { 
                    arr[i] = Larr[Lindex]; 
                    Lindex++; 
                } 
                else { 
                    arr[i] = Rarr[Rindex]; 
                    Rindex++; 
                    invCt+=(mP-Lindex);
                } 
                
                i++; 
            } 
  
            while(Lindex < Larr.length) { 
                arr[i] = Larr[Lindex]; 
                Lindex++; 
                i++;
            } 
            while(Rindex < Rarr.length) { 
                arr[i] = Rarr[Rindex]; 
                Rindex++; 
                i++; 
            } 
        }
        
    }
    
    public static void main(String[] args) { 
    	
    	int[] testArr1 = {5,4,3,2,1};   
    	mergeSort(testArr1);
    	System.out.println("Array contains " + invCt + " inversions");
    	invCt = 0;
    	
    	int[] testArr2 = {1,2,3,4,5,6,7,8,8};   
    	mergeSort(testArr2);
    	System.out.println("Array contains " + invCt + " inversions");
    	invCt = 0;
    	 
        int[] testArr3 = {0};     
        mergeSort(testArr3);
    	System.out.println("Array contains " + invCt + " inversions");
    	invCt = 0;
        
        int[] testArr4 = {1,3,2,5,4};
        mergeSort(testArr4);
    	System.out.println("Array contains " + invCt + " inversions");
    	invCt = 0;
        
    	int[] testArr5 = {2,3,5,4,1};
    	mergeSort(testArr5);
    	System.out.println("Array contains " + invCt + " inversions");
    	invCt = 0;
    } 
} 