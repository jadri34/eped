package eped.examenes.e2012j1.p3;


public class DequeDLLTest extends DequeIFTest {

	@Override
	public <T> DequeIF<T> createDeque() {
		return new DequeDLL<>();
	}


}
