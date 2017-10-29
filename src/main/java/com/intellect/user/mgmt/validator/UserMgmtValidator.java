package com.intellect.user.mgmt.validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intellect.user.mgmt.model.User;
import com.intellect.user.mgmt.util.AppErrorCodeEnum;

@Component
public class UserMgmtValidator {

	/*
	 * All the attributes are mandatory except id,active fields for this operation
	 */
	public List<String[]> validateCreateUser(User user) {

		List<String[]> errorList = new ArrayList<String[]>();
		String[] error = new String[3];

		if (user.getfName() == null || user.getfName().trim() == "") {

			String temp = AppErrorCodeEnum.MANDATORY_FIELDS.code();
			error[0] = "code: " + temp.substring(0, temp.indexOf("-"));
			error[1] = "field : First Name";
			error[2] = "message : First Name " + temp.substring(temp.indexOf("-") + 1, temp.length());
			errorList.add(error);
		}

		if (user.getlName() == null || user.getlName().trim() == "") {

			error = new String[3];
			String temp = AppErrorCodeEnum.MANDATORY_FIELDS.code();
			error[0] = "code: " + temp.substring(0, temp.indexOf("-"));
			error[1] = "field : Last Name";
			error[2] = "message : Last Name " + temp.substring(temp.indexOf("-") + 1, temp.length());
			errorList.add(error);
		}

		if (user.getEmail() == null || user.getEmail().trim() == "") {
			error = new String[3];
			String temp = AppErrorCodeEnum.MANDATORY_FIELDS.code();
			error[0] = "code: " + temp.substring(0, temp.indexOf("-"));
			error[1] = "field : Email";
			error[2] = "message : Email " + temp.substring(temp.indexOf("-") + 1, temp.length());
			errorList.add(error);
		}

		if (!isValidDateFormat(user.getBirthDate())) {

			error = new String[3];
			String temp = AppErrorCodeEnum.DATE_FORMAT_MISMATCH.code();
			error[0] = "code: " + temp.substring(0, temp.indexOf("-"));
			error[1] = "field : Birth Date";
			error[2] = "message : Birth Date " + temp.substring(temp.indexOf("-") + 1, temp.length());
			errorList.add(error);

		} else if (!isFutureDate(user.getBirthDate())) {

			error = new String[3];
			String temp = AppErrorCodeEnum.FUTURE_DATE.code();
			error[0] = "code: " + temp.substring(0, temp.indexOf("-"));
			error[1] = "field : Birth Date";
			error[2] = "message : Birth Date " + temp.substring(temp.indexOf("-") + 1, temp.length());
			errorList.add(error);

		}

		return errorList;
	}

	public boolean isValidDateFormat(String dateString) {

		boolean isValid = false;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Date expectedDate = sdf.parse(dateString);
			isValid = true;
		} catch (Exception e) {

			System.out.println(" Input Date is not matching the expected format ");
		}

		return isValid;

	}

	public boolean isFutureDate(String dateString) {

		boolean isFutureDate = false;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Date expectedDate = sdf.parse(dateString);
			isFutureDate = expectedDate.before(new Date());

		} catch (Exception e) {

			System.out.println(" Input Date is not matching the expected format ");
		}

		return isFutureDate;

	}

}
