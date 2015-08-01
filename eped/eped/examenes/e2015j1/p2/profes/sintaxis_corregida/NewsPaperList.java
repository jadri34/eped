package eped.examenes.e2015j1.p2.profes.sintaxis_corregida;

import eped.base.original.IteratorIF;
import eped.base.original.ListDynamic;
import eped.base.original.ListIF;
import eped.examenes.e2015j1.p2.profes.verbatim.Article;

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
		IteratorIF<Article> iter = L.getIterator();
		while(iter.hasNext()){
			Article A = iter.getNext();
			// vale newspaper.insert(A);
			addArticle(A.getContent(), A.getSection(), A.getTags());
		}
	}
	// Implementación de las operaciones en NewsPaperList
	// addArticle() (0.5 puntos)
	public void addArticle(String content, String section, ListIF<String> tags) {
		Article A = new Article(content,section,tags);
		newspaper.insert(A);
	}
	//getArticles() (1 punto)
	public ListIF<Article> getArticles(ListIF<String> tags){
		ListIF<Article> articles = new ListDynamic<Article>();
		IteratorIF<Article> iter = newspaper.getIterator();
		while(iter.hasNext()){
			Article A = iter.getNext();
			//comprobación por sección de artículo
			if (tags.contains(A.getSection())){
				articles.insert(A);
			}
			else{
				//comprobación por etiquetas de artículo
				ListIF<String> aTags = A.getTags();
				IteratorIF<String> iter2 = aTags.getIterator();
				Boolean centinela = true;
				while (centinela && iter2.hasNext()){
					String tagAux = iter2.getNext();
					if(tags.contains(tagAux)){
						articles.insert(A);
						centinela = false;
					}
				}
			}
		}
		return articles;
	}
}
