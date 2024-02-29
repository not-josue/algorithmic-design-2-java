/*
 * An example of a Generic Binary Search Tree.
 * Written By: Josue
 */
public class LinkedBST<T extends Comparable<T>>
{
	// private internal class

	private class Node
	{
		T data;
		Node leftChild;
		Node rightChild;

		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}

	// references

	private Node root; // head

	// constructor

	public LinkedBST()
	{
		root = null;
	}

	// methods

	/**
	 * Adds a Node to the Tree. If the Tree is empty, it associates the Root
	 * Node with the given data, else it recursively calls an add method.
	 * 
	 * @param aData
	 *            the data to add to the Tree
	 */
	public void add(T aData)
	{
		// empty tree
		if (root == null) root = new Node(aData);
		else add(root, aData);
	}

	/**
	 * Recursively adds a Node by comparing the given data with existing Nodes.
	 * 
	 * @param aNode
	 *            called by starting at the root Node, then by left or right
	 *            child Nodes
	 * @param aData
	 *            the data to add to the Tree
	 * @return the new Node to add to the Tree
	 */
	private Node add(Node aNode, T aData)
	{
		// halting condition: reached a leaf
		if (aNode == null) aNode = new Node(aData);
		// node exists, compare data to it
		else
			if (aData.compareTo(aNode.data) < 0) // go left
				aNode.leftChild = add(aNode.leftChild,
						aData);
			else
				if (aData.compareTo(aNode.data) > 0) // go right
					aNode.rightChild = add(aNode.rightChild,
							aData);
		return aNode;
	}

	// depth-first preorder

	/**
	 * Calls a recursive method, that uses a Stack Based Depth-First Pre-Order
	 * approach, to print all Nodes in the Tree.
	 */
	public void printPreorder()
	{
		printPreorder(root);
	}

	/**
	 * Recursively prints all Nodes in the Tree using a Stack Based Depth-First
	 * Pre-Order approach. If the current Node is empty, signaling a leaf or an
	 * empty tree, no action is taken. This approach prints the root Node first,
	 * then prints the left half of the Tree followed by the right half of the
	 * Tree.
	 * 
	 * @param aNode
	 *            the Node to print
	 */
	private void printPreorder(Node aNode)
	{
		if (aNode == null) return; // leaf or empty tree
		System.out.println(aNode.data); // process
		printPreorder(aNode.leftChild); // left
		printPreorder(aNode.rightChild); // right
	}

	// depth-first inorder
	// prints in ascending order

	/**
	 * Calls a recursive method, that uses a Stack Based Depth-First In-Order
	 * approach, to print all Nodes in the Tree. This approach results in
	 * printing the Tree in ascending order.
	 */
	public void printInorder()
	{
		printInorder(root);
	}

	/**
	 * Recursively prints all Nodes in the Tree using a Stack Based Depth-First
	 * In-Order approach. If the current Node is empty, signaling a leaf or an
	 * empty tree, no action is taken. This approach follows the left path until
	 * a leaf is found which results in the smallest value being printed first,
	 * then returning and printing the parent, followed by printing the right
	 * child. The outcome is the Tree being printed in ascending order.
	 * 
	 * @param aNode
	 *            the Node to print
	 */
	private void printInorder(Node aNode)
	{
		if (aNode == null) return; // leaf or empty tree
		printInorder(aNode.leftChild); // left
		System.out.println(aNode.data); // process
		printInorder(aNode.rightChild); // right
	}

	/**
	 * Calls a recursive search method to find an occurrence of given data.
	 * 
	 * @param aData
	 *            the data to compare
	 * @return true if there is an occurrence of the given data, false otherwise
	 */
	public boolean search(T aData)
	{
		return search(root, aData);
	}

	/**
	 * Recursively searches for an occurrence of given data by comparing the
	 * given data with each Node's data.
	 * 
	 * @param aNode
	 *            first used as the starting Node, root, then used recursively
	 *            on the left and right child Nodes
	 * @param aData
	 *            the data to compare
	 * @return true if the given data, and a Node's data are equal, false
	 *         otherwise
	 */
	private boolean search(Node aNode, T aData)
	{
		if (aNode == null) return false; // leaf or empty tree
		else
			if (aData.compareTo(aNode.data) < 0) // go left
				return search(aNode.leftChild, aData);
			else
				if (aData.compareTo(aNode.data) > 0) // go right
					return search(aNode.rightChild, aData);
				else // equal
					return true;
	}

	/**
	 * Calls a recursive remove method to delete a Node that matches the given
	 * data and updates the root reference accordingly.
	 * 
	 * @param aData
	 *            the data to compare
	 */
	public void remove(T aData)
	{
		// update root's reference if it were removed
		root = remove(root, aData);
	}

	/**
	 * Recursively removes a Node if its data matches the given data. Traverses
	 * all Nodes searching for a match, and updates parent and child Nodes
	 * accordingly.
	 * 
	 * @param aNode
	 *            first used as the starting Node, root, then used recursively
	 *            on the left and right child Nodes
	 * @param aData
	 *            the data to compare
	 * @return the child Node or null to assign to the removed Node
	 */
	private Node remove(Node aNode, T aData)
	{
		// find the node
		if (aNode == null) return null; // value not found
		else
			if (aData.compareTo(aNode.data) < 0) // go left
				aNode.leftChild = remove(aNode.leftChild,
						aData);
			else
				if (aData.compareTo(aNode.data) > 0) // go right
					aNode.rightChild = remove(
							aNode.rightChild, aData);
				else // found it
		{
			// examine how many children that node has
			if (aNode.rightChild == null) // left child could exist or be null
				return aNode.leftChild;
			else
				if (aNode.leftChild == null)
					return aNode.rightChild;
			// two children
			Node temp = findMinInTree(aNode.rightChild);
			// replace data with smallest
			aNode.data = temp.data;
			// remove duplicate
			aNode.rightChild = remove(aNode.rightChild,
					temp.data);
		}

		return aNode;
	}

	/**
	 * Finds the smallest value Node down the right path of the Node to be
	 * removed.
	 * 
	 * @param aNode
	 *            the right child of the Node to be removed
	 * @return a Node that represents the smallest value on the right path of
	 *         the Node to be removed, or null if a leaf is found
	 */
	private Node findMinInTree(Node aNode)
	{
		if (aNode == null) return null;
		else if (aNode.leftChild == null) return aNode; // indicates that the
														// given node is the
														// smallest
		else return findMinInTree(aNode.leftChild);
	}

}
