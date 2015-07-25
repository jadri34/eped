package eped.examenes.e2013j1.p2;

import org.junit.Assert;
import org.junit.Test;

import eped.base.original.ListDynamic;
import eped.base.original.ListIF;

public class OrdenacionON {

	// Dada una lista de N enteros entre o y 100 (con posibles repeticiones),
	// describase una forma de ordenarlos en tiempo O(N). Pista: utilice un
	// array como estructura de datos auxiliar
	public ListIF<Integer> ordenarON(ListIF<Integer> l) {
		return null;
	}

	@Test
	public void test() {
		ListIF<Integer> desordenada = new ListDynamic<Integer>();
		desordenada.insert(23);
		desordenada.insert(12);
		desordenada.insert(51);
		desordenada.insert(33);
		desordenada.insert(47);
		desordenada.insert(51);
		desordenada.insert(63);
		desordenada.insert(14);
		desordenada.insert(14);
		desordenada.insert(15);
		desordenada.insert(88);
		desordenada.insert(99);
		desordenada.insert(2);

		ListIF<Integer> ordenada = ordenarON(desordenada);
		Assert.assertEquals("ListDynamic ­‐ [2, 12, 14, 14, 15, 23, 33, 47, 51, 51, 63, 88, 99]", ordenada.toString());
	}

}
