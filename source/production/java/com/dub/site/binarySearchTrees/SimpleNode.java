package com.dub.site.binarySearchTrees;


/** Basic class */
public class SimpleNode implements Node {
	
	private int mKey;
	private SimpleNode mLeft, mRight, mParent;
	private String mData;
     	
	public SimpleNode(int key) {
		this.mKey = key;
		this.mData = "";
    	this.mLeft = null;
    	this.mRight = null;
    	this.mParent = null;     
	}
	

    public SimpleNode(int key, String data, SimpleNode left, SimpleNode right, SimpleNode parent) {
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
	public Node getmLeft() {
		return (SimpleNode)mLeft;
	}

    @Override
	public void setmLeft(Node mLeft) {
		this.mLeft = (SimpleNode)mLeft;
	}

    @Override
	public Node getmRight() {
		return (SimpleNode)mRight;
	}

    @Override
	public void setmRight(Node mRight) {
		this.mRight = (SimpleNode)mRight;
	}

    @Override
	public Node getmParent() {
		return (SimpleNode)mParent;
	}

    @Override
	public void setmParent(Node mParent) {
		this.mParent = (SimpleNode)mParent;
	}

	public String getmData() {
		return mData;
	}

	public void setmData(String mData) {
		this.mData = mData;
	}
      
} 