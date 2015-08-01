package eped.examenes.e2015j1.p2.profes.sintaxis_corregida;

import eped.base.original.ListIF;
import eped.examenes.e2015j1.p2.profes.verbatim.ArticleIF;

// Representa el periódico digital
public interface NewsPaperIF {

	/** Añadir una noticia al periódico
	* @param content: texto del artículo
	* @param section: sección del artículo
	* @param keywords: etiquetas del artículo
	*/
	public void addArticle (String content, String section, ListIF<String> keywords);

	/** búsqueda de artículos con unas etiquetas determinadas y/o
     * incluidos en una sección determinada
     * @param tags: lista de etiquetas de búqueda (una puede ser la
     * sección) */
	public ListIF <ArticleIF> getArticles (ListIF <String> tags);
}
