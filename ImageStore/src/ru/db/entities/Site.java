package ru.db.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Site implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1782487250054713892L;
	private Integer id;
	private String siteName;
	private List<ImageProperties> images;

	public Site() {
		images = new ArrayList<ImageProperties>();
	}

	public Site(Integer id, String siteName) {
		super();
		this.id = id;
		this.siteName = siteName;
		images = new ArrayList<ImageProperties>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public List<ImageProperties> getImages() {
		return images;
	}

	public void setImages(List<ImageProperties> images) {
		this.images = images;
	}
}
