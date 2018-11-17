/**
 * @author Shane Anderson
 *
 *This program returns the sum of left leaves in a binary
 *tree
 */
public class leftLeafSum 
	{
	public static int sum;
	
	public static int leftSum (Node root)
		{
		//base case: an empty tree:
		if (root == null)
			{
			return 0;
			}
		
		
		if (root.left != null && root.left.left == null && root.left.right == null)
			{
			sum += root.left.data;
			}
		
		//recurse:
		leftSum (root.left);
		leftSum (root.right);
		
		return sum;
		}
		
	
	public static void main(String[] args) 
		{
		
		/***************************
		 Input:
		 
		    3
		   / \
		  9  20
		    /  \
		   15   7

		 ***************************/
		Node root = new Node (3);
		
		root.left = new Node (9);
		
		root.right = new Node (20);
		root.right.left = new Node (15);
		root.right.right = new Node (7);

//		Node root = new Node (1);
//		root.left = new Node (2);
		
		sum = 0;
		
		//leftSum (root);
		
		System.out.println(leftSum(root));
		}
	}
