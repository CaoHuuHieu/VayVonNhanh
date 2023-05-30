package com.vayvonnhanh;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ServicePack")
public class ServicePackEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String link;
	@Column(name="image_name")
	private String imageName;
	private String description;
	@Column(name="firth_loan")
	private String firstLoan;
	@Column(name="max_loan")
	private String maxLoan;
	@Column(name="min_age")
	private int minAge;
	@Column(name="max_age")
	private int maxAge;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFirstLoan() {
		return firstLoan;
	}
	public void setFirthLoan(String firstLoan) {
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
