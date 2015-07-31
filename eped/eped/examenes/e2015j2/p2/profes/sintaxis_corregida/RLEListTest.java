package eped.examenes.e2015j2.p2.profes.sintaxis_corregida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eped.base.original.IteratorIF;
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
		// comparo los toString porque el equals de ListDynamic no va muy fino
		Assert.assertEquals(rleListContentsAsListIF().toString(), createRLEList().decompress().toString());
	}

	@Test
	public void testIterator() {
		IteratorIF<Integer> iterator = createIterator(createRLEList());
		List<Integer> collected = new ArrayList<Integer>();
		while(iterator.hasNext()) {
			collected.add(iterator.getNext());
		}
		Assert.assertEquals(Arrays.asList(rleListContents()), collected);
	}

	protected IteratorIF<Integer> createIterator(RLEListIF<Integer> rleList) {
		return new RLEIterator<Integer>(((RLEList<Integer>) rleList).getData());
	}
	
	public RLEListIF<Integer> createRLEList() {
		ListIF<Integer> list = rleListContentsAsListIF();
		RLEListIF<Integer> rleList = createRLEList(list);
		return rleList;
	}

	public ListIF<Integer> rleListContentsAsListIF() {
		ListIF<Integer> list = new ListDynamic<Integer>();
		Integer[] nums = rleListContents();
		for(int i = nums.length - 1; i >= 0; i--) {
			list.insert(nums[i]);
		}
		return list;
	}

	public Integer[] rleListContents() {
		return new Integer[] { 1, 1, 1, 2, 2, 2, 2, 2, 3, 1, 1, 1};
	}

	public RLEListIF<Integer> createRLEList(ListIF<Integer> input) {
		return new RLEList<Integer>(input);
	}
	
}
