package com.techv.prakash;

import com.techv.prakash.beans.User;
import com.techv.prakash.exceptions.InvalidInputException;
import com.techv.prakash.service.SatTVMainService;
import com.techv.prakash.service.SatTVMainServiceImpl;
import com.techv.prakash.utils.InputAsker;

public class SatTVMainApplication {

	public static void main(String[] args) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Welcome to SatTV^^^^^^^^^^^^^^^^^^^^^^^^");
		User user = new User();
		user.setAccountBalance(100);
		SatTVMainService satTVService = new SatTVMainServiceImpl();
		try {
			satTVService.mainMenu(user, new InputAsker(System.in, System.out), false);
		} catch (InvalidInputException e) {
			System.out.println(e.getErrorCode() + ":" + e.getErrorMessage());
			satTVService.mainMenu(user, new InputAsker(System.in, System.out), false);

		}

	}

}