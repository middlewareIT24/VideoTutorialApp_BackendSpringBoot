/**
 * 
 */
package com.app.videoTutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.videoTutorial.model.Instructors;

/**
 * author: Ahmed Raihan
 * date: 4/25/2024
 */
/**
 * this is the dao for instructors table this is an interface that inherit
 * JpaRepository<dto, data type of primary key> is responsible to create
 * connection with db automatic this interface will act like template for all
 * APIs
 */
public interface InstructorsDao extends JpaRepository<Instructors, Integer> {

	@Modifying
	@Query("update Instructors s set s.fullName = ?1, s.address = ?2, s.age = ?3, s.institute=?4, s.profession=?5, s.teachingExperience=?6, s.bio=?7, s.nid=?8  where s.id = ?9")
	void updateInfoById(String fullName, String address, Integer age, String institute, String profession,
			Integer teachingExperience, String bio, String nid, Integer id);

}
