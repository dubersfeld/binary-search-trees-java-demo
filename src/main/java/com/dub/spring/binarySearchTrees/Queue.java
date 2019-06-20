package com.dub.spring.binarySearchTrees;


import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	
	/** A generic queue implementation */
	private List<T> list;
	
	public Queue() {
		list = new ArrayList<T>();
	}
	
	public T pop_front() {
		if (!list.isEmpty()) {
			T front = list.get(0);
		
			for (int i = 0; i < list.size()-1; i++) {
				list.set(i, list.get(i+1));
			}
			list.remove(list.size()-1);
			return front;
		} else {
			return null;
		}
	}
	
	public void push_back(T obj) {
		list.add(obj);
	}
	
	public T front() {
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	} 
	
	/*
	public void display() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	} 
	*/
}
