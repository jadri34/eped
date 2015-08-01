package eped.examenes.e2015j2.p2.profes.correcto;

import eped.base.original.IteratorIF;
import eped.base.original.ListDynamic;
import eped.base.original.ListIF;
import eped.examenes.e2015j2.p2.profes.verbatim.RLEListIF;

/* Representa una lista comprimida mediante RLE (run-length *
 * encoding) */

public class RLEList<T> implements RLEListIF<T> {
	private int size;
	private T mode;
	private ListIF<RLEPair<T>> data;

	/* The empty constructor is included to make it easy setting up */
	/* initial values when actually constructing a compressed */
	/* RLE list */
	public RLEList() {
		size = 0;
		mode = null;
		data = null;
	}

	/* Creates a Run-Length Encoded compressed list out of a list */
	/* possibly including element repetitions and keeping the order */
	/* of occurrence of the original elements */
	/* @param the list to be compressed */

	public RLEList(ListIF<T> input) {
		this();
		size = input.getLength();
		data = compress(input, null, 0);
		mode = computeMode();
	}

	/* Private method meant to carry out the actual compression */
	/* @param the input (list) to be compressed */

	private ListIF<RLEPair<T>> compress(ListIF<T> input, T elem, int count) {
		// caso base: entrada vacía
		if (input.isEmpty()) {
			ListDynamic<RLEPair<T>> init = new ListDynamic<RLEPair<T>>();
			if (elem == null)
				return init;
			RLEPair<T> aPair = new RLEPair<T>(elem, count);
			return init.insert(aPair);
		}
		// Empieza el conteo de un nuevo grupo de elementos repetidos
		if (elem == null)
			return compress(input.getTail(), input.getFirst(), 1);
		// Continúa el conteo de un grupo de elementos repetidos
		if (elem.equals(input.getFirst()))
			return compress(input.getTail(), elem, count + 1);
		// Termina el conteo de un grupo de elementos repetidos
		RLEPair<T> aPair = new RLEPair<T>(elem, count);
		return compress(input, null, 0).insert(aPair);
	}

	/* Devuelve la lista descomprimida */
	public ListIF<T> decompress() {
		return expand(data, null, 0);
	}

	/* Private method to actually compute the mode */
	private T computeMode() {
		return findMax(collapse());
	}

	/* Private method to accumulate any repeated values on the same */
	/* RLE pair. */
	private ListIF<RLEPair<T>> collapse (){
		ListIF<RLEPair<T>> auxList = new ListDynamic<RLEPair<T>> ();
		IteratorIF<RLEPair<T>> dIter = data.getIterator();
		RLEPair<T> auxPair = null, dPair;
		while (dIter.hasNext()) {
			IteratorIF<RLEPair<T>> auxIter = auxList.getIterator();
			dPair = dIter.getNext();
			boolean found = false;
			while (auxIter.hasNext() && !found) {
				auxPair = auxIter.getNext ();
				found = (auxPair.getElement().equals(dPair.getElement()));
			}
			if (found)
				auxPair.setFreq (auxPair.getFreq() + dPair.getFreq());
			else
				auxList.insert (dPair.dup()); /* comentar que no importa el orden */
		}
		return auxList;
	}

	/* Private method to find the most repeated element */
	private T findMax (ListIF<RLEPair<T>> aList){
		RLEPair<T> aPair;
		RLEPair<T> mPair = new RLEPair<T>(null, 0);
		IteratorIF<RLEPair<T>> aIter = aList.getIterator ();
		while (aIter.hasNext()){
		aPair = aIter.getNext();
		if (aPair.getFreq()>mPair.getFreq()) mPair = aPair;
		}
		return mPair.getElement();
		}

	/* Private method to perform the actual decompression process */
	private ListIF<T> expand(ListIF<RLEPair<T>> rList, T e, int reps) {
		if (reps == 0) {
			if (rList.isEmpty())
				return new ListDynamic<T>();
			else {
				T elem = rList.getFirst().getElement();
				int freq = rList.getFirst().getFreq();
				return expand(rList.getTail(), elem, freq);
			}
		} else {
			return expand(rList, e, reps - 1).insert(e);
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public T mode() {
		return mode;
	}

	public ListIF<RLEPair<T>> getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return "RLE(" + data + ")";
	}
}