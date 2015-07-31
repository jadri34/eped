package eped.examenes.e2015j2.p2.profes.sintaxis_corregida;

import eped.base.original.IteratorIF;
import eped.base.original.ListIF;

/* Implements the RLEList iterator interface */
public class RLEIterator<T> implements IteratorIF<T>{
	private RLEPair<T> iPair;
	private ListIF<RLEPair<T>> iList;
	public RLEIterator(ListIF<RLEPair<T>> rList){
		iPair = new RLEPair<T> (null, 0);
		iList = rList;
	}

	public boolean hasNext(){
		return (iPair.getFreq()>0 || !iList.isEmpty());
	}

	/* En el material adicional, este método aparece como hasNext() */
	public T getNext(){
		if (iPair.getFreq() == 0){
			if (iList.isEmpty()) return null;
			else {
				iPair = iList.getFirst();
				iList = iList.getTail();
			}
		}
		iPair.setFreq(iPair.getFreq()-1);
		return iPair.getElement();
	}
	
	@Override
	public void reset() {
		throw new UnsupportedOperationException();
	}
}
