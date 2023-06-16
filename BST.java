package datastructure;

public class BST {
	private BinaryTreeNode<Integer> root;
	private int Size;
	private boolean isPresentHelper(BinaryTreeNode<Integer> node , int x) {
		if(node == null) {
			return false;
		}
		if(node.data == x) {
			return true;
		}
		
		if(x < node.data) {
			isPresentHelper(node.left,x);
		}
		else {
			isPresentHelper(node.right,x);
		}
		return false;
	}
	
	public boolean isPresent(int x) {
		
		return isPresentHelper(root,x);
	}
	private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node,int x){
		if(node == null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
			return newRoot;
		}
		
		
		if(x >= node.data) {
			node.right = insert(node.right,x);
		}else {
			node.left = insert(node.left,x);
		}
		return node;
	}
	
	public void insert(int x) {
		
		root = insert(root,x);
		
	}

	public boolean deleteData(int x) {
		BSTDeleteReturn output = deleteDataHelper(root,x);
		root = output.root;
		if(output.deleted) {
			Size--;
		}
		return output.deleted;
		
	}
	private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root ,int x) {
		
		if(root == null) {
			return new BSTDeleteReturn(null , false);
		}
		if(root.data < x) {
			BSTDeleteReturn outputRight = deleteDataHelper(root.right,x);
			root.right = outputRight.root;
			outputRight.root = root;
			return outputRight;
		}
		if(root.data > x) {
			BSTDeleteReturn outputLeft = deleteDataHelper(root.left,x);
			root.left = outputLeft.root;
			outputLeft.root = root;
			return outputLeft;
		}
		if(root.left == null && root.right == null) {
			return new BSTDeleteReturn(null,true);
		}
		if(root.left != null && root.right == null) {
			return new BSTDeleteReturn(root.left,true);
		}
		if(root.left == null && root.right != null) {
			return new BSTDeleteReturn(root.right,true);
		}
		int rightMax = minimum(root.right);
		root.data = rightMax;
		BSTDeleteReturn outputRight = deleteDataHelper(root.right,rightMax);
		root.right = outputRight.root;
		return new BSTDeleteReturn(root,true);
	}
	
	
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		return Math.min(root.data , Math.min(leftMin, rightMin));
	}
	
	
	
	
	public int size() {
		return Size;
	}
	
	
	
	private static void printTreeHelper(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+":");
		if(root.left != null) {
			System.out.print("L"+ root.left.data +",");
		}
		if(root.right != null) {
			System.out.print("R"+ root.right.data );
		}
		System.out.println();
		
		
		printTreeHelper(root.left);
		printTreeHelper(root.right);
	}
	
	public void printTree() {
	printTreeHelper(root);
		
	}
}
