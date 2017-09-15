package com.test.ds;

public class BSTree {

	private static BSTNode root;

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private BSTNode insert(BSTNode node, int data) {
		if (node == null) {
			node = new BSTNode(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		
		return node;
	}
	
	public boolean search(int data) {
		boolean found = search(root,data);
		return found;
	}

	private boolean search(BSTNode node, int data) {
		boolean found = false;
		while((node != null) && !found ){
			int val = node.data;
			if(data < val) {
				node = node.left;
			} else if(data > val) {
				node= node.right;
			} else {
				found = true;
				break;
			}
			found = search(node, data);
			
		}
		return found;
	}
	
	public void delete(int val){
		
		if(!search(val)) {
			System.out.println(" value is not found : " + val);
		} else {
			root = delete(root,val);
		}
	}

	private BSTNode delete(BSTNode node, int val) {
        
		return null;
	}

	private void inorder(BSTNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	class BSTNode {

		BSTNode left;
		BSTNode right;
		int data;

		BSTNode(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}

	}

	public static void main(String[] args) {
		BSTree bst = new BSTree();
		bst.insert(34);
		bst.insert(20);
		bst.insert(45);
		bst.insert(10);
		bst.insert(32);

		bst.inorder(root);
		
		System.out.println("search element there : " + bst.search(36));

	}

}
