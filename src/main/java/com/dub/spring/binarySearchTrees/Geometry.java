package com.dub.spring.binarySearchTrees;

import java.io.Serializable;

// POJO

public class Geometry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int depth;
	int index;
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
