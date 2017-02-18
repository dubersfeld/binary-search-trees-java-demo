package com.dub.site.binarySearchTrees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Serializable, S extends NodeFactory<T>> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Node<T> mRoot;// root node
	S nodeFactory;// nodeFactory
	  
    public Tree(Node<T> root, S nodeFactory) {
    	this.mRoot = root;
    	this.nodeFactory = nodeFactory;
    	
    }

    public Tree(S nodeFactory) {
    	this.mRoot = null;
    	this.nodeFactory = nodeFactory;
    }
    
    public Tree(Tree<T,S> rhs, S nodeFactory) {
    	copyTree(rhs, nodeFactory);
    }
    	  
    
	public void copyTree(Tree<T,S> rhs, S nodeFactory) {
    	// deep copy method, breadthFirstWalk based
	
    	Queue<Node<T>> queue = new Queue<>();// rhs side Node not T, always code against interface or abstract class
    	Queue<Node<T>> queueP = new Queue<>();// this side
    	Node<T> x, last;//rhs side
             
    	Node<T> prevC;// this side
    	Node<T> newnode; 


    	if (rhs.mRoot == null) {
    		this.mRoot = null;
    		return;// rhs tree is empty
    	}
    
    	// initial push_back to start
    	queue.push_back(rhs.mRoot);
              
    	last = null;
    	prevC = null;
    	 
    	while (!queue.isEmpty()) {    
    		
    		x = queue.pop_front();
    		 		
    		newnode = nodeFactory.build(x.getmKey());
    		      
    		if (x == rhs.mRoot) {// special case                 
    			mRoot = newnode;
    		} else {
    			if (last.getmParent() != x.getmParent()) {// new parent needed
    				prevC = queueP.front();
    				queueP.pop_front();
    			}                      
    			if (x == x.getmParent().getmLeft()) {// x is a left child
    				prevC.setmLeft(newnode);
    			} else {// x is a right child
    				prevC.setmRight(newnode);               
    			}
                     newnode.setmParent(prevC);       
    		}     
    		if (x.getmLeft() != null) {
    			queue.push_back(x.getmLeft());     
    		}     
    		if (x.getmRight() != null) {
    			queue.push_back(x.getmRight());
    		}      
    		queueP.push_back(newnode);     
    		last = x;// rhs side          
    	}         
    }
   
	public Node<T> getmRoot() {
		return mRoot;
	}

	public void setmRoot(Node<T> mRoot) {
		this.mRoot = mRoot;
	}  
    
	public Node<T> search(Node<T> node, int key) {
        while (node != null && key != node.getmKey()) {
            if (key < node.getmKey()) {
                node = node.getmLeft();
            } else {
                node = node.getmRight();
            }
        }
        return node;            
    }// search
    
	public void insert(Node<T> x) {
      
         Node<T> ptr = null;
         Node<T> ptr1 = mRoot;

         if (mRoot == null) { 
        	 // tree empty
             mRoot = x;
             mRoot.setmParent(null);
             mRoot.setmLeft(null);
             mRoot.setmRight(null);
             return;
         }
   
         while (ptr1 != null) {
        	 // tree not empty
             ptr = ptr1;
             if (x.getmKey() < ptr1.getmKey()) {
                 ptr1 = ptr1.getmLeft();
             } else {
                 ptr1 = ptr1.getmRight();
             }                
         }
         x.setmParent(ptr);
         
         if (x.getmKey() < ptr.getmKey()) {
             ptr.setmLeft(x);
         } else {
             ptr.setmRight(x);
         }
     }// insert
	 
	public void remove(Node<T> pNode) {		
         Node<T> ptr = null;
         if (pNode.getmLeft() == null) {// no left child
             transplant(pNode, pNode.getmRight());
         } else if (pNode.getmRight() == null) {// no right child
             transplant(pNode, pNode.getmLeft()); 
         } else {// both children
             ptr = minimum(pNode.getmRight());// successor of pNode 
             
             if (ptr.getmParent() != pNode) {
                 transplant(ptr, ptr.getmRight());
                 ptr.setmRight(pNode.getmRight()); 
                 ptr.getmRight().setmParent(ptr);
             }
             transplant(pNode, ptr);
             ptr.setmLeft(pNode.getmLeft());
             ptr.getmLeft().setmParent(ptr);
         }
     }// remove


     private Node<T> minimum(Node<T> pNode) {
         while(pNode.getmLeft() != null) {
           pNode = pNode.getmLeft();
         }
         return pNode;
     }// minimum


     private Node<T> maximum(Node<T> pNode) {
         while(pNode.getmRight() != null) {
           pNode = pNode.getmRight();
         }
         return pNode;
     }// maximum
	 
   
     protected Node<T> successor(Node<T> pNode) {
         if (pNode.getmRight() != null) {
             return minimum(pNode.getmRight());
         }
         Node<T> ptr = pNode.getmParent();
         while (ptr != null && pNode == ptr.getmRight())  {
             pNode = ptr; ptr = ptr.getmParent();
         }
         return ptr;        
     }// successor 
     

     protected Node<T> predecessor(Node<T> pNode) {
         if (pNode.getmLeft() != null) {
             return maximum(pNode.getmLeft());
         }
         Node<T> ptr = pNode.getmParent();
         while (ptr != null && pNode == ptr.getmLeft())  {
             pNode = ptr; ptr = ptr.getmParent();
         }
         return ptr;        
     }// predecessor
    
     
     public List<Integer> inOrderWalk(Node<T> x) {
    	 List<Integer> list = new ArrayList<>();
    	 Node<T> pNode = minimum(x);
    	 while (pNode != null) {
    		 list.add(pNode.getmKey());
    		 pNode = successor(pNode);
    		 
    	 }
    	 return list;
     }
         
     /** replace node u by node v in this tree 
      * transplant belongs to Node super class so it should accept Node not T*/
	private void transplant(Node<T> u, Node<T> v) 
    {        
    	if (u.getmParent() == null) {
    		mRoot = v;   
    	 } else if (u == u.getmParent().getmLeft()) {
    		 u.getmParent().setmLeft(v);
    	 } else {
    		 u.getmParent().setmRight(v);
    	 }
          
    	 if (v != null) {    
    		 v.setmParent(u.getmParent()); 
    	 }
    }// transplant
    
}// Tree
