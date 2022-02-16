package com.graduation.domain;

public class App {

	private Integer id;

    private String img;

    private String title;
    
    private String link;
    
    private String type;

	private String auth;

	@Override
	public String toString() {
		return "App{" +
				"id=" + id +
				", img='" + img + '\'' +
				", title='" + title + '\'' +
				", link='" + link + '\'' +
				", type='" + type + '\'' +
				", auth='" + auth + '\'' +
				'}';
	}

	public App(Integer id, String img, String title, String link, String type, String auth) {
		this.id = id;
		this.img = img;
		this.title = title;
		this.link = link;
		this.type = type;
		this.auth = auth;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public App() {
		super();
		// TODO Auto-generated constructor stub
	}


}
