import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {
	
	Dillo dill0 = new Dillo(15, true);
	
	Boa b0a = new Boa("Ricky", 200, "electrons");
	Boa maneater = new Boa("Sheldon", 1, "people");
	
	Fish fishy = new Fish(10, 2);
	Fish big_fishy = new Fish(60, 5);
	
	Shark sharky = new Shark(8,0);
	Shark sm0l_sharky = new Shark(3, 75);
	
	@Test
	public void sharkSizeTest() {
		assertEquals(true, sharky.isNormalSize());
	}
	
	@Test
	public void bigsharkSizeTest() {
		assertEquals(false, sm0l_sharky.isNormalSize());
	}
	
	@Test
	public void dilloDangerTest() {
		assertEquals(false, dill0.isDangerToPeople());
	}
	
	@Test
	public void hrmlsBoaDangerTest() {
		assertEquals(false, b0a.isDangerToPeople());
	}
	
	@Test
	public void boaDangerTest() {
		assertEquals(true, maneater.isDangerToPeople());
	}
	
	@Test
	public void fishDangerTest() {
		assertEquals(false, big_fishy.isDangerToPeople());
	}
	
	@Test
	public void hrmlsSharkDangerTest() {
		assertEquals(false, sharky.isDangerToPeople());
	}
	
	@Test
	public void sharkDangerTest() {
		assertEquals(true, sm0l_sharky.isDangerToPeople());
	}
	
}
