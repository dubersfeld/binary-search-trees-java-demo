package com.dub.site.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayTree extends Tree<Geometry, DisplayNodeFactory> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<List<Integer>> results;
	
	
	public DisplayTree(Node<Geometry> root, DisplayNodeFactory nodeFactory) {
		super(root, nodeFactory);    
	}
  
	public DisplayTree(DisplayNodeFactory nodeFactory) {	
		super(nodeFactory);
		this.nodeFactory = nodeFactory;
	}
	     
	// copy constructor needed
	public DisplayTree(DisplayTree rhs, DisplayNodeFactory nodeFactory) {	
		super(rhs, nodeFactory);
	}
	       
	    
	public List<List<Integer>> getResults() {
		return results;
	}

		
	public void setResults(List<List<Integer>> results) {	
		this.results = results;
	}
	       
    public boolean breadthFirstWalk(List<List<List<Integer>>> results) 
    {
        if (root == null) {
            return true;        
        }
        
        Queue<Node<Geometry>> queue = new Queue<>();
        Node<Geometry> node;
            
        root.getData().setDepth(0);
        root.getData().setIndex(0); 
              
        queue.push_back(root);
        
        results.clear();
           
        for (int i = 0; i < 5; i++) {
            results.add(new ArrayList<List<Integer>>());
        }
        
        while (!queue.isEmpty()) {
            node = queue.pop_front();
                 
            // update node depth and index attributes
            if (node.getParent() != null) {// not root
                node.getData().setDepth( node.getParent().getData().getDepth() + 1 );                     
                if (node.getData().getDepth() > 4) {
                    return false;         
                }    
                if ( node == node.getParent().getLeft() ) {// left child
                    node.getData().setIndex(2 * node.getParent().getData().getIndex());
                } else {// right child
                    node.getData().setIndex(2 * node.getParent().getData().getIndex() + 1);
                }// if
            }// if             
            if (node.getParent() != null) {// not root
            	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(
            														node.getData().getIndex(), 
            														node.getKey(), 
            														node.getParent().getData().getIndex()));
              
            	results.get(node.getData().getDepth()).add(list);
            } else {
            	// root         	
            	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(
																	node.getData().getIndex(), 
																	node.getKey() 
																));
            	results.get(node.getData().getDepth()).add(list);
            }// if    
    
            if (node.getLeft() != null) {
                queue.push_back(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.push_back(node.getRight());
            } 
                   
        }// while
        
        return true;    
    }// breadthFirstWalk
     

	/** additional method required for insertion */
	public String checkInsert(int key, List<List<List<Integer>>> results) 
	{
        // first search for key
        if (search(root, key) != null) {// key already present
        	
          	results = new ArrayList<>();
          	return "NP";
        } else {// key not found    	
            // first save a local copy of the tree 
    		DisplayTree treeSave = new DisplayTree(this, nodeFactory);
    	
    		treeSave.inOrderWalk(treeSave.getRoot());// debug only
    		// then insert new key
    	    insert(nodeFactory.build(key));
    		boolean allowed = breadthFirstWalk(results);
   
    	    if (!allowed) {
    	    	results = new ArrayList<>();
    	    	// revert to initial state
    	    	this.copyTree(treeSave, nodeFactory); 
                breadthFirstWalk(results);
                return "ND";
    	    } else {
    	    	return "OK";
    	    }
        }
	}
	
	
	/** additional method required for deletion */
	public String checkRemove(int key, List<List<List<Integer>>> results) 
	{
		// first search key
		Node<Geometry> node = search(root, key);
		
		if (node == null) {
			results = new ArrayList<>();
			return "NF";
		} else {
			this.remove(node);
	        breadthFirstWalk(results);
	        return "OK";
		}
	} 
	
}// class

   