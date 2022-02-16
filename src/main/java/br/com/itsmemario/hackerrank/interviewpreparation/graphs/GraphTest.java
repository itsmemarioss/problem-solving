package br.com.itsmemario.hackerrank.interviewpreparation.graphs;

public class GraphTest {
	public static void main(String[] args) {
		Graph<Integer> graph = new AdjacentMatrix(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(4, 3);
		
		graph.addEdge(1, 0);
		graph.addEdge(2, 0);
		graph.addEdge(4, 0);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		
		
		System.out.println(graph);
		System.out.println("Adjacents of 0: "+graph.adjacentes(0));
		
		System.out.println("Breadth First Search find 3 from 0");
		System.out.println("----------------------------------");
		System.out.println(graph.hasPathBfs(0, 3));
		System.out.println("Depth First Search find 3 from 0");
		System.out.println("----------------------------------");
		System.out.println(graph.hasPathDfs(0, 3));
		
		System.out.println("Breadth First Search find 2 from 1");
		System.out.println("----------------------------------");
		System.out.println(graph.hasPathBfs(1, 2));
		System.out.println("Depth First Search find 2 from 1");
		System.out.println("----------------------------------");
		System.out.println(graph.hasPathDfs(1, 2));
	}
}
