package eped.base.original;

public class BTreeDynamic<T> implements BTreeIF<T> {

	private T root;
	private BTreeIF<T> left;
	private BTreeIF<T> right;

	public BTreeDynamic() {
		this.root = null;
		this.left = null;
		this.right = null;
	}

	public BTreeDynamic(T element) {
		this();
		this.setRoot(element);
	}

	public BTreeDynamic(BTreeIF<T> tree) {
		this();
		T tRoot = tree.getRoot();
		BTreeIF<T> tLeft = tree.getLeftChild();
		BTreeIF<T> tRight = tree.getRightChild();
		this.setRoot(tRoot);
		this.setLeftChild(new BTreeDynamic<T>(tLeft));
		this.setRightChild(new BTreeDynamic<T>(tRight));
	}

	@Override
	public T getRoot() {
		return this.root;
	}

	@Override
	public BTreeIF<T> getLeftChild() {
		return this.left;
	}

	@Override
	public BTreeIF<T> getRightChild() {
		return this.right;
	}

	@Override
	public void setRoot(T element) {
		if (element != null)
			this.root = element;
	}

	@Override
	public void setLeftChild(BTreeIF<T> tree) {
		this.left = tree;
	}

	@Override
	public void setRightChild(BTreeIF<T> tree) {
		this.right = tree;
	}

	@Override
	public void removeLeftChild() {
		this.left = null;
	}

	@Override
	public void removeRightChild() {
		this.right = null;
	}

	@Override
	public boolean isLeaf() {
		return this.root != null && this.left == null && this.right == null;
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public boolean contains(T element) {
		return this.root.equals(element) || this.left.contains(element) || this.right.contains(element);
	}

	@Override
	public IteratorIF<T> getIterator(int type) {
		BTreeIF<T> handler = new BTreeDynamic<T>(this);
		return new BTreeIterator<T>(handler, type);
	}

	@Override
	public int hashCode() {
		return 31 * 31 * ((root == null) ? 0 : root.hashCode()) + 31 * ((left == null) ? 0 : left.hashCode()) + ((right == null) ? 0 : right.hashCode());
	}

	@Override
	public boolean equals(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}

}
