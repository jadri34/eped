package eped.examenes.e2013j1.p3;

import org.junit.Assert;
import org.junit.Test;

import eped.base.original.TreeDynamic;

public class NumLeafs<T> extends TreeDynamic<T> {

	public int numLeafs() {
		return 0;
	}

	@Test
	public void test() {
		// tree1 => 3
		NumLeafs<Integer> tree1 = create(3);
		// tree2 => 6
		NumLeafs<Integer> tree2 = create(6);

		// tree3 => 2
		//          |
		//          +-+
		//          | |
		//          3 6
		NumLeafs<Integer> tree3 = create(2);
		tree3.addChild(tree1);
		tree3.addChild(tree2);

		// tree4 => 4
		NumLeafs<Integer> tree4 = create(4);

		// tree5 => 5
		//          |
		//          +-+
		//          | |
		//          2 4
		//          |
		//          +-+
		//          | |
		//          3 6
		NumLeafs<Integer> tree5 = create(5);
		tree5.addChild(tree3);
		tree5.addChild(tree4);

		Assert.assertEquals(1, tree1.numLeafs());
		Assert.assertEquals(1, tree2.numLeafs());
		Assert.assertEquals(2, tree3.numLeafs());
		Assert.assertEquals(1, tree4.numLeafs());
		Assert.assertEquals(3, tree5.numLeafs());
	}

	public NumLeafs<Integer> create(int i) {
		return new NumLeafs<Integer>(i);
	}
	
	public NumLeafs() {
		super();
	}

	protected NumLeafs(T element) {
		super(element);
	}
}
