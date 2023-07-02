package com.vayvonnhanh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="app")
public class AppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String link;
	@Column( columnDefinition = "NVARCHAR(255)")
	private String name;
	@Column(name="image_name")
	private String imageName;
	@Column(name="min_loan")
	private String minLoan;
	@Column(name="max_loan")
	private String maxLoan;
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
