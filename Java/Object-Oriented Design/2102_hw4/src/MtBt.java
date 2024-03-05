import java.lang.Math;
class MtBT implements IBinTree {
 MtBT(){}
 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }
 // returns 0 since enpty tree has no elements
 public int size() {
  return 0;
 }
 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
 
 public Integer data() {
	 return null;
 }
 
 public IBinTree left() {
	 return null;
 }
 
 public IBinTree right() {
	 return null;
 }
 
 public boolean isHeap(IBinTree root) {
	 return true;
 }
 
 public boolean isBigger(IBinTree root) {
	 return true;
 }
}