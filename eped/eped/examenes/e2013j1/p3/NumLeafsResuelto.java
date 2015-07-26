package eped.examenes.e2013j1.p3;

import eped.base.original.ListIF;
import eped.base.original.TreeIF;

public class NumLeafsResuelto<T> extends NumLeafs<T> {

	@Override
	public int numLeafs() {
		// La estrategia recursiva es simple...
		ListIF<TreeIF<T>> cs = getChildren();
		if(cs.isEmpty()) {
			// si un arbol no tiene hijos, es una hoja, y por tanto el numero
			// de hojas del arbol es 1
			return 1;
		}
		// si tiene hijos, el numero de hojas es la suma del numero de hojas
		// de los hijos
		int leafs = 0;
		while(!cs.isEmpty()) {
			leafs += ((NumLeafsResuelto<T>) cs.getFirst()).numLeafs();
			cs = cs.getTail();
		}
		return leafs;
	}

	@Override
	public NumLeafs<Integer> create(int i) {
		return new NumLeafsResuelto<Integer>(i);
	}

	public NumLeafsResuelto() {
		super();
	}

	protected NumLeafsResuelto(T element) {
		super(element);
	}

	
}
