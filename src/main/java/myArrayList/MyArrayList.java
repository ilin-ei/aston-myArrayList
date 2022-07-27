package myArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.UnaryOperator;

public class MyArrayList<E> implements MyList<E>{
	
	private E[] elements;
	
	public MyArrayList(){
		elements = (E[]) new Object[0];
	}

	@Override
	public boolean add(E e) {
		E[] tempArray = (E[]) new Object[elements.length + 1];
		for(int i = 0; i < elements.length; i++) {
			tempArray[i] = elements[i];
		}
		tempArray[elements.length] = e;
		elements = tempArray;
		return true;
	}

	@Override
	public E remove(int index) {
		E[] tempArray = (E[]) new Object[elements.length - 1];
		E removed = elements[index];
		for(int i = 0; i < index; i++) {
			tempArray[i] = elements[i];
		}
		for(int i = index; i < elements.length - 1; i++) {
			tempArray[i] = elements[i+1];
		}
		elements = tempArray;
		return removed;
	}

	@Override
	public E get(int index) {
		return elements[index];
	}

	@Override
	public int size() {
		return elements.length;
	}

	@Override
	public void set(int index, E e) {
		elements[index] = e;		
	}

	@Override
	public void clear() {
		elements = (E[]) new Object[elements.length]; 
	}

	@Override
	public boolean isEmpty() {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] != null) return false;
		}
		return true;
	}

	@Override
	public void add(int index, E e) {
		E[] tempArray = (E[]) new Object[elements.length + 1];
		for(int i = 0; i < index; i++) {
			tempArray[i] = elements[i];
		}
		tempArray[index] = e;
		for(int i = index; i < elements.length; i++) {
			tempArray[i + 1] = elements[i];
		}
		elements = tempArray;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		int length = elements.length;
		E[] tempArray = (E[]) new Object[length + c.size()];
		E[] arrayFromCollection = (E[]) new Object[c.size()];
		for(int i = 0; i < length; i++) {
			tempArray[i] = elements[i];
		}
		for(E e: c) {
			tempArray[length++] = e;
		}
		elements = tempArray;
		return true;
	}

	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] == o) return i;
		}
		return -1;
	}

	@Override
	public boolean remove(Object o) {
		for(int index = 0; index < elements.length; index++) {
			if(elements[index] == o) {
				E[] tempArray = (E[]) new Object[elements.length - 1];
				for(int i = 0; i < index; i++) {
					tempArray[i] = elements[i];
				}
				for(int i = index; i < elements.length - 1; i++) {
					tempArray[i] = elements[i+1];
				}
				elements = tempArray;
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(elements);
	}

}
