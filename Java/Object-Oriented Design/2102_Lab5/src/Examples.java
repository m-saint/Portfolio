import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Examples {
	
	
	LinkedList<String> list = new LinkedList<String>();
	
	DataBST ricky = new DataBST("ricky", new EmptyBST(), new EmptyBST());
	DataBST jim = new DataBST("jim", new EmptyBST(), new EmptyBST());
	DataBST sue = new DataBST("sue", new EmptyBST(), new EmptyBST());
	DataBST theresa = new DataBST("theresa", new EmptyBST(), new EmptyBST());
	DataBST boys = new DataBST("karl", ricky, jim);
	DataBST girls = new DataBST("diane", sue, theresa);
	DataBST bst = new DataBST("alex", boys, girls);
	AVL avl = new AVL("alex", boys, girls);

	@Before
	public void setup() {
		list.add("alex");
		list.add("karl");
		list.add("diane");
		list.add("jim");
		list.add("ricky");
		list.add("sue");
		list.add("theresa");
	}
	
	// an EventGuests that uses LinkedLists under the hood

		  EventGuests guestsLists = new EventGuests(list);

		  // an EventGuests that uses BSTs under the hood

		  EventGuests guestsBSTs = new EventGuests(bst);

		  // an EventGuests that uses AVL trees under the hood
		 
		  EventGuests guestsAVLs = new EventGuests(avl );
	
	@Test
	public void listTests() {
		guestsLists.addGuest("PABLO");
		assertTrue(guestsLists.isComing("PABLO"));
		assertTrue(guestsLists.isComing("jim"));
		assertEquals(guestsLists.numGuests(), 8);
		
	}
	
	@Test
	public void bstTests() {
		guestsAVLs.addGuest("PABLO");
		assertTrue(guestsAVLs.isComing("PABLO"));
		assertTrue(guestsAVLs.isComing("diane"));
		assertEquals(guestsAVLs.numGuests(), 8);
		
	}
	
	@Test
	public void avlTests() {
		guestsBSTs.addGuest("PABLO");
		assertTrue(guestsBSTs.isComing("PABLO"));
		assertTrue(guestsBSTs.isComing("theresa"));
		assertEquals(guestsBSTs.numGuests(), 8);
		
	}
	
	
	
	
	
	

}
