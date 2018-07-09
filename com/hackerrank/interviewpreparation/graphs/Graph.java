package com.hackerrank.interviewpreparation.graphs;

import java.util.List;

public interface Graph<V> {
	
	boolean isAdjacent(V suposedAdjacent, V target);
	List<V> adjacentes(V target);
	void addVertex(V v);
	V removeVertex(V v);
	void addEdge(V source, V adjacent );
	
	boolean hasPathDfs(V source, V destination);
	boolean hasPathBfs(V source, V destination);
	
}
