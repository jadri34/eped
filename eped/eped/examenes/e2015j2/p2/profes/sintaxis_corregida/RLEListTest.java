package eped.examenes.e2015j2.p2.profes.sintaxis_corregida;

import org.junit.Assert;

import org.junit.Test;

import eped.base.original.ListDynamic;
import eped.base.original.ListIF;
import eped.examenes.e2015j2.p2.profes.verbatim.RLEListIF;

public class RLEListTest {

	@Test
	public void testSize() {
		Assert.assertEquals(12, createRLEList().size());
	}

	@Test
	public void testMode() {
		Assert.assertEquals((Integer) 1, createRLEList().mode());
	}

	@Test
	public void testDecompress() {
		Assert.assertEquals(rleListContentsAsListIF(), createRLEList().decompress());
	}
	
	public RLEListIF<Integer> createRLEList() {
		ListIF<Integer> list = rleListContentsAsListIF();
		RLEListIF<Integer> rleList = createRLEList(list);
		return rleList;
	}

	public ListIF<Integer> rleListContentsAsListIF() {
		ListIF<Integer> list = new ListDynamic<Integer>();
		int[] nums = rleListContents	();
		for(int i = nums.length - 1; i >= 0; i--) {
			list.insert(nums[i]);
		}
		return list;
	}

	public int[] rleListContents() {
		return new int[] { 1, 1, 1, 2, 2, 2, 2, 2, 3, 1, 1, 1};
	}

	public RLEListIF<Integer> createRLEList(ListIF<Integer> input) {
		return new RLEList<Integer>(input);
	}
	
}
