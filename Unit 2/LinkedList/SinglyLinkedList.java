// Implements a singly-linked list.

import java.util.List;

public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		// confused as to what I should do here, will come back later if revelation from other stuff
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(E[] values) {
		nodeCount = values.length;
		ListNode<E> previousNode = null;
		for (int i = values.length - 1; i >= 0; i--) {
			// start from tail, then add from that!!!
			ListNode<E> currentNode;
			E value = values[i];
			if (i == values.length - 1) {
				currentNode = new ListNode<E>(value);
				tail = currentNode;
			} else {
				currentNode = new ListNode<E>(value, previousNode);
			}
			if (i == 0) {
				head = currentNode;
			}
			previousNode = currentNode;
		}
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return (nodeCount == 0);
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		ListNode<E> currentNode = head;
		// null is tail's next / head when len=0
		while (currentNode != null) {
			if (currentNode.getValue().equals(obj)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		ListNode<E> currentNode = head;
		int count = 0;
		while (currentNode != null) {
			if (currentNode.getValue().equals(obj)) {
				return count;
			}
			currentNode = currentNode.getNext();
			count++;
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> newNode = new ListNode<E>(obj, null);
		tail.setNext(newNode);
		tail = newNode;
		if (head == null) {
			head = newNode;
		}
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		ListNode<E> currentNode = head;
		ListNode<E> previousNode = null;
		ListNode<E> nodeToRemove = null;
		while (currentNode != null) {
			if (currentNode.getValue().equals(obj)) {
				nodeToRemove = currentNode;
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		if (nodeToRemove == null) {
			return false;
		}
		nodeCount--;
		// check head/tail by nullness of prev / current next
		// forgot case where len=1 and head/tail are the same
		if (previousNode == null) {
			head = nodeToRemove.getNext();
			return true;
		}
		if (nodeToRemove.getNext() == null) {
			tail = previousNode;
			previousNode.setNext(null);
			return true;
		}
		previousNode.setNext(nodeToRemove.getNext());
		return true;
	}

	// Returns the i-th element.               
	public E get(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currentNode = head;
		int count = 0;
		while (count != i) {
			currentNode = currentNode.getNext();
			count++;
		}
		return currentNode.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, E obj) {
		if (i <= 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currentNode = head;
		int count = 0;
		while (count != i) {
			currentNode = currentNode.getNext();
			count++;
		}
		E oldValue = currentNode.getValue();
		currentNode.setValue(obj);
		return oldValue;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		return head.getValue();
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		// probably going to have to use StringBuilder later
		String strRep = "[";
		return "";
	}

}
