package com.dub.site.binarySearchTrees;

import java.io.Serializable;

/** Here T is the payload class */

public interface Node<T extends Serializable> {
	
	public int getKey();

	public void setKey(int key);
	
	public Node<T> getLeft();

	public void setLeft(Node<T> left);

	public Node<T> getRight();

	public void setRight(Node<T> right);

	public Node<T> getParent();

	public void setParent(Node<T> parent);
	
	public T getData();
	
	public void setData(T data);
	  
} 