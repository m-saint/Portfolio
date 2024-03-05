import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}
    
    Song HapBD = new Song("Happy Birthday", 18);
    Song song1 = new Song("Song Title", 1000);
    Song song2 = new Song("Title of Song", 10000);
    
    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */
    
    @Test

    public void checkHBLen() {
       assertEquals(18, HapBD.lenInSeconds);
     }
    
@Test
    
    public void checkSong1Len() {
        assertEquals(999, song1.lenInSeconds);
      }

   
  
}