package com.vayvonnhanh.request;

import org.springframework.web.multipart.MultipartFile;

public class AppDTO{
	private int id;
	private String link;
	private String name;
	private String minLoan;
	private String maxLoan;

	private MultipartFile imageFile;
	private String imageName;
	
	public AppDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMinLoan() {
		return minLoan;
	}
	public void setMinLoan(String minLoan) {
		this.minLoan = minLoan;
	}
	public String getMaxLoan() {
		return maxLoan;
	}
	public void setMaxLoan(String maxLoan) {
		this.maxLoan = maxLoan;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
