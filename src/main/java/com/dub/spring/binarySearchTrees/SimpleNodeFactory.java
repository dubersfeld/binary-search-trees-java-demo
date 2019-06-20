package com.dub.spring.binarySearchTrees;

public class SimpleNodeFactory extends NodeFactory<String> {

	@Override
	public SimpleNode build(int key) {
		return new SimpleNode(key);
	}

	@Override
	public SimpleNode build(int key, String data, Node<String> left, Node<String> right, Node<String> parent) {
		return new SimpleNode(key, data, left, right, parent);
	}

}

