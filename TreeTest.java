package datastructure;
import java.util.*;
public class TreeTest {
	
	
	public static void printTree(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + ": ");
		for(int i = 0;i < root.childern.size() ; i++) {
			System.out.print(root.childern.get(i).data+" ");
		}
		System.out.println();
		for(int i = 0;i < root.childern.size() ; i++) {
			TreeNode<Integer> child = root.childern.get(i);
			printTree(child);
		}
	}
		
	
	public static int numberOfNode(TreeNode<Integer> root) {
		int count = 1;
		for(int i = 0; i< root.childern.size() ;i++) {
			int childCount = numberOfNode(root.childern.get(i));
			count += childCount;
		}
		return count;
	}
	
	public static TreeNode<Integer> takeInput()throws QueueEmptyException{
		Scanner s= new Scanner(System.in);
		QueueUsingll<TreeNode<Integer>> pendingNodes = new QueueUsingll<>();
		System.out.println("enter the root data : ");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<>(rootData);
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> front = pendingNodes.dequeue();
			System.out.println("enter the number of children for : " + front.data);
			int numChild = s.nextInt();
			for(int i =0 ; i < numChild ; i++) {
				System.out.println("entre the "+ i + "th child data for:" + front.data );
				int childData = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<>(childData);	
				front.childern.add(childNode);
				pendingNodes.enqueue(childNode);
			}
		}
		return root;
		
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(2);
//		TreeNode<Integer> node2 = new TreeNode<>(3);
//		TreeNode<Integer> node3 = new TreeNode<>(1);
//		TreeNode<Integer> node4 = new TreeNode<>(5);
//		TreeNode<Integer> node5 = new TreeNode<>(6);
//		root.childern.add(node1);
//		root.childern.add(node2);
//		root.childern.add(node3);
//		
//		node2.childern.add(node4);
//		node2.childern.add(node5);
//		System.out.println(numberOfNode(root));
		TreeNode<Integer> root = takeInput();
		printTree(root);
	}

}
