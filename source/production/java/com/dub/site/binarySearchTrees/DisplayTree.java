package com.dub.site.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayTree extends Tree<DisplayNode, DisplayNodeFactory> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<List<Integer>> results;
	
	
	public DisplayTree(DisplayNode root, DisplayNodeFactory nodeFactory) {
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
        
        Queue<DisplayNode> queue = new Queue<DisplayNode>();
        DisplayNode node;
        
        mRoot.setmDepth(0);
        mRoot.setmIndex(0); 
        
        queue.push_back(mRoot);
        
        results.clear();
        
        for (int i = 0; i < 5; i++) {
            results.add(new ArrayList<List<Integer>>());
        }
        
        while (!queue.isEmpty()) {
            node = queue.pop_front();
                 
            // update node depth and index attributes
            if (node.getmParent() != null) {// not root
                node.setmDepth( ((DisplayNode)node.getmParent()).getmDepth() + 1 );                     
                if (node.getmDepth() > 4) {
                    return false;         
                }    
                if ( node == node.getmParent().getmLeft() ) {// left child
                    node.setmIndex(2 * ((DisplayNode)node.getmParent()).getmIndex());
                } else {// right child
                    node.setmIndex(2 * ((DisplayNode)node.getmParent()).getmIndex() + 1);
                }// if
            }// if             
            if (node.getmParent() != null) {// not root
            	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(
            														node.getmIndex(), 
            														node.getmKey(), 
            														((DisplayNode)node.getmParent()).getmIndex()));
              
            	results.get(node.getmDepth()).add(list);
            } else {
            	// root         	
            	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(
																	node.getmIndex(), 
																	node.getmKey() 
																));
            	results.get(node.getmDepth()).add(list);
            }// if    
    
            if (node.getmLeft() != null) {
                queue.push_back((DisplayNode)node.getmLeft());
            }
            if (node.getmRight() != null) {
                queue.push_back((DisplayNode)node.getmRight());
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
		Node node = search(mRoot, key);
		
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

   