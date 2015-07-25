package eped.examenes.e2013j1.p4;

import eped.base.corregido.StackDynamic;
import eped.base.original.IteratorIF;
import eped.base.original.StackIF;


public class StackIFNoRepesResuelto extends StackIFNoRepes {

	public StackIF<Integer> noRepes() {
		StackIF<Integer> delReves = new StackDynamic<Integer>();
		IteratorIF<Integer> it1 = getIterator();
		while(it1.hasNext()) {
			Integer elem = it1.getNext();
			delReves.push(elem);
		}
		StackIF<Integer> noRepes = new StackDynamic<Integer>();
		IteratorIF<Integer> it2 = delReves.getIterator();
		while(it2.hasNext()) {
			Integer elem = it2.getNext();
			if(!noRepes.contains(elem)) {
				noRepes.push(elem);
			}
		}
		return noRepes;
	}

	public StackIFNoRepesResuelto() {
		super();
	}
	
	public StackIFNoRepes create() {
		return new StackIFNoRepesResuelto();
	}

}
