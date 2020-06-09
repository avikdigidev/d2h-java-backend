package com.techv.prakash.service;

import com.techv.prakash.beans.User;
import com.techv.prakash.exceptions.InvalidInputException;
import com.techv.prakash.utils.InputAsker;
import com.techv.prakash.utils.TvConstants;

public class SatTVMainServiceImpl implements SatTVMainService {

	@Override
	public void mainMenu(User user, InputAsker inputAsker, Boolean runViaJunit) {
		OptionService optionService = new OptionServiceImpl();
		OptionService.viewMenu();

		try {
			String option = inputAsker.askStringValue("Enter the options");
			switch (option) {
			case "1":
				System.out.println("Current balance is " + user.getAccountBalance() + TvConstants.RS);
				break;
			case "2":
				optionService.addRecharge(user, inputAsker);
				break;
			case "3":
				optionService.getPackChannelServiceMenu();
				break;
			case "4":
				optionService.addPack(user, inputAsker);
				break;
			case "5":
				optionService.addChannels(user, inputAsker);
				break;
			case "6":
				optionService.addServices(user, inputAsker);
				break;
			case "7":
				optionService.getSubscriptionDetails(user);
				break;
			case "8":
				optionService.upateUserDetails(user, inputAsker);
				break;
			case "9":
				optionService.getUserDetails(user);
				break;
			case "10":
				return;
			default:
				throw new InvalidInputException("", TvConstants.ST002, TvConstants.ST002MESSAGE);
			}
		} catch (InvalidInputException e) {
			System.out.println(e.getErrorCode() + ":" + e.getErrorMessage());
		} catch (Exception e) {
			throw new InvalidInputException("", TvConstants.ST002, TvConstants.ST002MESSAGE + "");
		}

		if (!runViaJunit) {
			mainMenu(user, inputAsker, false);
		}

	}

}