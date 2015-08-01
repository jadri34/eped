package eped.examenes.e2015j1.p1.profes.sintaxis_corregida;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eped.base.original.TreeDynamic;
import eped.base.original.TreeIF;

public class UnevenTreeTest {

	@Test
	public void testA() {
		// El árbol del examen:
		//
		//   10
		//  /  \
		// 1    6
		//     / \
		//    2   3
		//       / \
		//      4   7
		//         / \
		//        5   -2
		//           /  \
		//          6    10
		//                |
		//                5
		TreeIF<Integer> a = createTree(5);
		TreeIF<Integer> b = createTree(10);
		b.addChild(a);
		TreeIF<Integer> c = createTree(6);
		TreeIF<Integer> d = createTree(-2);
		d.addChild(c);
		d.addChild(b);
		TreeIF<Integer> e = createTree(5);
		TreeIF<Integer> f = createTree(7);
		f.addChild(e);
		f.addChild(d);
		TreeIF<Integer> g = createTree(4);
		TreeIF<Integer> h = createTree(3);
		h.addChild(g);
		h.addChild(f);
		TreeIF<Integer> i = createTree(2);
		TreeIF<Integer> j = createTree(6);
		j.addChild(i);
		j.addChild(h);
		TreeIF<Integer> k = createTree(1);
		TreeIF<Integer> l = createTree(10);
		l.addChild(k);
		l.addChild(j);
		assertEquals(true, isFullyUneven(l));
	}

	@Test
	public void testABis() {
		// El árbol del examen, ligeramente modificado:
		//
		//   10
		//  /  \
		// 1    6
		//     / \
		//    2   3
		//         \
		//          7
		//         / \
		//        5   -2
		//           /  \
		//          6    10


		TreeIF<Integer> b = createTree(10);
		TreeIF<Integer> c = createTree(6);
		TreeIF<Integer> d = createTree(-2);
		d.addChild(c);
		d.addChild(b);
		TreeIF<Integer> e = createTree(5);
		TreeIF<Integer> f = createTree(7);
		f.addChild(e);
		f.addChild(d);
		TreeIF<Integer> h = createTree(3);
		h.addChild(f);
		TreeIF<Integer> i = createTree(2);
		TreeIF<Integer> j = createTree(6);
		j.addChild(i);
		j.addChild(h);
		TreeIF<Integer> k = createTree(1);
		TreeIF<Integer> l = createTree(10);
		l.addChild(k);
		l.addChild(j);
		assertEquals(true, isFullyUneven(l));
	}
	
	@Test
	public void testB() {
		// El árbol del examen
		//
		//         5
		//        /|\
		//       / | \
		//      /  |  \
		//     /   |   \
		//    /    |    \
		//   3     2     3
		//  / \   / \   / \
		// 4   6 1   0 0   -1
		//    / \         /  \
		//   8   9       1    0

		TreeIF<Integer> a = createTree(8);
		TreeIF<Integer> b = createTree(9);
		TreeIF<Integer> c = createTree(1);
		TreeIF<Integer> d = createTree(0);
		TreeIF<Integer> e = createTree(4);
		TreeIF<Integer> f = createTree(6);
		f.addChild(a);
		f.addChild(b);
		TreeIF<Integer> g = createTree(1);
		TreeIF<Integer> h = createTree(0);
		TreeIF<Integer> i = createTree(0);
		TreeIF<Integer> j = createTree(-1);
		j.addChild(c);
		j.addChild(d);
		TreeIF<Integer> k = createTree(3);
		k.addChild(e);
		k.addChild(f);
		TreeIF<Integer> l = createTree(2);
		l.addChild(g);
		l.addChild(h);
		TreeIF<Integer> m = createTree(3);
		m.addChild(i);
		m.addChild(j);
		TreeIF<Integer> n = createTree(5);
		n.addChild(k);
		n.addChild(l);
		n.addChild(m);
		assertEquals(false, isFullyUneven(n));
	}

	@Test
	public void testC() {
		// El árbol del examen
		//
		//   2
		//  /|\
		// 3 1 1
		//   | |
		//   0 0
		//     |
		//     2
		TreeIF<Integer> a = createTree(2);
		TreeIF<Integer> b = createTree(0);
		TreeIF<Integer> c = createTree(0);
		c.addChild(a);
		TreeIF<Integer> d = createTree(3);
		TreeIF<Integer> e = createTree(1);
		e.addChild(b);
		TreeIF<Integer> f = createTree(1);
		f.addChild(c);
		TreeIF<Integer> g = createTree(2);
		g.addChild(d);
		g.addChild(e);
		g.addChild(f);
		assertEquals(true, isFullyUneven(g));
	}
	
	
	public <T> TreeDynamic<T> createTree(T root) {
		return new UnevenTree<T>(root);
	}

	public <T> boolean isFullyUneven(TreeIF<T> tree) {
		return ((UnevenTree<T>) tree).isFullyUneven();
	}
}
