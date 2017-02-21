package com.dub.site.binarySearchTrees;


/** Simple Node implementation */
public class SimpleNode implements Node<String> {
	
	private int key;
	private Node<String> left, right, parent;
	private String data;
     	
	public SimpleNode(int key) {
		this.key = key;
		this.data = "";// not null
    	this.left = null;
    	this.right = null;
    	this.parent = null;     
	}
	

    public SimpleNode(int key, String data, Node<String> left, Node<String> right, Node<String> parent) {
    	this.key = key;
    	this.data = data;
    	this.left = left;
    	this.right = right;
    	this.parent = parent;
    }

    @Override
	public int getKey() {
		return key;
	}

    @Override
	public void setKey(int key) {
		this.key = key;
	}

    @Override
	public Node<String> getLeft() {
		return (SimpleNode)left;
	}

    @Override
	public void setLeft(Node<String> left) {
		this.left = left;
	}

    @Override
	public Node<String> getRight() {
		return right;
	}

    @Override
	public void setRight(Node<String> right) {
		this.right = right;
	}

    @Override
	public Node<String> getParent() {
		return parent;
	}

    @Override
	public void setParent(Node<String> parent) {
		this.parent = parent;
	}

    @Override
	public String getData() {
		return data;
	}

    @Override
	public void setData(String data) {
		this.data = data;
	}  
} 