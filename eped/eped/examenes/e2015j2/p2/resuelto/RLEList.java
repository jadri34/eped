package eped.examenes.e2015j2.p2.resuelto;

import eped.base.original.IteratorIF;
import eped.base.original.ListDynamic;
import eped.base.original.ListIF;
import eped.examenes.e2015j2.p2.profes.verbatim.RLEListIF;

public class RLEList<T> implements RLEListIF<T> {

	protected ListIF<RLEPair<T>> pairs = new ListDynamic<RLEPair<T>>();
	
	public RLEList(ListIF<T> list) {
		// construyo una lista de tempPairs a partir de un iterador
		// de list
		ListIF<RLEPair<T>> tempPairs = new ListDynamic<RLEPair<T>>();
		IteratorIF<T> it = list.getIterator();
		while(it.hasNext()) {
			// como tempPairs es una ListDynamic, las inserciones
			// son por la cabeza y puedo acceder a la cabeza de la lista
			//
			// Por tanto, lo que hago es, por cada elemento del it,
			// si en la cabeza de la lista está ese valor, incremento
			// su frecuencia, si no añado un par nuevo de frecuencia uno
			T next = it.getNext();
			if(!tempPairs.isEmpty() && next.equals(tempPairs.getFirst().value)) {
				tempPairs.getFirst().quantity++;
			}
			else {
				tempPairs.insert(new RLEPair<T>(next, 1));
			}
		}
		// esto deberia darme en tempPairs lo que quiero, pero al
		// reves, así que invierto la lista
		pairs = reverse(tempPairs);
	}

	protected static <U> ListIF<U> reverse(ListIF<U> tempPairs) {
		// recorro la lista insertando en una lista nueva por
		// delante
		ListIF<U> result = new ListDynamic<U>();
		IteratorIF<U> it = tempPairs.getIterator();
		while(it.hasNext()) {
			result.insert(it.getNext());
		}
		return result;
	}

	@Override
	public String toString() {
		return "RLEList(" + pairs + ")";
	}
	
	protected static class RLEPair<T> {
		public final T value;
		public int quantity;
		
		protected RLEPair(T value, int quantity) {
			this.value = value;
			this.quantity = quantity;
		}
		
		@Override
		public String toString() {
			return "RLE(val: " + value + ", qty: " + quantity + ")";
		}
	}
	
	@Override
	public int size() {
		int size = 0;
		IteratorIF<RLEPair<T>> it = pairs.getIterator();
		while(it.hasNext()) {
			size += it.getNext().quantity;
		}
		return size;
	}

	@Override
	public ListIF<T> decompress() {
		ListIF<T> decompressed = new ListDynamic<T>();
		IteratorIF<RLEPair<T>> it = pairs.getIterator();
		while(it.hasNext()) {
			RLEPair<T> pair = it.getNext();
			for(int i=0; i<pair.quantity; i++) {
				decompressed.insert(pair.value);
			}
		}
		return reverse(decompressed);
	}

	public ListIF<RLEPair<T>> collapse() {
		ListIF<RLEPair<T>> collapsed = new ListDynamic<RLEPair<T>>();
		IteratorIF<RLEPair<T>> it = pairs.getIterator();
		outer: while(it.hasNext()) {
			RLEPair<T> listElement = it.getNext();
			IteratorIF<RLEPair<T>> collapsedIt = collapsed.getIterator();
			while(collapsedIt.hasNext()) {
				RLEPair<T> collapsedElement = collapsedIt.getNext();
				if(collapsedElement.value.equals(listElement.value)) {
					collapsedElement.quantity += listElement.quantity;
					continue outer;
				}
			}
			collapsed.insert(new RLEPair<T>(listElement.value, listElement.quantity));
		}
		return collapsed;
	}
	
	@Override
	public T mode() {
		T mode = null;
		int modeFreq = 0; 
		IteratorIF<RLEPair<T>> it = collapse().getIterator();
		while(it.hasNext()) {
			RLEPair<T> pair = it.getNext();
			if(pair.quantity > modeFreq) {
				modeFreq = pair.quantity;
				mode = pair.value;
			}
		}
		return mode;
	}

	public RLEIterator<T> getIterator() {
		return new RLEIterator<T>(pairs.getIterator());
	}
	
	public static class RLEIterator<U> implements IteratorIF<U> {

		protected IteratorIF<RLEPair<U>> it;
		protected RLEPair<U> current;

		public RLEIterator(IteratorIF<RLEPair<U>> it) {
			this.it = it;
		}
		
		@Override
		public boolean hasNext() {
			return (current != null && current.quantity > 0) || it.hasNext();
		}

		public U getNext() {
			if(current == null || current.quantity == 0) {
				current = it.getNext();
			}
			current.quantity--;
			return current.value;
			
		}
		
		@Override
		public void reset() {
			throw new UnsupportedOperationException();
		}
		
	}

}
