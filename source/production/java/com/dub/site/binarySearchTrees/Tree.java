package com.dub.site.binarySearchTrees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Serializable, S extends NodeFactory<T>> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Node<T> root;// root node
	protected S nodeFactory;// nodeFactory
	  
    public Tree(Node<T> root, S nodeFactory) {
    	this.root = root;
    	this.nodeFactory = nodeFactory;
    	
    }

    public Tree(S nodeFactory) {
    	this.root = null;
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
             
    	Node<T> prevC, newnode;// this side

    	if (rhs.root == null) {
    		this.root = null;
    		return;// rhs tree is empty
    	}
    
    	// initial push_back to start
    	queue.push_back(rhs.root);
              
    	last = null;
    	prevC = null;
    	 
    	while (!queue.isEmpty()) {    
    		
    		x = queue.pop_front();
    		 		
    		newnode = nodeFactory.build(x.getKey());// to correct
    		      
    		if (x == rhs.root) {// special case                 
    			root = newnode;
    		} else {
    			if (last.getParent() != x.getParent()) {// new parent needed
    				prevC = queueP.front();
    				queueP.pop_front();// to improve
    			}                      
    			if (x == x.getParent().getLeft()) {// x is a left child
    				prevC.setLeft(newnode);
    			} else {// x is a right child
    				prevC.setRight(newnode);               
    			}
                     newnode.setParent(prevC);       
    		}     
    		if (x.getLeft() != null) {
    			queue.push_back(x.getLeft());     
    		}     
    		if (x.getRight() != null) {
    			queue.push_back(x.getRight());
    		}      
    		if (x.getLeft() != null || x.getRight() != null) {// at least one child
    			queueP.push_back(newnode);     
    		}
    		last = x;// rhs side          
    	}         
    }
   
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}  
    
	public Node<T> search(Node<T> node, int key) {
        while (node != null && key != node.getKey()) {
            if (key < node.getKey()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;            
    }// search
    
	public void insert(Node<T> x) {
      
         Node<T> ptr = null;
         Node<T> ptr1 = root;

         if (root == null) { 
        	 // tree empty
             root = x;
             root.setParent(null);
             root.setLeft(null);
             root.setRight(null);
             return;
         }
   
         while (ptr1 != null) {
        	 // tree not empty
             ptr = ptr1;
             if (x.getKey() < ptr1.getKey()) {
                 ptr1 = ptr1.getLeft();
             } else {
                 ptr1 = ptr1.getRight();
             }                
         }
         x.setParent(ptr);
         
         if (x.getKey() < ptr.getKey()) {
             ptr.setLeft(x);
         } else {
             ptr.setRight(x);
         }
     }// insert
	 
	public void remove(Node<T> pNode) {		
         Node<T> ptr = null;
         if (pNode.getLeft() == null) {// no left child
             transplant(pNode, pNode.getRight());
         } else if (pNode.getRight() == null) {// no right child
             transplant(pNode, pNode.getLeft()); 
         } else {// both children
             ptr = minimum(pNode.getRight());// successor of pNode 
             
             if (ptr.getParent() != pNode) {
                 transplant(ptr, ptr.getRight());
                 ptr.setRight(pNode.getRight()); 
                 ptr.getRight().setParent(ptr);
             }
             transplant(pNode, ptr);
             ptr.setLeft(pNode.getLeft());
             ptr.getLeft().setParent(ptr);
         }
     }// remove


     private Node<T> minimum(Node<T> pNode) {
         while(pNode.getLeft() != null) {
           pNode = pNode.getLeft();
         }
         return pNode;
     }// minimum


     private Node<T> maximum(Node<T> pNode) {
         while(pNode.getRight() != null) {
           pNode = pNode.getRight();
         }
         return pNode;
     }// maximum
	 
   
     protected Node<T> successor(Node<T> pNode) {
         if (pNode.getRight() != null) {
             return minimum(pNode.getRight());
         }
         Node<T> ptr = pNode.getParent();
         while (ptr != null && pNode == ptr.getRight())  {
             pNode = ptr; ptr = ptr.getParent();
         }
         return ptr;        
     }// successor 
     

     protected Node<T> predecessor(Node<T> pNode) {
         if (pNode.getLeft() != null) {
             return maximum(pNode.getLeft());
         }
         Node<T> ptr = pNode.getParent();
         while (ptr != null && pNode == ptr.getLeft())  {
             pNode = ptr; ptr = ptr.getParent();
         }
         return ptr;        
     }// predecessor
    
     
     public List<Integer> inOrderWalk(Node<T> x) {
    	 List<Integer> list = new ArrayList<>();
    	 Node<T> pNode = minimum(x);
    	 while (pNode != null) {
    		 list.add(pNode.getKey());
    		 pNode = successor(pNode);
    		 
    	 }
    	 return list;
     }
         
     /** replace node u by node v in this tree 
      * transplant belongs to Node super class so it should accept Node not T*/
	private void transplant(Node<T> u, Node<T> v) 
    {        
    	if (u.getParent() == null) {
    		root = v;   
    	 } else if (u == u.getParent().getLeft()) {
    		 u.getParent().setLeft(v);
    	 } else {
    		 u.getParent().setRight(v);
    	 }
          
    	 if (v != null) {    
    		 v.setParent(u.getParent()); 
    	 }
    }// transplant
    
}// Tree
