/**
 * contains test cases for isHeap, addEltTester, and remMinEltTester
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Examples {
	
    HeapChecker HC = new HeapChecker();
    
    DataBT bt = new DataBT(-666);
    
    DataBT left = new DataBT(55);
    DataBT right = new DataBT(4);
    DataBT root1 = new DataBT(4, left, right); 
    DataBT root2 = new DataBT(5, left, right); 
    
    DataHeap LLL = new DataHeap(600);
    DataHeap RRR = new DataHeap(600);
    DataHeap LRL = new DataHeap(400);
    DataHeap RLL = new DataHeap(250);
    DataHeap RRL = new DataHeap(350);
    DataHeap LLR = new DataHeap(500);
    DataHeap RLR = new DataHeap(550);
    DataHeap LRR = new DataHeap(450);
    DataHeap LeL = new DataHeap(200,LLL, LLR);
    DataHeap LeR = new DataHeap(150, LRL, LRR);
    DataHeap RLe = new DataHeap(175, RLL, RLR);
    DataHeap RiR = new DataHeap(125, RRL, RRR);
    DataHeap Le = new DataHeap(100);
    DataHeap Ri = new DataHeap(50);
    DataHeap myHeap = new DataHeap(10, Le, Ri); 
    
    DataBT imposter = new DataBT(1000, Le, Ri); 
    
    IHeap wrongTimes = myHeap;
    IHeap wrongTimesOther = myHeap;
    IHeap wrongTotalElts = myHeap;
   
    /**
     * sets up heaps to be used in test cases
     */
    @Before
    public void setup() {
    	
		wrongTimes = wrongTimes.addElt(76); 
		
		wrongTimesOther = wrongTimesOther.addElt(150); 
		wrongTimesOther = wrongTimesOther.addElt(150);
		wrongTimesOther = wrongTimesOther.addElt(500);
		wrongTotalElts = wrongTotalElts.addElt((int)Math.random());
	 
    }
    
    TestHeap TH1 = new TestHeap(10, Le, Ri);
    TestHeap2 TH2 = new TestHeap2(10, Le, Ri);
    TestHeap3 TH3 = new TestHeap3(10, Le, Ri);
    TestHeap4 TH4 = new TestHeap4(10, Le, Ri);
    TestHeap5 TH5 = new TestHeap5(10, Le, Ri);
    
    @Test
    public void isHeapTest() {
    	assertTrue(bt.isHeap(root1));
    }
    
    @Test
    public void isntHeapTest() {
    	assertFalse(bt.isHeap(root2));
    }

	@Test
	  public void testAdd1(){
	 
	    assertTrue(HC.addEltTester(myHeap,5,myHeap.addElt(5)));

	  }
	
	@Test
	  public void testAdd2(){
	 
	    assertTrue(HC.addEltTester(myHeap,200,myHeap.addElt(200)));

	  }
	
	@Test
	  public void testNotHeap(){
	 
	    assertFalse(HC.addEltTester(myHeap,1000,imposter));

	  }
	
	@Test
	  public void testAddedEltWrongNumTimes(){
		
	    assertFalse(HC.addEltTester(wrongTimes,76,myHeap.addElt(76)));

	  }
	
	@Test
	  public void testOtherEltWrongNumTimes(){
		
		
	    assertFalse(HC.addEltTester(wrongTimesOther,10,myHeap.addElt(10)));

	  }
	
	@Test
	  public void testWrongTotalElts(){
		
		
	    assertFalse(HC.addEltTester(wrongTotalElts,5,myHeap.addElt(5)));

	  }
	
	@Test
	  public void testRem1(){
	 
	    assertTrue(HC.remMinEltTester(myHeap, myHeap.remMinElt()));

	  }
	
	@Test
	  public void testRem2(){
	 
	    assertFalse(HC.remMinEltTester(myHeap, root1));

	  }
	
	@Test
	  public void testRemNotHeap(){
	 
	    assertFalse(HC.remMinEltTester(myHeap, imposter));

	  }
	
	@Test
	  public void testRemWrongAdded(){
	 
	    assertFalse(HC.remMinEltTester(myHeap, wrongTimes.remMinElt()));

	  }
	
	@Test
	  public void testRemOtherEltWrongNumTimes(){
		
		
	    assertFalse(HC.remMinEltTester(wrongTimesOther, myHeap.remMinElt()));

	  }
	
	@Test
	  public void testRemWrongTotalElts(){
		
		
	    assertFalse(HC.remMinEltTester(wrongTotalElts,myHeap.remMinElt()));

	  }

}
