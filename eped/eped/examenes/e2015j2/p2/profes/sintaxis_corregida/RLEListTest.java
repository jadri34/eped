package eped.examenes.e2015j2.p2.profes.sintaxis_corregida;

import org.junit.Assert;

import org.junit.Test;

import eped.base.original.ListDynamic;
import eped.base.original.ListIF;
import eped.examenes.e2015j2.p2.profes.verbatim.RLEListIF;

public class RLEListTest {

	@Test
	public void test() {
		ListIF<Integer> list = new ListDynamic<Integer>();
		int[] nums = new int[] { 1, 1, 1, 2, 2, 2, 2, 2, 3, 1, 1, 1};
		for(int i = nums.length - 1; i >= 0; i--) {
			list.insert(nums[i]);
		}
		RLEListIF<Integer> rleList = createRLEList(list);
		Assert.assertEquals(12, rleList.size());
		Assert.assertEquals((Integer) 1, rleList.mode());
	}

	public RLEListIF<Integer> createRLEList(ListIF<Integer> input) {
		return new RLEList<Integer>(input);
	}
	
}
