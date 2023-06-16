package datastructure;

import java.util.Scanner;


class DoubleNode{
	Node<Integer> head;
	Node<Integer> tail;
	DoubleNode(){
		
	}
	DoubleNode(Node<Integer> head,Node<Integer> tail){
		this.head = head;
		this.tail = tail;
	}
}

public class LinkedListUse {
	
	public static Node<Integer> createLinkedList() {
		
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);
		n1.next = n2;
//		System.out.println("n1 "+n1+" data "+n1.data + "next" + n1.next);
		n2.next = n3;
//		System.out.println("n2 "+n2+" data "+n2.data + "next" + n2.next);
		n3.next = n4;
//		System.out.println("n3 "+n3+" data "+n3.data + "next" + n3.next);
//		System.out.println("n4 "+n4+" data "+n4.data + "next" + n4.next);
		return n1;
	}
	
	public static void printLinkedList(Node<Integer> head) {
		
		Node<Integer> temp = head;
		
		while(temp != null) {
			
			System.out.print(temp.data+" ");
			temp = temp.next; 
				
			
//			System.out.println(head.next);
//			System.out.println(head.next.data);
//			System.out.println(head.next.next.data);
		}
//		System.out.println("\n");
//		while(head != null) {
//			
//			System.out.print(head.data+" ");
//			head = head.next; 
//		}
		
	}
	
		public static void increment(Node<Integer> head) {
			Node<Integer> temp = head;
//			temp.data++;
			
			while(temp != null) {
				
				System.out.println(temp.data++ +" ");
				temp = temp.next;
				
			}
		}
		
		public static Node<Integer> takeInput(){
			
			Scanner s = new Scanner(System.in);
			int data = s.nextInt();
			
			Node<Integer> head = null,tail =null;;
			
			while(data != -1) {
				
				Node<Integer> currentNode =new Node<Integer>(data);
				if(head == null) {
					// make this node as head Node
					head = currentNode;
					tail = currentNode;
				}else {
//					Node<Integer> tail = head;
//					while(tail.next != null){
//						tail = tail.next;
//					}
//					now tail will refer to last Node
//					connect current node after last node
					tail.next = currentNode;
					tail = currentNode;
					
				}
				
				data = s.nextInt();
			}
			return head;
			
		}
		
		public static Node<Integer> insert(Node<Integer> head, int elem,int pos) {
			Node<Integer> currentNode = new Node<Integer>(elem);
			if(pos == 0) {
				currentNode.next = head;
				return currentNode;
			}else {
				int count = 0;
				Node<Integer> prev = head;
				while(count < pos - 1 && prev != null) {
					count++;
					prev = prev.next;
				}
				if(prev != null) {
				currentNode = prev.next;
				prev.next = currentNode;
				}
				return head;
			}
		}
		public static void printR(Node<Integer> head) {
			if(head==null){
				return;
			}
			System.out.print(head.data+" ");
			printR(head.next);
		}
		
		public static Node<Integer> insertR(Node<Integer>head , int elem, int pos){
			if(head == null && pos > 0) {
				return head;
			}
			if(pos==0) {
				Node<Integer> newNode = new Node<>(elem);
				newNode.next = head;
				return newNode;
			}else {
				Node<Integer> smallerHead = insertR(head.next , elem , pos-1);
				head.next = smallerHead;
				return head;
			}
		}
		
		public static Node<Integer> reverseR(Node<Integer> head){
			if(head == null || head.next == null) {
				return head;
			}
			Node<Integer> smallHead = reverseR(head.next);
			Node<Integer> tail = smallHead;
			while(tail.next != null) {
				tail = tail.next;
			}
			tail.next = head;
			head.next = null;
			return smallHead;
		}
	
	public static DoubleNode reverseRBetter(Node<Integer> head) {//for both ehad and tail of the LinkeList
		DoubleNode ans;
		if(head == null || head.next == null) {
			ans = new DoubleNode();
			ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		//this double node will have both head and tail of the reverse linked list
		DoubleNode smallAns = reverseRBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}
	
	
	public static Node<Integer> reverseRBetter1(Node<Integer> head){
		
		DoubleNode ans = reverseRBetter(head);
		return ans.head;
		
	}
	
	public static Node<Integer> reverseRBest(Node<Integer> head){
		
		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reverseR(head.next);
		Node<Integer> reversedtail = head.next;
		reversedtail.next = head;
		head.next = null;
		return smallHead;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Node<Integer> head = createLinkedList();
		 
		 //increment(head);
		 Node list = takeInput();
//		 head = reverseR(list);
//		 DoubleNode ans= reverseRBetter(list);
//		 list = insertR(list,20,8);
		// head = reverseRBetter1(list);
		 head = reverseRBest(list);
		 printR(head);
//		 printLinkedList(list);
//		 printLinkedList(head);
//		 System.out.println(n1);
//		 System.out.println(n1.data); 
//		 System.out.println(n1.next);
	}

}
