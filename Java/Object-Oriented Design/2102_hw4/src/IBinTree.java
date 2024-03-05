import java.lang.Math;
interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
 /**
  * gets the data field of a binary tree
  */
 Integer data();
 
 
/**
 * **
  * gets the left field of a binary tree
  */
 IBinTree left();
 
 /**
  * gets the right field of a binary tree
  */
 IBinTree right();
 
 /**
  * checks if a binary tree is a heap
  * @param root the binary tree we are checking
  * @return whether or not root is a heap
  */
 boolean isHeap(IBinTree root);
 
 
 /**
  * compares the data stored in two binary trees
  * @param root the Binary Tree to compare this Binary Tree object with
  * @return whether or not the object has a larger data value than root
  */
 boolean isBigger(IBinTree root);
 
}