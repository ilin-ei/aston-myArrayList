package myArrayList;

import java.util.Collection;

public interface MyList<E> extends Iterable<E>{

	boolean add(E e);
	E remove (int index);
	E get (int index);
	int size();
	void set(int index, E e);
	void clear();
	boolean isEmpty();
	void add (int index, E e);
	boolean addAll (Collection<? extends E> c);
	int indexOf(Object o);
	boolean remove(Object o);
}
