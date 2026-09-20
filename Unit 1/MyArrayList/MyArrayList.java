/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E [] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
		// objectCount = 100;
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity){
		if (initialCapacity < 0) {
			initialCapacity = 100;
		}
		this.internalArray = (E[]) new Object[initialCapacity];
		// objectCount = initialCapacity;
	}

	/* Return the number of active slots in the array list */
	public int size() {
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		return (objectCount == 0);
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		if (index >= objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return internalArray[index];
	}

	/* Replace the object at index with obj.  returns object that was replaced. */
	public E set(int index, E obj) {
		if (index >= objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		E replacedObj = internalArray[index];
		internalArray[index] = obj;
		return replacedObj;
	}

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
	public boolean contains(E obj) {
		for (int i = 0; i < objectCount; i++) {
			// took ternary from remove logic
			if (obj == null ? internalArray[i] == null : obj.equals(internalArray[i])) {
				return true;
			}
			// if (internalArray[i].equals(obj)) {
			// 	return true;
			// }
		}
		return false;
	}

	/* Insert an object at index */
	public void add(int index, E obj) {
		if (index > objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (objectCount == internalArray.length) {
			resizeInternalArray();
		}
		if (index == objectCount) {
			internalArray[index] = obj;
			objectCount++;
			return;
		}
		for (int i = objectCount - 1; i >= index; i--) {
			internalArray[i + 1] = internalArray[i];
		}
		objectCount += 1;
		internalArray[index] = obj;
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		// System.out.println(objectCount + ": count; " + internalArray.length + ": len");
		if (objectCount == internalArray.length) {
			resizeInternalArray();
		}
		// System.out.println(objectCount + ": count; " + internalArray.length + ": len");
		objectCount += 1;
		internalArray[objectCount - 1] = obj;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void resizeInternalArray() {
		int newSize = (internalArray.length == 0) ? 1 : internalArray.length * 2;
		E[] newInternalArray = (E[]) new Object[newSize];
		for (int i = 0; i < objectCount; i++) {
			newInternalArray[i] = internalArray[i];
		}
		// internalArray = (E[]) new Object[internalArray.length * 2];
		// for (int i = 0; i < newInternalArray.length; i++) {
		// 	internalArray[i] = newInternalArray[i];
		// }
		internalArray = newInternalArray;
	}

	/* Remove the object at index and shift.  Returns removed object. */
	public E remove(int index) {
		if (index >= objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		E removedObj = internalArray[index];
		for (int i = index + 1; i < objectCount; i++) {
			internalArray[i - 1] = internalArray[i];
		}
		internalArray[objectCount - 1] = null;
		objectCount -= 1;
		return removedObj;
	}

	/* Removes the first occurrence of the specified element from this list, 
	 * if it is present. If the list does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
	 * Returns true if this list contained the specified element (or equivalently, 
	 * if this list changed as a result of the call). */
	public boolean remove(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (obj == null ? internalArray[i] == null : obj.equals(internalArray[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}


	/* For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]".  If there is one element, "[X]", etc.
	 * Elements are separated by a comma and a space. */
	public String toString() {
		if (objectCount == 0) {
			return "[]";
		}
		String arr = "[";
		for (int i = 0; i < objectCount; i++) {
			arr += internalArray[i];
			arr += (i != objectCount - 1) ? ", " : "]";
		}
		return arr;
	}

}