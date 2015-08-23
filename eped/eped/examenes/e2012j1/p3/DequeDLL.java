package eped.examenes.e2012j1.p3;

public class DequeDLL<T> implements DequeIF<T> {

	/** Implementación mediante lista doblemente enlazada */

	protected class Node<U> {
		public U elem;
		public Node<U> prev;
		public Node<U> next;

		protected Node(U elem, Node<U> prev, Node<U> next) {
			this.elem = elem;
			this.prev = prev;
			this.next = next;
		}
	}

	protected Node<T> first;
	protected Node<T> last;
	protected int length = 0;
	
	@Override
	public void addFirst(T e) {
		first = new Node<T>(e, null, first);
		if(last == null) {
			last = first;
		}
		length++;
	}

	@Override
	public void addLast(T e) {
		Node<T> oldLast = last;
		last = new Node<T>(e, oldLast, null);
		if(oldLast != null) {
			oldLast.next = last;
		}
		if(first == null) {
			first = last;
		}
		length++;
	}

	@Override
	public DequeIF<T> removeFirst() {
		first = first.next;
		first.prev = null;
		length--;
		return this;
	}

	@Override
	public DequeIF<T> removeLast() {
		last = last.prev;
		last.next = null;
		length--;
		return this;
	}

	@Override
	public T getFirst() {
		return first.elem;
	}

	@Override
	public T getLast() {
		return last.elem;
	}

	@Override
	public int getLength() {
		return length;
	}

	// estos métodos no son necesarios para el examen, los pongo para ayudarme
	// en la codificación

	@Override
	public String toString() {
		String result = "[";
		for(Node<T> n = first; n != null; n = n.next) {
			result += n.elem;
			if(n.next != null) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
	
}
