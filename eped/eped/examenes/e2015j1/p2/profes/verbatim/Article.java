package eped.examenes.e2015j1.p2.profes.verbatim;

import eped.base.original.ListIF;

// no implementada por el equipo docente
public class Article implements ArticleIF {

	protected String content;
	protected ListIF<String> tags;
	protected String section;

	public Article(String content, String section, ListIF<String> tags) {
		this.content = content;
		this.section = section;
		this.tags = tags;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public ListIF<String> getTags() {
		return tags;
	}

	@Override
	public String getSection() {
		return section;
	}

}
