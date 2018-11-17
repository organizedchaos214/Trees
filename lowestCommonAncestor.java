/**
 * @author Shane Anderson
 * 
 * This program returns the lowest common ancestor of two
 * given nodes within a binary tree. 
 * 
 * Assumptions: 
 * 1. the tree will be a binary tree, not a binary search tree. 
 * 2. the tree will not complain duplicate nodes.
 */
import java.util.*;

public class lowestCommonAncestor 	
	{

	/**
	 * Finds the lowest common ancestor, using the pathTo
	 * function/method:
	 */
	public static Node lowestAncestor (Node tree, Node n1, Node n2)
		{
		if (n1.equals(n2))
			{
			return n2;
			}
		
		Stack <Node> pathToN1 = pathTo(tree, n1);
		Stack <Node> pathToN2 = pathTo(tree, n2);
		
		if (pathToN1 == null || pathToN2 == null)
			{
			return null;
			}
		
		Node previous = null;
		
		//while both stacks are not empty:
		while (!pathToN1.isEmpty() && !pathToN2.isEmpty())
			{
			Node s = pathToN1.pop( );
			Node t = pathToN2.pop( );
			
			if (s.equals(t))
				{
				previous = s;
				}
			
			else
				{
				break;
				}
			}
		
		System.out.println("LCA: " + previous.data);
		
		return previous;
		}
	
	/**
	 * Returns a stack of nodes that represent the path 
	 * to a given node N, within a tree.
	 */
	public static Stack<Node> pathTo (Node tree, Node n)
		{
		//base case: empty tree:
		if (tree == null)
			{
			return null;
			}
		
		//create a stack once the node N is found:
		if (tree.equals(n))
			{
			Stack<Node> s = new Stack <Node> ( );
			
			s.push(tree);
			
			return s;
			}
		
		Stack<Node> left = pathTo (tree.left, n);
		Stack<Node> right = pathTo (tree.right, n);
		
		if (left != null)
			{
			left.push(tree);
			return left;
			}
		
		if (right != null)
			{
			right.push(tree);
			return right;
			}
		
		return null;
		}
	
	
	/**
	 * Main/Begin Execution:
	 */
	public static void main(String[] args) 
		{
		/******************************** 
		Input : 
		        1
		      /   \
		     2     3
		    / \   / \
		   4   5 6   7
		         
		 *********************************/
		
		Node root = new Node (1);
		
		root.left = new Node (2);
		root.left.left = new Node (4);
		root.left.right = new Node (5);
		
		root.right = new Node (3);
		root.right.left = new Node (6);
		root.right.right = new Node (7);
		
		lowestAncestor(root,root.left.left, root.right);
		} 

	}
