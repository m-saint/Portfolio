import java.lang.Math;
class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;
 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }
 
 public Integer data() {
	 return this.data;
 }
 
 public IBinTree left() {
	 return this.left;
 }
 
 public IBinTree right() {
	 return this.right;
 }
 
 public boolean isBigger(IBinTree root) {
	 return (this.data() >= root.data());
 }

 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }
 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }
 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }
 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }
 
 public boolean isHeap(IBinTree root) {
	 
	if (root == null) return true;
	if (root.left() == null && root.right() == null) return true;
	
	if (root.left().isBigger(root) && root.right().isBigger(root)) {
		return (isHeap( root.left()) && isHeap( root.right()));
	}
	
	return false;
 }
}