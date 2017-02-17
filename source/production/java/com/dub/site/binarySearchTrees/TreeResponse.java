package com.dub.site.binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class TreeResponse {
	
	private Type type;
	
	private List<List<List<Integer>>> treeArray;
	
	private List<Integer> keys;
	
	public TreeResponse() {
		treeArray = new ArrayList<List<List<Integer>>>();
	}
	
	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public List<List<List<Integer>>> getTreeArray() {
		return treeArray;
	}


	public void setTreeArray(List<List<List<Integer>>> treeArray) {
		this.treeArray = treeArray;
	}

	
	public List<Integer> getKeys() {
		return keys;
	}


	public void setKeys(List<Integer> keys) {
		this.keys = keys;
	}


	public static enum Type {
		
		OK, FOUND, NOT_FOUND, FORBIDDEN, NODE_PRESENT, CREATED, ERROR
		
	}
}
