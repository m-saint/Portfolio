import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class Planning {
	
	double rainfall(LinkedList<Double> readings) {
		double total = 0;
		int acc = 0;
		for (Double reading : readings) {
			if (reading.equals(-999.0)) {
				if (acc==0) {
					return -1;
				} else return (total/acc);
			} else if (reading >= 0) {
				total = total + reading;
				acc++;
			  } 
		} if (acc==0) {
			return -1;
		} else return (total/acc);
	}
	
	LinkedList<Double> sampledata = new LinkedList<Double>();
	LinkedList<Double> sampledata2 = new LinkedList<Double>();
	LinkedList<Double> sampledata3 = new LinkedList<Double>();
	LinkedList<Double> sampledata4 = new LinkedList<Double>();

	
	@Before
	public void setup() {
		sampledata.add(1.0);
		sampledata.add(-2.0);
		sampledata.add(5.0);
		sampledata.add(-999.0);
		sampledata.add(8.0);
		
		sampledata2.add(-999.0);
		sampledata2.add(-999.0);
		sampledata2.add(-999.0);
		sampledata2.add(-999.0);
		sampledata2.add(-999.0);
		
		sampledata3.add(-1.0);
		sampledata3.add(-2.0);
		sampledata3.add(-5.0);
		sampledata3.add(-998.0);
		sampledata3.add(-8.0);
		
		sampledata4.add(1.25);
		sampledata4.add(2.44444);
		sampledata4.add(5.0);
		sampledata4.add(999.9);
		sampledata4.add(8.000000000000000000000005);
	}
	

	@Test
	public void rainTest() {
		assertEquals(3.0, rainfall(sampledata),0);
	}
	
	@Test
	public void rainTest2() {
		assertEquals(-1.0, rainfall(sampledata2),0);
	}
	
	@Test
	public void rainTest3() {
		assertEquals(-1.0, rainfall(sampledata3),0);
	}
	
	@Test
	public void rainTest4() {
		assertEquals(203.318888, rainfall(sampledata4),0);
	}

}
