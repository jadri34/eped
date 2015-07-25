package eped.examenes.e2013j1.p2;

import eped.base.original.IteratorIF;
import eped.base.original.ListDynamic;
import eped.base.original.ListIF;

public class OrdenacionONResuelto extends OrdenacionON {

	@Override
	public ListIF<Integer> ordenarON(ListIF<Integer> l) {
		// La estrategia que sigo es crear un array que contiene cuantas veces
		// hay cada numero en l, asi pues en el ejemplo:
		//
		// valores[12] = 1, porque 12 aparece una vez
		// valores[51] = 2, porque 51 aparece una vez
		// valores[7]= 0, porque 7 no aparece

		// Tengo que poder hacer valores[0]..valores[100], asi que necesito
		// un array de 101 elementos. new int[n] inicializa los valores a 0,
		// que es lo que me interesa
		int[] valores = new int[101];

		// cuento las frecuencias de l
		IteratorIF<Integer> it = l.getIterator();
		while(it.hasNext()) {
			Integer elem = it.getNext();
			valores[elem]++;
		}

		// y entonces, a partir de valores construyo resultado, primero miro
		// valores[100] y añado 100 tantas veces a resultado como valores[100]
		// y voy tirando para atras. Recordemos que ListDynamic.insert inserta
		// por la cabeza de la lista, por eso tengo que recorrer del reves
		ListIF<Integer> resultado = new ListDynamic<Integer>();
		for(int i=100; i>=0; i--) {
			for(int j=0; j<valores[i]; j++) {
				resultado.insert(i);
			}
		}
		return resultado;
	}
}
