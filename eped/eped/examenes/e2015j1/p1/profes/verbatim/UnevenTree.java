package eped.examenes.e2015j1.p1.profes.verbatim;

import java.util.Iterator;

import eped.base.original.ListIF;
import eped.base.original.TreeDynamic;
import eped.base.original.TreeIF;

public class UnevenTree<T> extends TreeDynamic<T> {

	// Devuelve el número de hojas del nivel de un árbol
	private int numLeaves(ListIF<TreeIF<T>> level) {
		int leaves = 0;
		Iterator<TreeIF<T>> iter=level.getIterator();
		while(iter.hasNext()){
			TreeIF<T> treeAux = iter.getNext();
			if (tree Aux.isLeaf()) leaves++;
		}
		return leaves;}
	// Dado el nivel de un árbol, devuelve su siguiente nivel.
	private ListIF<TreeIF<T>> getNextLevel(ListIF<TreeIF<T>> level){
		ListIF<TreeIF<T>> nextLevel = new ListIF<TreeIF<T>> ();
		Iterator<TreeIF<T>> iter=level.getIterator();
		while(iter.hasNext()){
			TreeIF<T> treeAux = iter.getNext();
			ListIF<TreeIF<T>> children = treeAux.getChildren();
			Iterator<TreeIF<T>> iter2=children.getIterator();
			while(iter2.hasNext()){
				TreeIF<T> son = iter2.getNext();
				nextLevel.insert(son);
			}
		}
		return nextLevel;
	}
	public boolean isFullyUneven(){
		if(isEmpty()){
			return false;
		}
		ListIF<TreeIF<T>> currentLevel = getChildren();
		while (!currentLevel.isEmpty()){
			int leaves = numLeaves(currentLevel);
			if(leaves>1){
				return false;
			}
			currentLevel = getNextLevel(currentLevel);
		}
		return true;
	}
}
