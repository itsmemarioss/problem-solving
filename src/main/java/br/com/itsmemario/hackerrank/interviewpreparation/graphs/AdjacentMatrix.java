package br.com.itsmemario.hackerrank.interviewpreparation.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AdjacentMatrix implements Graph<Integer>{

	private int[][] matrix;
	private int size;
	
	public AdjacentMatrix(int size) {
		this.size = size;
		matrix = new int[size][size];
	}

	@Override
	public boolean isAdjacent(Integer suposedAdjacent, Integer target) {
		return matrix[target][suposedAdjacent]>0;
	}

	@Override
	public List<Integer> adjacentes(Integer target) {
		if(target>matrix.length-1) {
			throw new IllegalArgumentException("There is no such node");
		}
		
		List<Integer> neighbors = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[target][i]>0)
				neighbors.add(i);
		}
		
		return neighbors;
	}

	@Override
	public void addVertex(Integer v) {}

	@Override
	public Integer removeVertex(Integer v) {
		return null;
	}
	
	@Override
	public void addEdge(Integer source, Integer adjacent) {
		matrix[source][adjacent]=1;
	}

	@Override
	public boolean hasPathDfs(Integer source, Integer destination) {
		HashSet<Integer> visited = new HashSet<>();
		return hasPathDfs(source, destination, visited);
	}

	private boolean hasPathDfs(Integer source, Integer destination, HashSet<Integer> visited) {
		
		if(visited.contains(source)) {
			return false;
		}
		
		visited.add(source);

		if(source.equals(destination)) {
			return true;
		}
		
		for (Integer node : adjacentes(source)) {
			if(hasPathDfs(node, destination, visited)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean hasPathBfs(Integer source, Integer destination) {
		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> nextToVisit = new LinkedList<>();
		nextToVisit.add(source);
		
		while(!nextToVisit.isEmpty()) {
			Integer currentNode = nextToVisit.remove();
			if(visited.contains(currentNode)) {
				continue;
			}
			
			visited.add(currentNode);

			if(currentNode.equals(destination)) {
				return true;
			}
			nextToVisit.addAll(adjacentes(currentNode));
		}			
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}


}
