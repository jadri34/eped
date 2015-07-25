package eped.base.original;

public class ListStatic<T> implements ListIF<T> {

	private Object[] elements;
	private int capacity;
	private int first;
	public ListStatic(int capacity) {
		this.capacity = capacity;
		this.first = capacity;
		this.elements = new Object[capacity];
	}

	public ListStatic(ListIF<T> list) {
		if (list != null) {
			this.capacity = list.getLength();
			this.first = this.capacity;
			this.elements = new Object[this.capacity];

			ListIF<T> aList = list;

			for (int i = capacity - list.getLength(); i < capacity; i++) {
				this.elements[i] = aList.getFirst();
				this.first = this.first - 1;
				aList = aList.getTail();
			}
		}
	}

	public ListStatic(int capacity, ListStatic<T> listStatic) {
		throw new UnsupportedOperationException();
	}

	private ListIF<T> copy(ListStatic<T> list) {
		ListStatic<T> l = new ListStatic<T>(capacity);
		l.first = list.first;
		l.elements = list.elements;
		return l;
	}

	@SuppressWarnings("unchecked")
	public T getFirst() {
		if (isEmpty())
			return null;

		return (T) elements[first];
	}

	public ListIF<T> getTail() {
		if (!isEmpty()) {
			ListStatic<T> tail = (ListStatic<T>) copy(this);
			tail.first = first + 1;
			return tail;
		}

		return this;
	}

	public ListIF<T> insert(T element) {
		if (!isFull()) {
			first = first - 1;
			elements[first] = element;
		}

		return this;
	}

	@Override
	public boolean isEmpty() {
		return first == capacity;
	}

	@Override
	public boolean isFull() {
		return first == 0;
	}

	@Override
	public int getLength() {
		return capacity - first;
	}

	@Override
	public IteratorIF<T> getIterator() {
		ListIF<T> handler = new ListStatic<T>(capacity, this);
		return new ListIterator<T>(handler);
	}

	@Override
	public int hashCode() {
		return 31 * 31 * ((elements == null) ? 0 : elements.hashCode()) +
				31 * capacity + first;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;

		if (o == null)
			return false;

		if (o.getClass() != this.getClass())
			return false;

		else {
			ListStatic<T> l = (ListStatic<T>) o;

			return l.elements.equals(elements) && l.capacity == capacity && l.first == first;
		}
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("ListStatic - [");
		IteratorIF<T> listIt = getIterator();

		while (listIt.hasNext()) {
			T element = listIt.getNext();
			buff.append(element);
			if (listIt.hasNext())
				buff.append(", ");
		}

		buff.append("]");

		return buff.toString();
	}

	// Ordenacion por insercion
	// Esto funciona sobre ListDynamic, pero ListStatic no es suficientemente
	// parecida como para que funcione

	// Ordenacion por mezcla
	/**
	 * Ordena los elementos de la lista.
	 * @param element El comparador de elementos.
	 * @return la lista ordenada.
	 */

	public ListStatic<T> sort(ComparatorIF<T> comparator) {
		if (getLength() <= 1)
			return this;
		else {
			int middle = (int) (getLength() / 2);
			int index = 0;
			ListDynamic<T> lLeft = new ListDynamic<T>();
			ListDynamic<T> lRight = new ListDynamic<T>();
			IteratorIF<T> listIt = getIterator();
			while (listIt.hasNext()) {
				T element = listIt.getNext();
				if (index < middle)
					lLeft.insert(element);
				if (index >= middle)
					lRight.insert(element);
				index = index + 1;
			}

			lLeft = lLeft.sort2(comparator);
			lRight = lRight.sort2(comparator);

			return sortMerge(lLeft, lRight, comparator);
		}
	}

	private ListStatic<T> sortMerge(ListIF<T> lLeft, ListIF<T> lRight, ComparatorIF<T> comparator) {
		ListStatic<T> result = new ListStatic<T>(capacity);
		while (lLeft.getLength() > 0 || lRight.getLength() > 0) {
			if (lLeft.getLength() > 0 && lRight.getLength() > 0) {
				T eLeft = lLeft.getFirst();
				T eRight = lRight.getFirst();
				if (comparator.isGreater(eLeft, eRight)) {
					result.append(eLeft);
					lLeft = lLeft.getTail();
				} else {
					result.append(eRight);
					lRight = lRight.getTail();
				}
			} else if (lLeft.getLength() > 0) {
				T eLeft = lLeft.getFirst();
				result.append(eLeft);
				lLeft = lLeft.getTail();
			} else if (lRight.getLength() > 0) {
				T eRight = lRight.getFirst();
				result.append(eRight);
				lRight = lRight.getTail();
			}
		}

		return result;
	}

	private void append(T element) {
		// esta funcion se usa en sortMerge, pero no esta provista
		throw new UnsupportedOperationException();
	}

	// Busqueda iterativa con centinela
	/**
	 * Devuelve cierto si la lista contiene el elemento.
	 * @param element El elemento buscado.
	 * @return cierto si la lista contiene el elemento.
	 */
	@Override
	public boolean contains(T element) {
		IteratorIF<T> listIt = this.getIterator();
		boolean found = false;
		while (!found && listIt.hasNext()) {
			T anElement = listIt.getNext();
			found = anElement.equals(element);
		}
		return found;
	}

	// Busqueda recursiva
	// la implementacion dada no funciona para ListStatic
}
