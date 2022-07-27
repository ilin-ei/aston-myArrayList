import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myArrayList.MyArrayList;

public class MyArrayListTests {
	
	MyArrayList<String> list = new MyArrayList<>();

	@BeforeEach
	public void init() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
	}
	
	@Test
	public void getSize() {
		assertTrue(list.size() == 4);
	}
	
	@Test
	public void isEmpty() {
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void getElement() {
		assertEquals(list.get(0), "one");
		assertEquals(list.get(3), "four");
	}
	
	@Test
	public void removeByIndex() {
		assertEquals(list.remove(2), "three");
		assertEquals(list.get(1), "two");
		assertEquals(list.get(2), "four");
	}
	
	@Test
	public void removeConcreteElement() {
		list.remove("one");
		assertEquals(list.get(0), "two");
		assertTrue(list.size() == 3);
	}
	
	@Test
	public void removeNonExistentElement() {
		assertFalse(list.remove("1000"));
	}
	
	@Test
	public void clearArray() {
		boolean b = false;
		list.clear();
		for(String str: list) {
			if(str != null) b = true;
		}
		assertFalse(b);
	}
	
	@Test
	public void setValue() {
		list.set(1, "new value");
		assertEquals(list.get(1), "new value");
	}
	
	@Test
	public void addByIndex() {
		list.add(2, "2.5");
		assertEquals(list.get(1), "two");
		assertEquals(list.get(3), "three");
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void indexOfElement() {
		assertEquals(list.indexOf("four"), 3);
	}
	
	@Test
	public void addAllFromCollection() {
		Set<String> set = new TreeSet<>();
		set.add("set 1");
		set.add("something");
		set.add("34");
		list.addAll(set);
		assertEquals(list.size(), 7);
		assertEquals(list.indexOf("something"), 6);
	}
}
