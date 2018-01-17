package com.sydney.sample.graph.entity;

import java.util.Iterator;

public interface VertexInterface<T> {
	
	public Iterator<VertexInterface<T>> getNeighborIterator();
	
	public boolean isVisited();
	
	public void unVisit();
	
	public boolean hasPredecessor();
	
	public VertexInterface<T> getPredecessor();
	
	public boolean connect(VertexInterface<T> endVertex,double edgeWeight);
	
	public VertexInterface<T> getUnvisitedNeighbor();

}
