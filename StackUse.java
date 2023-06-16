package datastructure;

public class StackUse {

	public static void main(String[] args)throws StackEmptyException , StackFullException {
		// TODO Auto-generated method stub
		
		StackUsingArray stack = new StackUsingArray();
		int arr [] = {1,2,3,4,9};
		for(int i = 0 ; i < arr.length ; i++) {
			stack.push(arr[i]);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
//		stack.push(10);
//		System.out.println(stack.top());
//		stack.top();
//		stack.pop();
//		stack.size();
//		System.out.println(stack.isEmpty());
//		stack.isEmpty();
		
	}

}
