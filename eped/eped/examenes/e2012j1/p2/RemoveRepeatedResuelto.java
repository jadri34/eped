package eped.examenes.e2012j1.p2;


public class RemoveRepeatedResuelto<T> extends RemoveRepeated<T> {

	@Override
	public void removeRepeated() {
		RemoveRepeatedResuelto<T> tail = (RemoveRepeatedResuelto<T>) this.tail;
		if(tail == null) {
			return;
		}
		if(first != null) {
			tail.remove(first);
		}
		tail.removeRepeated();
	}

	protected void remove(T elem) {
		if(elem.equals(first)) {
			if(tail == null) {
				first = null;
			}
			else {
				first = tail.getFirst();
				tail = tail.getTail();
			}
		}
		RemoveRepeatedResuelto<T> tail = (RemoveRepeatedResuelto<T>) this.tail;
		if(tail != null) {
			tail.remove(elem);
		}
		if(this.tail != null && this.tail.isEmpty()) {
			this.tail = null;
		}
	}

	@Override
	protected <U> RemoveRepeated<U> createListDynamic() {
		return new RemoveRepeatedResuelto<U>();
	}
	
}
