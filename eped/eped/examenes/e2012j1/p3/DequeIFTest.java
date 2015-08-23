package eped.examenes.e2012j1.p3;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class DequeIFTest {

	public abstract <T> DequeIF<T> createDeque();
	
	@Test
	public void testAddFirst() {
		DequeIF<Integer> d = createDeque();
		d.addFirst(1);
		d.addFirst(2);
		d.addFirst(3);
		assertEquals("[3, 2, 1]", d.toString());
	}

	@Test
	public void testAddLast() {
		DequeIF<Integer> d = createDeque();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		assertEquals("[1, 2, 3]", d.toString());
	}

	@Test
	public void testRemoveFirst() {
		DequeIF<Integer> d = createDeque();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		DequeIF<Integer> removed = d.removeFirst();
		assertEquals("[2, 3]", d.toString());
		assertEquals("[2, 3]", removed.toString());
	}

	@Test
	public void testRemoveLast() {
		DequeIF<Integer> d = createDeque();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		DequeIF<Integer> removed = d.removeLast();
		assertEquals("[1, 2]", d.toString());
		assertEquals("[1, 2]", removed.toString());
	}

	@Test
	public void testGetFirst() {
		DequeIF<Integer> d = createDeque();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		assertEquals((Integer) 1, d.getFirst());
	}

	@Test
	public void testGetLast() {
		DequeIF<Integer> d = createDeque();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		assertEquals((Integer) 3, d.getLast());
	}

	@Test
	public void testGetLength() {
		DequeIF<Integer> d = createDeque();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		assertEquals(3, d.getLength());
	}
}
