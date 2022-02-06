package com.greatlearning.driver;

import com.greatlearning.services.BinarySearchTree;
import com.greatlearning.services.BinarySearchTree.Node;

public class Driver {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.node = new Node(50);
		bst.node.left = new Node(30);
		bst.node.right = new Node(60);
		bst.node.left.left = new Node(10);
		bst.node.right.left = new Node(55);
		bst.setRootNode(bst.node);

		bst.displayInAscendingOrder();
	}

}
