package com.techv.prakash.service;

import com.techv.prakash.beans.User;
import com.techv.prakash.utils.InputAsker;

public interface OptionService {

	public static void viewMenu() {
		System.out.println("********************\n" + "1. View current balance in the account \n"
				+ "2. Recharge Account \n" + "3. View available packs, channels and services \n"
				+ "4. Subscribe to base packs \n" + "5. Add channels to an existing subscription \n"
				+ "6. Subscribe to special services \n" + "7. View current subscription details \n"
				+ "8. Update email and phone number for notifications \n" + "9. View User Details \n" + "10. Exit \n"
				+ "********************");

	}

	public void addRecharge(User user, InputAsker inputAsker);

	public void addPack(User user, InputAsker inputAsker);

	public void addChannels(User user, InputAsker inputAsker);

	public void addServices(User user, InputAsker inputAsker);
	
	public void getSubscriptionDetails(User user);
	
	public void upateUserDetails(User user, InputAsker inputAsker);
	
	public void getUserDetails(User user);
	
	public void getPackChannelServiceMenu();
	
	public void checkUserDetails(User user);
}