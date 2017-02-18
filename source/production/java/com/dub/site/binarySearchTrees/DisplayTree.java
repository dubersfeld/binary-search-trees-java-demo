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
        if (mRoot == null) {
            return true;        
        }
        
        Queue<Node<Geometry>> queue = new Queue<>();
        Node<Geometry> node;
            
        mRoot.getmData().setDepth(0);
        mRoot.getmData().setIndex(0); 
              
        queue.push_back(mRoot);
        
        results.clear();
           
        for (int i = 0; i < 5; i++) {
            results.add(new ArrayList<List<Integer>>());
        }
        
        while (!queue.isEmpty()) {
            node = queue.pop_front();
                 
            // update node depth and index attributes
            if (node.getmParent() != null) {// not root
                node.getmData().setDepth( node.getmParent().getmData().getDepth() + 1 );                     
                if (node.getmData().getDepth() > 4) {
                    return false;         
                }    
                if ( node == node.getmParent().getmLeft() ) {// left child
                    node.getmData().setIndex(2 * node.getmParent().getmData().getIndex());
                } else {// right child
                    node.getmData().setIndex(2 * node.getmParent().getmData().getIndex() + 1);
                }// if
            }// if             
            if (node.getmParent() != null) {// not root
            	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(
            														node.getmData().getIndex(), 
            														node.getmKey(), 
            														node.getmParent().getmData().getIndex()));
              
            	results.get(node.getmData().getDepth()).add(list);
            } else {
            	// root         	
            	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(
																	node.getmData().getIndex(), 
																	node.getmKey() 
																));
            	results.get(node.getmData().getDepth()).add(list);
            }// if    
    
            if (node.getmLeft() != null) {
                queue.push_back(node.getmLeft());
            }
            if (node.getmRight() != null) {
                queue.push_back(node.getmRight());
            } 
                   
        }// while
        
        return true;    
    }// breadthFirstWalk
     

	/** additional method required for insertion */
	public String checkInsert(int key, List<List<List<Integer>>> results) 
	{
        // first search for key
        if (search(mRoot, key) != null) {// key already present
        	
          	results = new ArrayList<>();
          	return "NP";
        } else {// key not found    	
            // first save a local copy of the tree 
    		DisplayTree treeSave = new DisplayTree(this, nodeFactory);
    	
    		treeSave.inOrderWalk(treeSave.getmRoot());// debug only
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
		Node<Geometry> node = search(mRoot, key);
		
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

   