package eped.examenes.e2015j1.p2.profes.sintaxis_corregida;

import eped.base.original.IteratorIF;
import eped.base.original.ListDynamic;
import eped.base.original.ListIF;
import eped.examenes.e2015j1.p2.profes.verbatim.Article;
import eped.examenes.e2015j1.p2.profes.verbatim.Index;

public class NewsPaperIndex {
	public ListDynamic<Index> newspaper;

	NewsPaperIndex(){
		newspaper = new ListDynamic<Index>();
	}
	NewsPaperIndex(ListIF<Article> L){
		/* Construye el periódico a partir de la lista de artículos */
		/* dada por parámetro */
		newspaper = new ListDynamic<Index>();
		IteratorIF<Article> iter = L.getIterator();
		while(iter.hasNext()){
			Article A = iter.getNext();
			// vale newspaper.insert(A);
			addArticle(A.getContent(), A.getSection(), A.getTags());
		}
	}

	public Index getIndex(String tag){
		IteratorIF<Index> iter = newspaper.getIterator();
		while(iter.hasNext()){
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
	public void addArticle(String content, String section, ListIF<String> tags) {
		Article A = new Article(content,section,tags);
		IteratorIF<String> iter = tags.getIterator();
		while(iter.hasNext()){
			String tagAux = iter.getNext();
			Index index = getIndex(tagAux);
			if(index!=null){
				//agregar el artículo al índice de la etiqueta
				index.addArticle(A);
			}
			else{
				//nueva etiqueta -> crear nuevo índice con el artículo
				ListIF<Article> L=new ListDynamic<Article>();
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
		ListIF<Article> articles = new ListDynamic<Article>();
		IteratorIF<String> iter = tags.getIterator();
		while(iter.hasNext()){
			String tagAux = iter.getNext();
			Index index=getIndex(tagAux);
			if(index!=null){
				ListIF<Article> articlesIndex = index.getArticles();
				IteratorIF<Article> iter2 = articlesIndex.getIterator();
				while(iter2.hasNext()){
					Article A = iter2.getNext();
					articles.insert(A);
				}
			}
		}
		return articles;
	}
}
