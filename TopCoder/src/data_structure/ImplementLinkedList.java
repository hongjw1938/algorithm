package data_structure;

import java.util.Arrays;
import java.util.Comparator;

public class ImplementLinkedList<T> {
	private Node head;
	private Node tail;
	private int size = 0;
	
	
	private class Node{
		private T data;
		private Node next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	Node node(int index) {
		Node x = head;
		
		for(int i=0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public boolean add(T data, int index) {
		if(index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
		if(index == 0) {
			return addFirst(data);
		} else {
			Node temp1 = node(index-1);
			
			Node temp2 = temp1.next;
			
			Node newNode = new Node(data);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
			
			return true;
		}
	}
	
	
	public boolean addFirst(T data) {
		Node node = new Node(data);
		
		node.next = head;
		head = node;
		
		size++;
		
		if(head.next == null) {
			tail = head;
		}
		
		return true;
	}
	
	public boolean addLast(T data) {
		Node node = new Node(data);
		
		if(size == 0) {
			addFirst(data);
		} else{
			tail.next = node;
			tail = node;
			
			size++;
		}
		
		return true;
	}
	
	public String toString() {
		if(head == null) {
			return "[]";
		}
		
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		
		str += temp.data;
		
		return str + "]";
		
	}
	
	public T removeFirst() {
		Node removed = head;
		
		head = removed.next;
		size--;
		return removed.data;
	}
	public T remove(int index) {
		if(index == 0) return removeFirst();
		
		Node temp = node(index-1);
		
		Node willbeDeleted = temp.next;
		
		temp.next = willbeDeleted.next;
		T returnData = willbeDeleted.data;
		
		if(temp.next == null) {
			tail = temp;
		}
		
		size--;
		willbeDeleted = null;
		
		return returnData;
	}
	
	public T removeLast() {
		if(size == 0) throw new ArrayIndexOutOfBoundsException();
		
		return remove(size-1);
	}
	
	public T get(int index) {
		Node temp = node(index);
		return temp.data;
	}
	
	public int indexOf(T data) {
		Node temp = head;
		
		int index = 0;
		
		while(temp.data != data) {
			temp = temp.next;
			index++;
			
			if(temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	public void sort(Comparator<? super T> c) {
		T[] arr = (T[])new Object[size];
		
		Node node = head;
		arr[0] = node.data;
		int i = 1;
		while(node.next != null) {
			arr[i] = node.next.data;
			node = node.next;
			i++;
		}
		
		Arrays.sort(arr, 0, size, c);
		
		
		int j=0;
		Node nodes = head;
		while(j < size) {
			nodes.data = arr[j];
			nodes = nodes.next;
			j++;
		}
		
	}

}
