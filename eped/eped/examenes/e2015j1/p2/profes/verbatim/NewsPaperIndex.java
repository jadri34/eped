package eped.examenes.e2015j1.p2.profes.verbatim;

import java.util.Iterator;

import eped.base.original.ListDynamic;
import eped.base.original.ListIF;

public class NewsPaperIndex {
	public ListDynamic<Index> newspaper;

	NewsPaperIndex(){
		newspaper = new ListDynamic<Index>();
	}
	NewsPaperIndex(ListIF<Article> L){
		/* Construye el periódico a partir de la lista de artículos */
		/* dada por parámetro */
		newspaper = new ListDynamic<Index>();
		Iterator<Article> iter = L.getIterator();
		while(iter.hasNext()){
			Article A = iter.getNext();
			// vale newspaper.insert(A);
			addArticle(A.getContent(), A.getSection(), A.getTags());
		}
	}

	public Index getIndex(String tag){
		Iterator<Index> iter = newspaper.getIterator();
		while(iter.hasNext){
			Index indexAux=iter.getNext();
			String tagIndex=indexAux.getTag();
			if(tag.equals(tagIndex)){
				return indexAux;
			}
		}
		return null;
	}
	// Implementación de las operaciones en NewsPaperIndex
	//addArticle (1 punto)
	public void addArticle(String content, String section, List<String> tags) {
		Article A = new Article(content,section,tags);
		Iterator<String> iter = tags.getIterator();
		while(iter.hasNext()){
			String tagAux = iter.getNext();
			Index index = getIndex(tagAux);
			If(index!=null){
				//agregar el artículo al índice de la etiqueta
				index.addArticle(A);
			}
			else{
				//nueva etiqueta -> crear nuevo índice con el artículo
				ListIF<Article> L=new ListIF<Article>();
				L.insert(A);
				Index newIndex= new Index(tagAux,L);
				newspaper.insert(newIndex);
			}
		}
	}
	
	//getArticles (1 punto)
	public ListIF<Article> getArticles(ListIF<String> tags){
		/* leer las etiquetas dadas por parámetro, tomar sus artículos */
		/* asociados, e insertarlos en la lista devuelta pro el método */
		ListIF<Article> articles = new ListIF<Article>();
		Iterator<String> iter = tags.getIterator();
		while(iter.hadNext()){
			String tagAux = iter.getNext();
			Index index=getIndex(tagAux);
			If(index!=null){
				ListIF<Article> articlesIndex = index.getArticles();
				Iterator<Article> iter2 = articlesIndex.getIterator();
				while(iter2.hasNext()){
					Article A = iter2.getNext();
					articles.insert(A);
				}
		}
		return articles;
	}
}
