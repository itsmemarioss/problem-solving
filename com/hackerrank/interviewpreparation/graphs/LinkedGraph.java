package com.hackerrank.interviewpreparation.graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkedGraph implements Graph<LinkedGraph.Node>{
	
	private Map<Integer, Node> nodeLookup = new HashMap<>();
	
	public static class Node{
		private Integer id;
		private List<Node> adjacents;
		
		public Node(Integer id) {
			super();
			this.id = id;
			adjacents = new LinkedList<>();
		}

		public void addAdjacent(Node node) {
			if(!adjacents.contains(node))
				adjacents.add(node);			
		}
		
		public boolean isAdjacent(Node adjacent) {
			return adjacents.contains(adjacent);
		}
		
		public  List<Node> getAdjacents(){
			return adjacents;
		}
		
		public Integer getId() {
			return id;
		}
		
		@Override
		public boolean equals(Object obj) {
			if( obj instanceof Node) {
				return id.equals( ((Node) obj).getId() );
			}else {
				return false;
			}
			
		}
	}

	@Override
	public boolean isAdjacent(Node suposedAdjacent, Node target) {
		if(!nodeLookup.containsKey(target.getId())) {
			return false;
		}
		return nodeLookup.get(target.getId()).isAdjacent(suposedAdjacent);
	}

	@Override
	public List<Node> adjacentes(Node target) {
		
		if(nodeLookup.containsKey(target.getId()))
			return nodeLookup.get(target.getId()).getAdjacents();
		else
			return Collections.emptyList();
	}

	@Override
	public void addVertex(Node v) {
		nodeLookup.put(v.getId(), v);		
	}

	@Override
	public Node removeVertex(Node v) {
		return nodeLookup.remove(v.getId());
	}

	@Override
	public void addEdge(Node source, Node adjacent) {
		if(nodeLookup.containsKey(source.getId()) ) {
			nodeLookup.get(source.getId()).addAdjacent(adjacent);
			nodeLookup.put(adjacent.getId(), adjacent);
		}else {
			source.addAdjacent(adjacent);
			nodeLookup.put(source.getId(), source);
			nodeLookup.put(adjacent.getId(), adjacent);
		}
		
	}

	@Override
	public boolean hasPathDfs(Node source, Node destination) {
		HashSet<Integer> visited = new HashSet<>();
		return hasPathDfs(source, destination, visited);
	}

	private boolean hasPathDfs(Node source, Node destination, HashSet<Integer> visited) {
		if(visited.contains(source.id)) {
			return false;
		}
		visited.add(source.id);
		if(source.equals(destination)) {
			return true;
		}
		
		for (Node node : source.adjacents) {
			if(hasPathDfs(node, destination, visited)){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean hasPathBfs(Node source, Node destination) {
		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Node> nextToVisit = new LinkedList<>();
		nextToVisit.add(source);
		
		
		while(!nextToVisit.isEmpty()) {
			Node n = nextToVisit.remove();
			
			if(visited.contains(n.id)) {
				continue;
			}
			
			visited.add(n.id);
			
			if(n.equals(destination)) {
				return true;
			}
			
			nextToVisit.addAll(n.getAdjacents());
			
		}
		
		return false;
	}


		
}