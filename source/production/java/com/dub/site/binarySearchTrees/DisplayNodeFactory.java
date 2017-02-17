package com.dub.site.binarySearchTrees;

import org.springframework.stereotype.Service;

@Service
public class DisplayNodeFactory extends NodeFactory<DisplayNode> {

	@Override
	public DisplayNode build(int key) {
		return new DisplayNode(key);
	}

	@Override
	public DisplayNode build(int key, String data, DisplayNode left, DisplayNode right, DisplayNode parent) {
		return new DisplayNode(key, data, left, right, parent);
	}

}

