package datastructure;

public class StackUsingArray {
	
	private int data[];
	private int topIndex;//index of the top most element of the
	
	public StackUsingArray() {
		data = new int[2];
		topIndex = -1;
	}
	
	public int size() {
		return topIndex +1;
	}
	
	public boolean isEmpty() {
//		if(topIndex == -1) {
//			return true;
//		}else {
//			return false;
//		}
		return topIndex == -1;
		
	}
	public void push(int elem) { //throws StackFullException {
		if(topIndex == data.length - 1 )  {
//			StackFullException e = new StackFullException();
			//throw e;
			//throw new StackFullException();
			doubleCapacity();
		}
		data[++topIndex] = elem;
	}
	private void doubleCapacity() {
		int temp [] = data;
		data  = new int[2 * temp.length];
		for(int i = 0 ; i < temp.length ; i++) {
			data [i] = temp[i];
		}
		
	}
	
	public int top()throws StackEmptyException{
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		return data[topIndex];
	}
	
	public int pop() throws StackEmptyException{
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}
	

}
