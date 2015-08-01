package eped.examenes.e2015j1.p2.profes.verbatim;

import eped.base.original.ListDynamic;
import eped.base.original.ListIF;

public class Index{
	public String tag;
	public ListDynamic<Article> articles;
	// ...
	// no implementado por el equipo docente
	public Index(String tagAux, ListIF<Article> l) {
		tag = tagAux;
		articles = (ListDynamic<Article>) l; // seria preferible clonar la lista,
		                                     // pero no es importante.
		                                     // El cast también es una chapucilla
	}
	// no implementado por el equipo docente
	public String getTag() {
		return tag;
	}
	// no implementado por el equipo docente
	public void addArticle(Article a) {
		articles.insert(a);
	}
	// no implementado por el equipo docente
	public ListIF<Article> getArticles() {
		return articles;
	}
}
