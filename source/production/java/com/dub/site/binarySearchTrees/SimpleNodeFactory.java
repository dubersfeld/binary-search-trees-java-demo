package com.dub.site.binarySearchTrees;

public class SimpleNodeFactory extends NodeFactory<SimpleNode> {

	@Override
	public SimpleNode build(int key) {
		return new SimpleNode(key);
	}

	@Override
	public SimpleNode build(int key, String data, SimpleNode left, SimpleNode right, SimpleNode parent) {
		return new SimpleNode(key, data, left, right, parent);
	}

}

