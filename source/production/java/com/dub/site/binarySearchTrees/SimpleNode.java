package com.dub.site.binarySearchTrees;


/** Simple Node implementation */
public class SimpleNode implements Node<String> {
	
	private int mKey;
	private Node<String> mLeft, mRight, mParent;
	private String mData;
     	
	public SimpleNode(int key) {
		this.mKey = key;
		this.mData = "";// not null
    	this.mLeft = null;
    	this.mRight = null;
    	this.mParent = null;     
	}
	

    public SimpleNode(int key, String data, Node<String> left, Node<String> right, Node<String> parent) {
    	this.mKey = key;
    	this.mData = data;
    	this.mLeft = left;
    	this.mRight = right;
    	this.mParent = parent;
    }

    @Override
	public int getmKey() {
		return mKey;
	}

    @Override
	public void setmKey(int mKey) {
		this.mKey = mKey;
	}

    @Override
	public SimpleNode getmLeft() {
		return (SimpleNode)mLeft;
	}

    @Override
	public void setmLeft(Node<String> mLeft) {
		this.mLeft = (SimpleNode)mLeft;
	}

    @Override
	public SimpleNode getmRight() {
		return (SimpleNode)mRight;
	}

    @Override
	public void setmRight(Node<String> mRight) {
		this.mRight = (SimpleNode)mRight;
	}

    @Override
	public SimpleNode getmParent() {
		return (SimpleNode)mParent;
	}

    @Override
	public void setmParent(Node<String> mParent) {
		this.mParent = (SimpleNode)mParent;
	}

    @Override
	public String getmData() {
		return mData;
	}

    @Override
	public void setmData(String mData) {
		this.mData = mData;
	}  
} 