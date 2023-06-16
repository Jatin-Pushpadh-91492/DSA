package datastructure;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20); // adds in the end of the list
		arr.add(30);
		arr.add(1,80);
		
		for(int i = 0; i < arr.size();i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
		for(int i : arr) {
			System.out.print(i+" ");
		}
//		arr.set(0, 100);
//		arr.remove(2);
//		Integer i = 10;
//		arr.remove(i);
//		System.out.println(arr.size());
//		System.out.println(arr.get(1));
//		System.out.println(arr.get(1));
	}

}