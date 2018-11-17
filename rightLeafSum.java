/**
 * @author Shane Anderson
 *
 *This program returns the sum of right leaves in a binary 
 *tree
 */

public class rightLeafSum 
	{
	public static int sum;
	
	public static int rightSum (Node root)
		{
		if (root == null)
			{
			return 0;
			}
		
		if (root.right != null && root.right.right == null && root.right.left == null)
			{
			sum += root.right.data;
			}
		
		rightSum(root.left);
		rightSum(root.right);
		
		return sum;
		}
	
	
	public static void main(String[] args) 
		{
		/***********************
		Input:
		 
		    3
		   / \
		  9  20
		    /  \
		   15   7
			 \
			  17
			  
		 ************************/
		
		Node root = new Node (3);
		
		root.left = new Node (9);
		
		root.right = new Node (20);
		root.right.left = new Node (15);
		root.right.right = new Node (7);
		root.right.left.right = new Node (17);
		
//		Node root = new Node (1);
//		
//		root.right = new Node (2);
		
		sum = 0;
		
		System.out.println(rightSum(root));
		}

	}
