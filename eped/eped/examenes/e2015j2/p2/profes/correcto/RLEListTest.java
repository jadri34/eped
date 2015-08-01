package eped.examenes.e2015j2.p2.profes.correcto;

import eped.base.original.IteratorIF;
import eped.base.original.ListIF;
import eped.examenes.e2015j2.p2.profes.verbatim.RLEListIF;

public class RLEListTest extends eped.examenes.e2015j2.p2.profes.sintaxis_corregida.RLEListTest {

	protected IteratorIF<Integer> createIterator(RLEListIF<Integer> rleList) {
		return new RLEIterator<Integer>(((RLEList<Integer>) rleList).getData());
	}
	
	public RLEListIF<Integer> createRLEList() {
		ListIF<Integer> list = rleListContentsAsListIF();
		RLEListIF<Integer> rleList = createRLEList(list);
		return rleList;
	}

	public RLEListIF<Integer> createRLEList(ListIF<Integer> input) {
		return new RLEList<Integer>(input);
	}
	
}
