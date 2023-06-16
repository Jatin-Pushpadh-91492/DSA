package datastructure;

import java.util.*;

public class Graphs {
	public static void depthFT(int adjMatrix[][],int currentVertex,boolean visited[]) {
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");
		
		for(int i = 0 ; i < adjMatrix.length ;i++) {
			if(adjMatrix[currentVertex][i]==1 && visited[i] == false) {
				//i is neighbour of currentVertex
				depthFT(adjMatrix,i,visited);
			}
		}
		
	}
	
	public static void depthFT(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix.length];
		for(int i = 0 ; i < adjMatrix.length;i++) {
			if(!visited[i] ){
				depthFT(adjMatrix,i,visited);
				System.out.println();
			}
		}
		
	}
	
	public static void BFS(int adjMatrix[][]) {
		
		Queue<Integer> pendingVertices = new LinkedList<>();
		boolean visited [] = new boolean[adjMatrix.length];
		visited[0] = true;
		pendingVertices.add(0);
		while(!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			System.out.println(currentVertex+" ");
			for(int i = 0;i <adjMatrix.length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
	public static ArrayList<Integer> getPathBFS(int adjMatrix[][],int s,int e){
		Queue<Integer> pendingVertices = new LinkedList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		boolean visited [] = new boolean[adjMatrix.length];
		visited[s] = true;
		pendingVertices.add(s);
		map.put(s,-1);
		boolean pathFound = false;
		while(!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			for(int i = 0;i <adjMatrix.length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
					map.put(i,currentVertex);
					if(i==e) {
						//path found
						pathFound = true;
						break;
					}
				}
			}
		}
		if(pathFound) {
			ArrayList<Integer> path = new ArrayList<>();
			int currentVertex = e;
			while(currentVertex != -1) {
				path.add(currentVertex);
				int parent = map.get(currentVertex);
				currentVertex = parent;
			}
			return path;
		}else {
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		
		int [][] adjMatrix = new int[n][n];
		
		for(int i = 0 ; i < e ; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		int source = s.nextInt();
		int end = s.nextInt();
		ArrayList<Integer> path = getPathBFS(adjMatrix,source,end);
		for(int i : path) {
			System.out.print(i+" ");
		}
//		depthFT(adjMatrix);
//		BFS(adjMatrix);
//		for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < n ; j++) {
//				System.out.print(adjMatrix[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

}
