package eped.examenes.e2015j2.p2.profes.verbatim;

import eped.base.original.ListIF;

/* Representa una lista comprimida mediante RLE */
public interface RLEListIF<T> {

	/*[0’5 puntos] devuelve el número total de elementos de la lista */
	/* En el ejemplo debería devolver 12, no 4 */
	public int size();

	/* [1 punto] devuelve la lista descomprimida */
	public ListIF<T> decompress();

	/* [1 punto] calcula la moda (el elemento más repetido de la   */
	/* lista). En el ejemplo, sería el 1, ya que se repite 6 veces */
	 public T mode ();

}