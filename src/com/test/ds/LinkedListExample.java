package com.test.ds;

public class LinkedListExample<T> {

	Node<T> head;
	//Node<T> tail;
	int size;
	
	LinkedListExample(){
		head=null;
		//tail=null;
		size=0;
	}
	
	public void insertAtStart(int val) {
		Node<T> node = new Node<T>(null,val);
		node.next = head;
		head = node;
		
		size++;
		
	}
	
	
	
	
	
	class Node<T> {
		Node<T> next;
		int data;
		
		Node( int data){
			this.data=data;
			next=null;
		}
		
		Node( Node<T> node,int data){
			this.data=data;
			next=node;
		}
		
	}
	
    public void display() {
    	 Node<T> values =head;
    	while( values.next != null ) {
    		System.out.println(head.data);
    		values = values.next;
    	}
    }
	
	public static void main(String[] args) {
		LinkedListExample ll = new LinkedListExample();
		                  //ll.
		ll.insertAtStart(30);
		ll.insertAtStart(15);
		ll.insertAtStart(20);
		ll.insertAtStart(25);
		
		System.out.println(ll.size);
		ll.display();
		

	}

}
