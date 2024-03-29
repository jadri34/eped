package eped.base.original;

public class BTreeIterator<T> implements IteratorIF<T>

{

	private IteratorIF<T> iterator;

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 Constructor para QueueIterator.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 @param handler
	 *            el manejador de arboles binarios.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 @param type
	 *            el tipo de recorrido.
	 */

	public BTreeIterator(BTreeIF<T> handler, int type)

	{

		QueueIF<T> traverse = null;

		switch (type) {

		case BTreeIF.PREORDER:

			traverse = preorder(handler);

			break;

		case BTreeIF.INORDER:

			traverse = inorder(handler);

			break;

		case BTreeIF.POSTORDER:
			traverse = postorder(handler);
			break;

		case BTreeIF.LRBREADTH:
			traverse = lrBreadth(handler);
			break;

		case BTreeIF.RLBREADTH:
			traverse = rlBreadth(handler);
			break;

		}

		this.iterator = new QueueIterator<T>(traverse);

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 Devuelve el siguiente elemento de la iteracion.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 @return el siguiente elemento de la iteracion.
	 */

	@Override
	public T getNext()

	{

		return iterator.getNext();

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 Devuelve cierto si existen mas elementos en el iterador.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 @return cierto si existen mas elementos en el iterador.
	 */

	@Override
	public boolean hasNext()

	{

		return iterator.hasNext();

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 Restablece el iterador para volver a recorrer la estructura.
	 */

	@Override
	public void reset()

	{

		iterator.reset();

	}

	private QueueIF<T> preorder(BTreeIF<T> tree)

	{

		QueueIF<T> traverse = new QueueDynamic<T>();

		if (tree == null)
			return traverse;

		T element = tree.getRoot();

		BTreeIF<T> lTree = tree.getLeftChild();

		BTreeIF<T> rTree = tree.getRightChild();

		QueueIF<T> lTraverse = preorder(lTree);

		QueueIF<T> rTraverse = preorder(rTree);

		traverse.add(element);

		addAll(traverse, lTraverse);

		addAll(traverse, rTraverse);

		return traverse;

	}

	private QueueIF<T> inorder(BTreeIF<T> tree) {

		QueueIF<T> traverse = new QueueDynamic<T>();

		if (tree == null)
			return traverse;

		T element = tree.getRoot();

		BTreeIF<T> lTree = tree.getLeftChild();

		BTreeIF<T> rTree = tree.getRightChild();

		QueueIF<T> lTraverse = inorder(lTree);

		QueueIF<T> rTraverse = inorder(rTree);

		addAll(traverse, lTraverse);

		traverse.add(element);

		addAll(traverse, rTraverse);

		return traverse;

	}

	private QueueIF<T> postorder(BTreeIF<T> tree) {

		QueueIF<T> traverse = new QueueDynamic<T>();

		if (tree == null)
			return traverse;

		T element = tree.getRoot();

		BTreeIF<T> lTree = tree.getLeftChild();

		BTreeIF<T> rTree = tree.getRightChild();

		QueueIF<T> lTraverse = postorder(lTree);

		QueueIF<T> rTraverse = postorder(rTree);

		addAll(traverse, lTraverse);

		addAll(traverse, rTraverse);

		traverse.add(element);

		return traverse;

	}

	private void addAll(QueueIF<T> q, QueueIF<T> p) {

		while (!p.isEmpty()) {

			T element = p.getFirst();

			q.add(element);

			p.remove();
		}

	}

	private QueueIF<T> lrBreadth(BTreeIF<T> tree)

	{

		QueueIF<T> traverse = new QueueDynamic<T>();

		QueueIF<BTreeIF<T>> aux = new QueueDynamic<BTreeIF<T>>();

		aux.add(tree);

		while (!aux.isEmpty()) {

			BTreeIF<T> aTree = aux.getFirst();

			T element = tree.getRoot();

			BTreeIF<T> lTree = aTree.getLeftChild();

			BTreeIF<T> rTree = aTree.getRightChild();

			if (lTree != null)
				aux.add(lTree);

			if (rTree != null)
				aux.add(rTree);

			traverse.add(element);

			aux.remove();

		}

		return traverse;

	}

	private QueueIF<T> rlBreadth(BTreeIF<T> tree) {

		QueueIF<T> traverse = lrBreadth(tree);

		StackIF<T> aux = new StackDynamic<T>();

		while (!traverse.isEmpty()) {

			T element = traverse.getFirst();

			aux.push(element);

			traverse.remove();

		}

		while (!aux.isEmpty()) {

			T element = aux.getTop();

			traverse.add(element);

			aux.pop();

		}

		return traverse;

	}
}
