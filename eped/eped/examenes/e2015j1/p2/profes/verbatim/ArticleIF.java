package eped.examenes.e2015j1.p2.profes.verbatim;

import eped.base.original.ListIF;

// Representa un artículo
public interface ArticleIF {
	/* Devuelve el contenido del artículo */
	public String getContent ();
	/* Devuelve las etiquetas asociadas al artículo */
	public ListIF <String> getTags ();
	/* Devuelve la sección a la que pertenece el articulo */
	public String getSection ();
}
