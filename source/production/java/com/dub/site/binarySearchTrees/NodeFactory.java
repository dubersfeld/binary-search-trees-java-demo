package com.dub.site.binarySearchTrees;

public abstract class NodeFactory<T extends Node> {
	
	abstract public T build(int key);	
	
	abstract public T build(int key, String data, T left, T right, T parent);
}

