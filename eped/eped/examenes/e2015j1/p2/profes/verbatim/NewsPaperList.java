package eped.examenes.e2015j1.p2.profes.verbatim;

import java.util.Iterator;

import eped.base.original.ListDynamic;
import eped.base.original.ListIF;

public class NewsPaperList {
	public ListDynamic<Article> newspaper;
	// ...
	/* Los constructores pueden implementarse de la siguiente */
	/* manera: */
	/* Constructor por defecto de NewsPaperList (0.25 puntos) */
	NewsPaperList(){
		/* Construye un periódico vacío representado por una lista */
		/* vacía de artículos */
		newspaper = new ListDynamic<Article>();
	}
	// Constructor por parámetros de NewsPaperList (0.25 puntos)
	NewsPaperList(ListIF<Article> L){
		/* Construye el periódico a partir de la lista de artículos */
		/* dada por parámetro */
		newspaper = new ListDynamic<Article>();
		Iterator<Article> iter = L.getIterator();
		while(iter.hasNext()){
			Article A = iter.getNext();
			// vale newspaper.insert(A);
			addArticle(A.getContent(), A.getSection(), A.getTags());
		}
	}
	// Implementación de las operaciones en NewsPaperList
	// addArticle() (0.5 puntos)
	public void addArticle(String content, String section, List<String> tags) {
		Article A = new Article(content,section,tags);
		newspaper.insert(A);
	}
	//getArticles() (1 punto)
	public ListIF<Article> getArticles(List<String> tags){
		ListIF<Article> articles = new ListIF<Article>();
		Iterator<Article> iter = newspaper.getIterator();
		while(iter.hasNext()){
			Article A = iter.getNext();
			//comprobación por sección de artículo
			if (tags.contains(A.getSection())){
				articles.insert(A);
			}
			else{
				//comprobación por etiquetas de artículo
				ListIF<String> aTags = A.getTags();
				Iterator<String> iter2 = aTags.getIterator();
				Boolean centinela = true;
				while (centinela && iter2.hasNext()){
					String tagAux = iter2.getNext();
					If(tags.contains(tagAux)){
						articles.insert(A);
						centinela = false;
					}
				}
			}
		}
		return articles;
	}
}
