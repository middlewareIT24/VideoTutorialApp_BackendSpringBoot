/**
 * 
 */
package com.app.videoTutorial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * author: Ahmed Raihan
 * date: 4/25/2024
 */
/**
 * this is the dto for instructors table all the properties of this class should
 * be as same as the columns of the table this dto will act like template for
 * all APIs
 */

@Entity
public class Instructors {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String fullName;
	private String profession;
	private String institute;
	private Integer age;
	private Integer teachingExperience;
	private String address;
	private String nid;
	private String bio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTeachingExperience() {
		return teachingExperience;
	}

	public void setTeachingExperience(Integer teachingExperience) {
		this.teachingExperience = teachingExperience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
