package eped.examenes.e2012j1.p3;

// Representa una cola de dos terminaciones (deque)
public interface DequeIF<T> {

	/* añade un elemento por el principio
	 * @param e el elemento que se desea añadir [0'75 puntos] */
	public void addFirst(T e);

	/*añade un elemento por el final
	 * @param e el elemento que se desea añadir [0'75 puntos] */
	public void addLast(T e);

	/* Elimina el primer elemento de la deque (modifica la estructura)
	 * @return la deque excluyendo el primer elemento [0'75 puntos] */
	public DequeIF<T> removeFirst();

	/* Elimina el último elemento de la deque (modifica la estructura)
	 * @return la deque excluyendo el primer elemento [0'75 puntos] */
	public DequeIF<T> removeLast();

	/* Devuelve el primer elemento de la deque
	 * @return el primer elemento de la deque [0'5 puntos] */
	public T getFirst();

	/* Devuelve el último elemento de la deque
	 * @return el último elemento de la deque [0'5 puntos] */
	public T getLast();

	/* Devuelve el número de elementos de la deque
	 * @return el número de elementos de la deque [0'5 puntos] */
	public int getLength();

}
