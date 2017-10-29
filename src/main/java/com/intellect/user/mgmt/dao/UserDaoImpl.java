package com.intellect.user.mgmt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intellect.user.mgmt.model.User;
import com.intellect.user.mgmt.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	private static UserVO userVO;

	public UserDaoImpl() {
		userVO = new UserVO();
	}

	public boolean createUser(User user) {
		log.info("Creating user defined person: " + user.toString());

		if (userVO != null && userVO.getUsers() != null && userVO.getUsers().size() >= 1) {
			if (isUserExist(user.getEmail())) {
				log.info("User: " + user.getEmail() + " already exists");
				System.out.println(" User : " + user.getEmail() + " already exists ");
				return false;
			}
		}
		user.setId(UUID.randomUUID().toString());
		user.setActive(true);
		userVO.getUsers().add(user);
		return true;
	}

	public boolean isUserExist(String emailId) {
		// User user = null;
		boolean exists = false;

		for (User user : userVO.getUsers()) {

			if (user.getEmail().equals(emailId)) {
				exists = true;
				break;
			}

		}

		return exists;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean success = false;
		for (User userTemp : userVO.getUsers()) {

			if (user.getId().equals(userTemp.getId())) {

				userTemp.setPinCode(user.getPinCode());
				userTemp.setBirthDate(user.getBirthDate());

				// newPerson.se
				/**
				 * Copy Object Properties and Update Salary
				 */
				// BeanUtils.copyProperties(person, newPerson);
				// newPerson.setFirstName(firstName);
				// newPerson.setDob(dob);
				// userVO.getUsers().add(userTemp);
				success = true;
				break;

			}

		}
		return success;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		boolean success = false;
		for (User userTemp : userVO.getUsers()) {

			if (user.getId().equals(userTemp.getId())) {

				userTemp.setActive(false);
				success = true;
				break;

			}

		}

		return success;
	}

	/*
	 * public PersonList deletePerson(String id) { boolean success = false; Person
	 * person = null; for (Iterator<Person> iter =
	 * personList.getPersons().listIterator(); iter.hasNext();) { person =
	 * iter.next(); if (person.getId().equals(id)) { iter.remove();
	 * person.setActive(false); success = true; break; } } PersonList persons = new
	 * PersonList();
	 * 
	 * return persons; }
	 * 
	 * /* (non-Javadoc)
	 * 
	 * @see
	 * com.newfound.rest.server.service.PersonDaoService#updatePerson(java.lang.
	 * Integer, java.lang.Integer)
	 */

	/*
	 * public PersonList updatePerson(Person person) { boolean success = false;
	 * Person personItr = null; Person newPerson = null; for (Iterator<Person> iter
	 * = personList.getPersons().listIterator(); iter.hasNext();) { personItr =
	 * iter.next(); if (person.getId().equals(personItr.getId())) { iter.remove();
	 * //newPerson = new Person();
	 * 
	 * person.setId(personItr.getId());
	 * person.setFirstName(personItr.getFirstName());
	 * person.setLastName(personItr.getLastName());
	 * person.setEmail(personItr.getEmail());
	 * person.setPinCode(person.getPinCode());
	 * person.setActive(personItr.isActive());
	 * 
	 * //newPerson.se /** Copy Object Properties and Update Salary
	 */
	// BeanUtils.copyProperties(person, newPerson);
	// newPerson.setFirstName(firstName);
	// newPerson.setDob(dob);
	/*
	 * personList.getPersons().add(person); success = true;
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return personList; }
	 */
}
