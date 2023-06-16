package datastructure;
import java.util.*;
public class BinaryTreeUse {
	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot , int parentData ,boolean isLeft){
		if(isRoot) {
			System.out.println("enter the root : ");
		}
		else {
			if(isLeft) {
				System.out.println("Enter left child of " + parentData);
			}
			else {
				System.out.println("Enter right child of " + parentData);
			}
		}
		Scanner s=  new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); 
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData , true);
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false , rootData , false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	
	public static int largest(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return -1;
		}
		int largestLeft = largest(root.left);
		int largestRight = largest(root.right);
		return Math.max(root.data, Math.max(largestLeft, largestRight));
		
	}
	
	
	public static BinaryTreeNode<Integer> takeTreeInput(){
		System.out.println("enter the root data");
		Scanner s=  new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); 
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	
	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		//TODO take care of the base case
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
		
		
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}
	
	public static int numLeaves(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return numLeaves(root.left) + numLeaves(root.right);
	}
	
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		//TODO take care of the base case
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
		
		
//		if(root.left != null) {
//			printTree(root.left);
//		}
//		if(root.right != null) {
//			printTree(root.right);
//		}
		
	}
	
	public static void pirntAtDepthK(BinaryTreeNode<Integer> root , int k) {
		if(root == null) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		pirntAtDepthK(root.left , k-1);
		pirntAtDepthK(root.right , k-1);
	}
	
	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			return null;
		}
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}
	public static int  height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return 1 + Math.max(leftHeight,rightHeight);
	}
	public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			int height = 0;
			boolean isBal = true;
			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.height = height;
			ans.isBalanced = isBal;
			return ans;
		}
		BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
		BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(leftOutput.height , rightOutput.height);
		
		if(Math.abs(leftOutput.height - rightOutput.height) > 1){
			isBal = false;
		}
		
		if(!leftOutput.isBalanced || !rightOutput.isBalanced) {
			isBal = false;
		}
		
		BalancedTreeReturn ans = new BalancedTreeReturn();
		ans.height = height;
		ans.isBalanced = isBal;
		return ans;
	}
	
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if(Math.abs( leftHeight - rightHeight) > 1) {
			return false;
		}
		
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);
		return isLeftBalanced && isRightBalanced;
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("enter the root : ");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingChildern = new LinkedList<BinaryTreeNode<Integer>>();
		pendingChildern.add(root);
		
		while(!pendingChildern.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChildern.poll();
			System.out.println("Enter left child of "+front.data);
			int left = s.nextInt();
			if(left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer> (left);
				front.left = leftChild;
				pendingChildern.add(leftChild);
			}
			
			System.out.println("Enter right child of "+front.data);
			int right = s.nextInt();
			if(right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer> (right);
				front.right = rightChild;
				pendingChildern.add(rightChild);
			}
		}
		
		return root;
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		return Math.min(root.data , Math.min(leftMin, rightMin));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftMax = largest(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		int rightMin = minimum(root.right);
		if(rightMin < root.data) {
			return false;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		return isLeftBST && isRightBST;
	}
	
	
	public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root) {
		if(root == null) {
			IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE , Integer.MIN_VALUE , true);
			return ans;
		}
		
		IsBSTReturn leftAns = isBST2(root.left);
		IsBSTReturn rightAns = isBST2(root.right);
		int min = Math.min(root.data,Math.max(leftAns.min , rightAns.min));
		int max = Math.max(root.data,Math.max(leftAns.max , rightAns.max));
		boolean isBST = true;
		if(leftAns.max >= root.data) {
			isBST =false;
		}
		if(leftAns.min < root.data) {
			isBST =false;
		}
		if(!leftAns.isBST) {
			isBST =false;
		}
		
		if(!rightAns.isBST) {
			isBST =false;
		}
		IsBSTReturn ans = new IsBSTReturn(min,max,isBST);
		return ans;
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer> root , int minRange , int maxRange) {
		if(root == null) {
			return true;
		}
		if(root.data < minRange || root.data > maxRange) {
			return false;
		}
		boolean isLeftWithInRange = isBST3(root.left, minRange , root.data - 1);
		boolean isRightWithInRange = isBST3(root.right, root.data , maxRange);
		return isLeftWithInRange && isRightWithInRange ;
	}
	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root , int x){
		if(root == null) {
			return null;
		}
		
		if(root.data == x) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput = nodeToRootPath(root.left,x);
		if(leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = nodeToRootPath(root.right,x);
		if(rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		
		return null;
	}

	public static void main(String[] args) {
		
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		
//		
//		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//		root.left = rootLeft;
//		root.right = rootRight;
//		
//		
//		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//		BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
//		rootLeft.right = twoRight;
//		rootRight.left = threeLeft;
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printTree(root);
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true , 0 ,true);
		ArrayList<Integer> path = nodeToRootPath(root,5);
		if(path == null) {
			System.out.println("notfound");
		}else {
		for(int i : path) {
			System.out.println(i);
		}
		}
//		printTreeDetailed(root);
	//	System.out.println(largest(root));
		//System.out.println(numLeaves(root));
		//printTreeDetailed(removeLeaves(root));
		//pirntAtDepthK(root,2);
//		System.out.println(isBalanced(root));
//		System.out.println(isBST(root));
//		IsBSTReturn ans = isBST2(root);
//		System.out.println(ans.min + " " + ans.max +" "+ ans.isBST);
	}
}
