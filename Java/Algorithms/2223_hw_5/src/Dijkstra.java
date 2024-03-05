import java.util.Scanner;

public class Dijkstra {
	
	public static void dij(int[][] graph, int start, int end) {

		int[] totalPathLength = new int[graph.length];
		boolean[] shrtstPthFnd = new boolean[graph.length];
		String[] edges = new String[graph.length];
		
		for(int i = 0; i < graph.length; i++) {
			totalPathLength[i] = 999999;
			shrtstPthFnd[i] = false;
		}
		
		totalPathLength[start] = 0;
		edges[start] = "0";
			
		for(int i = 0; i < graph.length; i++) {
			int smollest = 999999;
			int cNode = -1;
			for(int j = 0; j < totalPathLength.length; j++) {
			
				if(totalPathLength[j] < smollest)
					if(shrtstPthFnd[j] == false) {
						smollest = totalPathLength[j];
						cNode = j;
					}
			}
				
			shrtstPthFnd[cNode] = true;
			for(int k = 0; k < graph.length; k++) {
				
				if(shrtstPthFnd[k] == false) {
					if(graph[cNode][k] != 0) {
						int l = totalPathLength[cNode] + graph[cNode][k];
						if(l < totalPathLength[k]) {
							totalPathLength[k] = l;
							edges[k] = (edges[cNode] + " + " + graph[cNode][k]);
						}
					}
				}		
			}
		}
			System.out.println("Path from " + start + " to " + end + ": " + edges[end] + " = " + totalPathLength[end]);
	}
	
	public static void main (String[] args) {
		
		int[][] graph = {{0, 53, 10, 12, 0, 0, 0, 0, 0, 0},
				{53, 0, 33, 0, 2, 0, 101, 0, 0, 0},
				{10, 33, 0, 9, 30, 18, 0, 0, 0, 0},
				{12, 0, 9, 0, 0, 17, 0, 0, 6, 0},
				{0, 2, 30, 0, 0, 14, 123, 122, 0, 0},
				{0, 0, 18, 17, 14, 0, 0, 137, 7, 0},
				{0, 101, 0, 0, 123, 0, 0, 8, 0, 71},
				{0, 0, 0, 0, 122, 137, 8, 0, 145, 66},
				{0, 0, 0, 6, 0, 7, 0, 145, 0, 212},
				{0, 0, 0, 0, 0, 0, 71, 66, 212, 0}};
		
		Scanner in = new Scanner(System.in);
		System.out.println("source node? (0-9)");
		int start = in.nextInt();
		System.out.println("destination node? (0-9)");
		int end = in.nextInt();
		
		dij(graph,start,end);
		System.out.println("Easter Egg: The letters associated with each node can be rearranged to spell DIJKSTRA NM. DIJKSTRA as in");System.out.println("	    Dijkstra's algorithm, and NM as in n/m, the load factor for a hash table.");
		
	}
}
