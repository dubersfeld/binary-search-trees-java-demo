package com.dub;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.dub.site.binarySearchTrees.DisplayNodeFactory;
import com.dub.site.binarySearchTrees.DisplayTree;
import com.dub.site.binarySearchTrees.DisplayNode;


public class DisplayBSTTestJunit {

	@Test
	public void testAdd() {
		
		DisplayNodeFactory nodeFactory = new DisplayNodeFactory();
		
		DisplayTree tree = new DisplayTree(nodeFactory);
		
		DisplayNode n1 = nodeFactory.build(15);
		DisplayNode n2 = nodeFactory.build(42);
		DisplayNode n3 = nodeFactory.build(77);
		DisplayNode n4 = nodeFactory.build(33);
		DisplayNode n5 = nodeFactory.build(19);
		DisplayNode n6 = nodeFactory.build(25);
		DisplayNode n7 = nodeFactory.build(63);
				
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
		
		DisplayTree tree2 = new DisplayTree(tree, nodeFactory);
		
		assertEquals(refList,tree2.inOrderWalk(tree2.getmRoot()));
		
		tree.remove(n2);
		
		List<Integer> refListA = 
				new ArrayList<Integer>(Arrays.asList(15, 19, 25, 33, 63, 77));

		assertEquals(refListA,tree.inOrderWalk(tree.getmRoot()));
		
		assertEquals(refList,tree2.inOrderWalk(tree2.getmRoot()));
		
		tree.copyTree(tree2, nodeFactory);
		
		assertEquals(refList,tree.inOrderWalk(tree.getmRoot()));
		
		List<List<List<Integer>>> results 
		= new ArrayList<List<List<Integer>>>();

		tree.breadthFirstWalk(results);
		
		String refGeo = "[[[0, 15]], [[1, 42, 0]], [[2, 33, 1], [3, 77, 1]], [[4, 19, 2], [6, 63, 3]], [[9, 25, 4]]]";
		
		assertEquals(refGeo,results.toString());
   }
}
