package com.sydney.sample.graph.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected class Edge implements Serializable{
		
		private VertexInterface<T> vertex;
		private double weight;
		
		protected Edge(VertexInterface<T> endVertex,double edgeWeight) {
			vertex = endVertex;
			weight = edgeWeight;
		}
		
		public VertexInterface<T> getEndVertex(){
			return vertex;
		}
		
		public double getWeight() {
			return weight;
		}
		
	}
	
	private class NeighborIterator implements Iterator<VertexInterface<T>> {
		
		Iterator<Edge> edgesIterator;
		
		
		private  NeighborIterator() {
			edgesIterator = edgeList.iterator();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return edgesIterator.hasNext();
		}

		@Override
		public VertexInterface<T> next() {
			VertexInterface<T> nextNeighbor = null;
			if (edgesIterator.hasNext()) {
				Edge edgeToNextNeighbor = edgesIterator.next();
				nextNeighbor = edgeToNextNeighbor.getEndVertex();
			}else {
				throw new NoSuchElementException();
			}
			
			
			return nextNeighbor;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	
	private class WeightIterator implements Iterator{
		
		private Iterator<Edge> edgesIterator;
		
		private WeightIterator() {
			edgesIterator =  edgeList.iterator();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return edgesIterator.hasNext();
		}

		@Override
		public Object next() {
			Double result;
			if (edgesIterator.hasNext()) {
				Edge edge = edgesIterator.next();
				result = edge.getWeight();
			}else {
				throw new NoSuchElementException();
			}
			return result;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	

	private T label;
	private List<Edge> edgeList;
	private boolean visited;
	private VertexInterface<T> previousVertex;
	private double cost;
	
	public T getLabel() {
		return label;
	}
	public void setLabel(T label) {
		this.label = label;
	}
	@Override
	public Iterator<VertexInterface<T>> getNeighborIterator() {
		// TODO Auto-generated method stub
		return new NeighborIterator();
	}
	@Override
	public boolean isVisited() {
		// TODO Auto-generated method stub
		return visited;
	}
	
	
	@Override
	public boolean hasPredecessor() {
		// TODO Auto-generated method stub
		return this.previousVertex!=null;
	}
	@Override
	public VertexInterface<T> getPredecessor() {
		// TODO Auto-generated method stub
		return this.previousVertex;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	public Vertex(T vertexLabel) {
		label = vertexLabel;
		edgeList = new LinkedList<>();
		visited = false;
		previousVertex = null;
		cost = 0;
	}
	@Override
	public void unVisit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		boolean result = false;
		
		if(!this.equals(endVertex)) {
			Iterator<VertexInterface<T>> neighbors = this.getNeighborIterator();
			boolean duplicateEdge = false;
			while (!duplicateEdge&&neighbors.hasNext()) {
					VertexInterface<T> nextNeighbor = neighbors.next();
					
					if(endVertex.equals(nextNeighbor)) {
						duplicateEdge = true;
						break;
					}
				
			}
			
			if (!duplicateEdge) {
				edgeList.add(new Edge(endVertex, edgeWeight));
				result = true;
			}
		}
		
		// TODO Auto-generated method stub
		return result;
	}
	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {
		VertexInterface<T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		while(neighbors.hasNext()&&result==null) {
			VertexInterface<T> nextNeighbor = neighbors.next();
			if (!nextNeighbor.isVisited()) {
				result = nextNeighbor;
			}
		}
		// TODO Auto-generated method stub
		return result;
	}
	
	
	public boolean equals(Object other) {
		boolean result = false;
		if ((other==null)||(getClass()!=other.getClass())) {
			return result;
		}else {
			Vertex<T> otherVertex = (Vertex<T>) other;
			result = label.equals(otherVertex.label);
		}
		
		return result;
		
	}

}
