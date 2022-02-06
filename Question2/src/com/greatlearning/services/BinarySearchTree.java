package com.greatlearning.services;

public class BinarySearchTree {
	public static class Node {
		int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public Node root = null;
	public Node node = null;

	final int nodeIsInLeftSubtree = 1;
	final int nodeIsInRightSubtree = 2;

	/*
	 * nodePosition can take ONLY two values as a node can either be a left child or
	 * a right child
	 */
	private void convertToSkewedTree(Node node, Node parent, Node grandParent, int nodePosition) {
		if (node == null)
			return;
		Node prevNode = parent;
		Node leftChild = node.left;
		Node rightChild = node.right;
		convertToSkewedTree(leftChild, node, prevNode, nodeIsInLeftSubtree);
		convertToSkewedTree(rightChild, node, prevNode, nodeIsInRightSubtree);
		/*
		 * if this node is in left subtree or right subtree of its parent node, can be
		 * determined by the value of nodePosition
		 */
		if (nodePosition == nodeIsInLeftSubtree) {
			// Entering this block indicates node is in left sub tree
			// If node is in left subtree then, it is needed to perform rotation
			// By performing rotation, we are converting the tree into right skewed tree
			Node desendentNode = node;
			while (desendentNode.right != null)
				desendentNode = desendentNode.right;
			desendentNode.right = parent;
			if (grandParent != null) {
				if (node.data < grandParent.data)
					grandParent.left = parent.left;
				else
					grandParent.right = parent.left;
			} else {
				/*
				 * grandParent is null it means parent node was the root node till now but now,
				 * left child is going to be the root node
				 */
				root = parent.left;
			}
			parent.left = null;
		}
	}

	// this method is for displaying the nodes in ascending order
	public void displayInAscendingOrder() {
		// converting given tree to right skewed tree as BST should not contain any left
		// node
		this.convertToSkewedTree(root, null, null, 0);

		// code for traversing the skewed tree
		Node node = root;
		while (node != null) {
			if (node != root)
				System.out.print(" ");
			System.out.print(node.data);
			node = node.right;
		}
	}

	public void setRootNode(Node node) {
		this.root = node;
	}

}
