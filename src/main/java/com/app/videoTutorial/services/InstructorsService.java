/**
 * 
 */
package com.app.videoTutorial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.videoTutorial.dao.InstructorsDao;
import com.app.videoTutorial.model.Instructors;
import com.app.videoTutorial.model.ResponseInfo;

/**
 * author: Ahmed Raihan Alif
 * date: 4/25/2024
 */
/**
 * this is the service class for the API to perform crud operation for
 * instructors table all the data processing according to request will be
 * performed in this class is responsible for return response this service class
 * will act like template for all APIs
 */

@Component
public class InstructorsService {

	@Autowired
	InstructorsDao instructorsDao;

	public ResponseInfo<List<Instructors>> getAllInfos() {
		ResponseInfo<List<Instructors>> responseInfo = new ResponseInfo<>();

		try {
			List<Instructors> response = instructorsDao.findAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(new ArrayList<>());

		return null;
	}

	public ResponseInfo<Optional<Instructors>> getInfo(Integer id) {
		ResponseInfo<Optional<Instructors>> responseInfo = new ResponseInfo<>();

		try {
			Optional<Instructors> response = instructorsDao.findById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(Optional.empty());

		return null;
	}

	public ResponseInfo<String> saveInfo(Instructors instructorInfo) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			instructorsDao.save(instructorInfo);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	public ResponseInfo<String> deleteInfo(Integer id) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			instructorsDao.deleteById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully deleted id: " + id);
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	public ResponseInfo<String> deleteAllInfos() {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			instructorsDao.deleteAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully truncated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	/**
	 * using @Transactional annotation Spring will automatically start and manage a
	 * transaction for the duration of the method execution. This will resolve the
	 * TransactionRequiredException when executing modifying queries.
	 */
	@Transactional
	public ResponseInfo<String> updateInfo(Instructors instructorInfo) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			instructorsDao.updateInfoById(instructorInfo.getFullName(), instructorInfo.getAddress(),
					instructorInfo.getAge(), instructorInfo.getInstitute(), instructorInfo.getProfession(),
					instructorInfo.getTeachingExperience(), instructorInfo.getBio(), instructorInfo.getNid(),
					instructorInfo.getId());

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully updated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}
}
