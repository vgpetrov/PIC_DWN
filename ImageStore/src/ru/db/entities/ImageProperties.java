package ru.db.entities;

import java.io.Serializable;
import java.util.Date;

public class ImageProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3457370085729784944L;
	private Integer id;
	private Date date;
	private String fileName;
	private String type;
	private String path;
	private Site linkTo;

	public ImageProperties() {
	}

	public ImageProperties(Integer id, Date date, String fileName, String type,
			String path, Site linkTo) {
		super();
		this.id = id;
		this.date = date;
		this.fileName = fileName;
		this.type = type;
		this.path = path;
		this.linkTo = linkTo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Site getLinkTo() {
		return linkTo;
	}

	public void setLinkTo(Site linkTo) {
		this.linkTo = linkTo;
	}
	
}
