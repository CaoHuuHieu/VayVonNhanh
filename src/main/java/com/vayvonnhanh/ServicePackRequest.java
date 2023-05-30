package com.vayvonnhanh;

import org.springframework.web.multipart.MultipartFile;

public class ServicePackRequest {
	private int id;
	private String link;
	private String discription;
	private String firstLoan;
	private String maxLoan;
	private int minAge;
	private int maxAge;
	private MultipartFile imageFile;
	private String imageName;
	
	public ServicePackRequest() {
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
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getFirstLoan() {
		return firstLoan;
	}
	public void setFirstLoan(String firstLoan) {
		this.firstLoan = firstLoan;
	}
	public String getMaxLoan() {
		return maxLoan;
	}
	public void setMaxLoan(String maxLoan) {
		this.maxLoan = maxLoan;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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
	@Override
	public String toString() {
		return "ServicePackRequest [link=" + link + ", discription=" + discription + ", firstLoan=" + firstLoan
				+ ", maxLoan=" + maxLoan + ", minAge=" + minAge + ", maxAge=" + maxAge + "]";
	}
	
	
}
