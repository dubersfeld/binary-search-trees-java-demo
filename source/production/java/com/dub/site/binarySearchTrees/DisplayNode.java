package com.dub.site.binarySearchTrees;

/** in addition to the basic Tree methods this class also has some additional methods only used for display */
public class DisplayNode extends SimpleNode {
	 
	private int mDepth;
	private int mIndex;

	
	public DisplayNode(int key) {
		super(key);	
	}
	
	public DisplayNode(int key, String data, SimpleNode left, SimpleNode right, SimpleNode parent) {
		super(key, data, left, right, parent);
	}

	
	public int getmDepth() {
		return mDepth;
	}


	public void setmDepth(int mDepth) {
		this.mDepth = mDepth;
	}


	public int getmIndex() {
		return mIndex;
	}


	public void setmIndex(int mIndex) {
		this.mIndex = mIndex;
	}

}
