package com.dub;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.dub.site.binarySearchTrees.SimpleNode;
import com.dub.site.binarySearchTrees.SimpleNodeFactory;
import com.dub.site.binarySearchTrees.Tree;

public class BSTTestJunit {

	@Test
	public void testAdd() {
		
		SimpleNodeFactory nodeFactory = new SimpleNodeFactory();
		
		Tree<String, SimpleNodeFactory> tree = new Tree<>(nodeFactory);
		
		SimpleNode n1 = nodeFactory.build(15);
		SimpleNode n2 = nodeFactory.build(42);
		SimpleNode n3 = nodeFactory.build(77);
		SimpleNode n4 = nodeFactory.build(33);
		SimpleNode n5 = nodeFactory.build(19);
		SimpleNode n6 = nodeFactory.build(25);
		SimpleNode n7 = nodeFactory.build(63);
				
		tree.insert(n1);
		tree.insert(n2);
		tree.insert(n3);
		tree.insert(n4);
		tree.insert(n5);
		tree.insert(n6);
		tree.insert(n7);
		
		assertNotEquals(null, tree.search(n1, 42));
		
		assertEquals(15, tree.getRoot().getKey());
		
		assertEquals(null,tree.getRoot().getLeft());
		
		assertEquals(42,tree.getRoot().getRight().getKey());
		
		assertEquals(33,n2.getLeft().getKey());
		
		assertEquals(77,n2.getRight().getKey());
		
		assertEquals(19,n4.getLeft().getKey());
		
		assertEquals(null,n4.getRight());
		
		assertEquals(25,n5.getRight().getKey());
		
		List<Integer> refList = 
						new ArrayList<Integer>(Arrays.asList(15, 19, 25, 33, 42, 63, 77));
				
		assertEquals(refList, tree.inOrderWalk(tree.getRoot()));
		
		Tree<String, SimpleNodeFactory> tree2 
		= new Tree<>(tree, nodeFactory);	

		assertEquals(refList,tree2.inOrderWalk(tree2.getRoot()));
		
		tree.remove(n2);
		
		List<Integer> refListA = 
				new ArrayList<Integer>(Arrays.asList(15, 19, 25, 33, 63, 77));

		assertEquals(refListA,tree.inOrderWalk(tree.getRoot()));
		
		assertEquals(refList,tree2.inOrderWalk(tree2.getRoot()));
		
   }
}