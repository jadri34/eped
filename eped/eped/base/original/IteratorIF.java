package eped.base.original;

public interface IteratorIF<T> {

	/**
	 * Devuelve el siguiente elemento de la iteracion.
	 * @return el siguiente elemento de la iteracion.
	 */

	public T getNext();

	/**
	 * Indica si hay más elemento en la iteración.
	 * @return true si hay más elemento en la iteración
	 */

	public boolean hasNext();

	/**
	 * Restablece el iterador para volver al inicio.
	 */

	public void reset();

}