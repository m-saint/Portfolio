/**
 * contains methods which test addElt and remMinElt
 * @author mstje
 */
public class HeapChecker {
/**
 * checks if a binary tree is a valid solution to adding an element to a heap
 * @param hOrig original heap before addition
 * @param elt the element to be added
 * @param hAdded the final binary tree that we are checking
 * @return whether or not hAdded is a valid solution
 */
	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {

		if (hAdded.size() == hOrig.size() +1 &&
				hAdded.hasElt(elt) && 
				hAdded.isHeap(hAdded) == true) {
					return true;
				} else return false;

    }
	
	/**
	 * checks if a binary tree is a valid solution to removing the smallest element from a heap
	 * @param hOrig original heap before removal
	 * @param hRemoved the final binary tree that we are checking
	 * @return whether or not hRemoved is a valid solution
	 */
	public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		if (hOrig.left().data() == hOrig.data() || (hOrig.right().data() == hOrig.data())){
			if (hRemoved.size() == hOrig.size()-1 &&
					hRemoved.isHeap(hRemoved) == true) {
				return true;
			} else return false;
		}
		else if (hRemoved.size() == hOrig.size()-1 &&
				hRemoved.isHeap(hRemoved) == true &&
				hRemoved.hasElt(hOrig.data()) == false) {
			return true;
		} else return false;
	}

}
