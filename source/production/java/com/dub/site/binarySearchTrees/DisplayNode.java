package com.dub.site.binarySearchTrees;

/** in addition to the basic Tree methods this class also has some additional methods only used for display */
public class DisplayNode implements Node<Geometry> {
	 
	private int mKey;
	private Node<Geometry> mLeft, mRight, mParent;
	private Geometry mData;
	
	public DisplayNode(int key) {
		this.mKey = key;
		this.mData = new Geometry();// not null
    	this.mLeft = null;
    	this.mRight = null;
    	this.mParent = null;     
	}
	

    public DisplayNode(int key, Geometry data, Node<Geometry> left, Node<Geometry> right, Node<Geometry> parent) {
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
	public Node<Geometry> getmLeft() {
		return mLeft;
	}

    @Override
	public void setmLeft(Node<Geometry> mLeft) {
		this.mLeft = mLeft;
	}

    @Override
	public Node<Geometry> getmRight() {
		return mRight;
	}

    @Override
	public void setmRight(Node<Geometry> mRight) {
		this.mRight = mRight;
	}

    @Override
	public Node<Geometry> getmParent() {
		return mParent;
	}

    @Override
	public void setmParent(Node<Geometry> mParent) {
		this.mParent = mParent;
	}

    @Override
	public Geometry getmData() {
		return mData;
	}

    @Override
	public void setmData(Geometry mData) {
		this.mData = mData;
	}

	

}
