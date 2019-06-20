package com.dub.spring.binarySearchTrees;

import org.springframework.stereotype.Service;

@Service
public class DisplayNodeFactory extends NodeFactory<Geometry> {

	@Override
	public DisplayNode build(int key) {
		return new DisplayNode(key);
	}

	@Override
	public DisplayNode build(int key, Geometry data, Node<Geometry> left, Node<Geometry> right, Node<Geometry> parent) {
		return new DisplayNode(key, data, left, right, parent);
	}

}

