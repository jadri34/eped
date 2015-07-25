package eped.examenes.e2013j1.p4;

import org.junit.Assert;
import org.junit.Test;

import eped.base.corregido.StackDynamic;
import eped.base.original.StackIF;

public class StackIFNoRepes extends StackDynamic<Integer> {

	// Implementar un metodo StackIF<Integer> noRepes() dentro del tipo
	// StackIF<Integer>, que devuelva una pila eliminando los elementos
	// repetidos que haya en la original. Por ejemplo:
	//
	//              Entrada:                  Salida:
	//
	//                 2
	//                 3
	//                 3                         3
	//                 2                         2
	//                 1                         1
	//
	// Pista: utilice las estructuras de datos auxiliares que considere
	// oportunas

	public StackIF<Integer> noRepes() {
		return null;
	}

	@Test
	public void test() {
		StackIFNoRepes stack = create();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(2);
		StackIF<Integer> noRepes = stack.noRepes();
		Assert.assertEquals("StackDynamic - [3, 2, 1]", noRepes.toString());
	}

	public StackIFNoRepes() {
		super();
	}

	public StackIFNoRepes create() {
		return new StackIFNoRepes();
	}
}
