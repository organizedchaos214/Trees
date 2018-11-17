/**
 * @author Shane Anderson
 *
 * This program will calculate the sum of the leaf nodes in
 * a binary tree. The program uses recursion.
 */

public class leafSum 
	{
	public static int sum;
	
	public static void sumOfLeafNodes (Node root)
		{
		//base case: no root/empty tree:
		if (root == null)
			{
			return;
			}
		
		//case: one root only, no left or right subtrees:
		if (root.left == null && root.right == null)
			{
			sum += root.data;
			}
		
		//case: recursive case:
		else
			{
			//propagate recursively through left and right subtrees:
			sumOfLeafNodes (root.left);
			sumOfLeafNodes (root.right);
			}
		}
	   
	
	public static void main(String[] args) 
		{
		
		/****************************** 
		 
		Input : 
		        1
		      /   \
		     2     3
		    / \   / \
		   4   5 6   7
		          \
		           8
		           
		 *******************************/
		
		Node root = new Node(1);
		
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);
        
        sum = 0;
        
        sumOfLeafNodes (root);
        
        System.out.println(sum);
        
        //System.out.println(test(5));
		}
	}