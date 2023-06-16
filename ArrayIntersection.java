package datastructure;

import java.util.*;

public class ArrayIntersection {
	
	public static ArrayList<Integer> arrayIntersection(int [] arr1 , int arr2 []){
		HashMap<Integer,Integer> map= new HashMap<>();
		
		for(int i = 0 ; i < arr1.length ; i++) {
			if(map.containsKey(arr1[i])) {
				int value = map.get(arr1[i]);
				map.put(arr1[i], value + 1);
			}else {
				map.put(arr1[i], 1);
			}
		}
		
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0 ; i  <arr2.length ; i++) {
			if(map.containsKey(arr2[i])){
				int value = map.get(arr2[i]);
				if(value > 0) {
					result.add(arr2[i]);
					map.put(arr2[i], value - 1);
				}
			}
			
		}
		Collections.sort(result);
		return result;
	}
	
	

	public static void main(String[] args) {
		
		int arr1[] = {1,3,2,2,3,6,2,5};
		int arr2[] = {2,4,2,3,5,6,6};
		ArrayList<Integer> result = arrayIntersection(arr1,arr2);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

}
