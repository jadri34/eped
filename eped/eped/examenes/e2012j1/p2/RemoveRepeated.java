package eped.examenes.e2012j1.p2;

import org.junit.Assert;
import org.junit.Test;

import eped.base.corregido.ListDynamic;

public class RemoveRepeated<T> extends ListDynamic<T> {

	public void removeRepeated() {
	}

	@Test
	public void testRemoveRepeated() {
		RemoveRepeated<Integer> l = createListDynamic();
		l.insert(3);
		l.insert(2);
		l.insert(4);
		l.insert(1);
		l.insert(3);
		l.insert(2);
		l.insert(6);
		l.insert(2);
		l.insert(3);
		Assert.assertEquals("ListDynamic ­‐ [3, 2, 6, 2, 3, 1, 4, 2, 3]", l.toString());
		l.removeRepeated();
		Assert.assertEquals("ListDynamic ­‐ [3, 2, 6, 1, 4]", l.toString());
	}

	@Override
	protected <U> RemoveRepeated<U> createListDynamic() {
		return new RemoveRepeated<U>();
	}
	
}
