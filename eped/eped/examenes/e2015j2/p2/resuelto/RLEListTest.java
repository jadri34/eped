package eped.examenes.e2015j2.p2.resuelto;

import eped.base.original.IteratorIF;
import eped.base.original.ListIF;
import eped.examenes.e2015j2.p2.profes.verbatim.RLEListIF;

public class RLEListTest extends eped.examenes.e2015j2.p2.profes.sintaxis_corregida.RLEListTest {

	@Override
	public RLEListIF<Integer> createRLEList(ListIF<Integer> input) {
		return new RLEList<Integer>(input);
	}
	
	@Override
	protected IteratorIF<Integer> createIterator(RLEListIF<Integer> rleList) {
		return ((RLEList<Integer>) rleList).getIterator();
	}
}
