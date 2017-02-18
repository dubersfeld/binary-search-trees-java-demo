package com.dub.site.binarySearchTrees;

import java.io.Serializable;

/** Here T is the payload class */

public interface Node<T extends Serializable> {
	
	public int getmKey();

	public void setmKey(int mKey);
	
	public Node<T> getmLeft();

	public void setmLeft(Node<T> mLeft);

	public Node<T> getmRight();

	public void setmRight(Node<T> mRight);

	public Node<T> getmParent();

	public void setmParent(Node<T> mParent);
	
	public T getmData();
	
	public void setmData(T data);
	  
} 