package app.news.com.myapplication;

import java.io.Serializable;


public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String content;

	private String info;

	private String title;

	//bi-directional many-to-one association to Newstype

	private Newstype newstype;

	public News() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Newstype getNewstype() {
		return this.newstype;
	}

	public void setNewstype(Newstype newstype) {
		this.newstype = newstype;
	}

}