package datastructure;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//QueueUsingArray queue = new QueueUsingArray();
		QueueUsingll<Integer> queue = new QueueUsingll<>();
		int arr[] = {10,20,30,40,50};
		for(int i : arr) {
			//try {
				queue.enqueue(i);
			//}//catch(QueueFullException e){
				//we will never reached here
			//}
		}
		
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			}catch(QueueEmptyException e) {
		
			 }
		}
		
	}

}
