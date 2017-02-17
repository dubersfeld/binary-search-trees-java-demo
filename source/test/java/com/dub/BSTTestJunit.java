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
		
		Tree<SimpleNode, SimpleNodeFactory> tree = new Tree<>(nodeFactory);
		
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
		
		assertEquals(15, tree.getmRoot().getmKey());
		
		assertEquals(null,tree.getmRoot().getmLeft());
		
		assertEquals(42,tree.getmRoot().getmRight().getmKey());
		
		assertEquals(33,n2.getmLeft().getmKey());
		
		assertEquals(77,n2.getmRight().getmKey());
		
		assertEquals(19,n4.getmLeft().getmKey());
		
		assertEquals(null,n4.getmRight());
		
		assertEquals(25,n5.getmRight().getmKey());
		
		List<Integer> refList = 
						new ArrayList<Integer>(Arrays.asList(15, 19, 25, 33, 42, 63, 77));
				
		assertEquals(refList, tree.inOrderWalk(tree.getmRoot()));
		
		Tree<SimpleNode, SimpleNodeFactory> tree2 
		= new Tree<>(tree, nodeFactory);	

		assertEquals(refList,tree2.inOrderWalk(tree2.getmRoot()));
		
		tree.remove(n2);
		
		List<Integer> refListA = 
				new ArrayList<Integer>(Arrays.asList(15, 19, 25, 33, 63, 77));

		assertEquals(refListA,tree.inOrderWalk(tree.getmRoot()));
		
		assertEquals(refList,tree2.inOrderWalk(tree2.getmRoot()));
		
   }
}