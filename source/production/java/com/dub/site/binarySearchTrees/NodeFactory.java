package com.dub.site.binarySearchTrees;

import java.io.Serializable;

public abstract class NodeFactory<T extends Serializable> {
	
	abstract public Node<T> build(int key);	
	
	abstract public Node<T> build(int key, T data, Node<T> left, Node<T> right, Node<T> parent);
}

