package eped.examenes.e2015j2.p2.profes.correcto;

/* Representa un par para la compresión RLE. Se hace pública por
 * conveniencia para resolver la implementación de la clase iteradora */

public class RLEPair<T> {
	private T element;
	private int freq;

	RLEPair(T e, int f) {
		element = e;
		freq = f;
	}

	public T getElement() {
		return element;
	}

	public int getFreq() {
		return freq;
	}

	public void setElement(T e) {
		element = e;
	}

	public void setFreq(int f) {
		freq = f;
	}

	@Override
	public String toString() {
		return "pair(" + element + ", " + freq + ")";
	}

	public RLEPair<T> dup() {
		return new RLEPair<T>(element, freq);
	}
}