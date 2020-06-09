package com.techv.prakash.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techv.prakash.beans.User;
import com.techv.prakash.exceptions.InvalidInputException;
import com.techv.prakash.utils.InputAsker;
import com.techv.prakash.utils.TvConstants;

public class OptionServiceImpl implements OptionService {

	static Map<String, Integer> packs = null;
	static Map<String, Integer> channels = null;
	static Map<String, Integer> services = null;

	static {
		packs = new HashMap<>();
		packs.put("S", 50);
		packs.put("G", 100);
		channels = new HashMap<>();
		channels.put("ZEE", 10);
		channels.put("SONY", 15);
		channels.put("STAR PLUS", 20);
		channels.put("DISCOVERY", 10);
		channels.put("NATGEO", 20);
		services = new HashMap<>();
		services.put("LEARNENGLISH", 200);
		services.put("LEARNCOOKING", 100);
	}

	@Override
	public void addRecharge(User user, InputAsker inputAsker) {
		try {
			int rechargeAmount = Integer.parseInt(inputAsker.askStringValue("Enter the amount to recharge: ").trim());
			user.setAccountBalance(Math.abs(user.getAccountBalance() + rechargeAmount));
			System.out.println(
					"Recharge completed successfully. Current balance is " + user.getAccountBalance() + TvConstants.RS);

		} catch (Exception e) {
			throw new InvalidInputException("", TvConstants.ST008, TvConstants.ST008MESSAGE + "");
		}

	}

	@Override
	public void addPack(User user, InputAsker inputAsker) {
		String pack = inputAsker.askStringValue("Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’): ")
				.toUpperCase();
		if (pack.equals("S") || pack.equals("G")) {
			try {
				int months = Integer.parseInt(inputAsker.askStringValue("Enter the months:  ").trim());
				int packPrice = 0;
				if (pack.equals("S")) {
					packPrice = months * packs.get("S");
					System.out.println("Silver Monthly price: 50 Rs. ");
				} else if (pack.equals("G")) {
					packPrice = months * packs.get("G");
					System.out.println("Gold Monthly price: 100 Rs. ");
				}

				if (months >= 3) {
					System.out.println("Discount applied:  " + 0.1 * packPrice + TvConstants.RS);
					packPrice = (int) (0.9 * packPrice);
				}
				System.out.println("Final Price after discount:  " + packPrice + TvConstants.RS);

				if (user.getAccountBalance() < packPrice) {
					System.out.println("Insufficient Balance for the pack:  " + user.getAccountBalance()
							+ " Rs. Please recharge.");
				} else {
					user.setPack(pack);
					user.setAccountBalance(user.getAccountBalance() - packPrice);
					System.out.println("You have successfully subscribed the following packs: " + user.getPackName()
							+ "\n" + "No of months: " + months + "\n" + "Subscription Amount:  " + packPrice
							+ TvConstants.RS + "\n" + TvConstants.ACCOUNT_BAL + user.getAccountBalance()
							+ TvConstants.RS);
					checkUserDetails(user);
				}

			} catch (Exception e) {
				throw new InvalidInputException("", TvConstants.ST009, TvConstants.ST009MESSAGE);
			}
		} else {
			throw new InvalidInputException("", TvConstants.ST004, TvConstants.ST004MESSAGE + pack);

		}

	}

	@Override
	public void addChannels(User user, InputAsker inputAsker) {
		String channel = inputAsker.askStringValue("Enter channel names to add (separated by commas)").toUpperCase();
		String[] cn = channel.split(",");
		List<String> cl = new ArrayList<>(Arrays.asList(cn));
		int total = 0;
		for (String string : cl) {
			try {
				total += channels.get(string);
			} catch (Exception e) {
				throw new InvalidInputException("", TvConstants.ST005, TvConstants.ST005MESSAGE + string);
			}
		}
		if (user.getAccountBalance() < total) {
			System.out.println("Insufficient Balance for the channel(s)  " + total + " Rs. Please recharge.");
		} else {
			user.setAccountBalance((user.getAccountBalance() - total));
			user.setChannelName(cl);
			System.out.println("Channel(s) added successfully: " + user.getChannelName() + "\n"
					+ TvConstants.ACCOUNT_BAL + user.getAccountBalance() + TvConstants.RS);
			checkUserDetails(user);
		}
	}

	@Override
	public void addServices(User user, InputAsker inputAsker) {
		String service = inputAsker.askStringValue("Enter the service name:  ").toUpperCase();
		String[] sn = service.split(",");
		List<String> sN = new ArrayList<>(Arrays.asList(sn));
		int total = 0;
		for (String string : sN) {
			try {
				total += services.get(string);
			} catch (Exception e) {
				throw new InvalidInputException("", TvConstants.ST003, TvConstants.ST003MESSAGE + string);
			}
		}
		if (user.getAccountBalance() < total) {
			System.out.println(
					"Insufficient Balance for the service(s)  " + total + TvConstants.RS + ". Please recharge.");
		} else {
			user.setAccountBalance((user.getAccountBalance() - total));
			user.setServiceName(sN);
			System.out.println("Service(s) added successfully: " + user.getServiceName() + "\n"
					+ TvConstants.ACCOUNT_BAL + user.getAccountBalance() + TvConstants.RS);
			checkUserDetails(user);
		}

	}

	@Override
	public void getSubscriptionDetails(User user) {
		System.out.println("Currently subscribed packs and channels: " + user.getPackName() + " and "
				+ user.getChannelName() + "\n" + "Currently subscribed services: " + user.getServiceName());

	}

	@Override
	public void upateUserDetails(User user, InputAsker inputAsker) {
		System.out.println("Update email and phone number for notifications ");
		String email = inputAsker.askStringValue("Enter the email: ");
		String emailregex = "^(.+)@(.+)$";
		if (email.matches(emailregex)) {
			user.setEmail(email);
		} else {
			throw new InvalidInputException("", TvConstants.ST006, TvConstants.ST006MESSAGE + email);
		}
		String contactNo = inputAsker.askStringValue("Enter phone:  ");
		String contactRegex = "[1-9][0-9]{9}";
		if (contactNo.matches(contactRegex)) {
			user.setContactNo(contactNo);
			System.out.println("Email and Phone updated successfully " + " \n Email: " + user.getEmail()
					+ "\n Contact no.: " + user.getContactNo());
		} else {
			throw new InvalidInputException("", TvConstants.ST007, TvConstants.ST007MESSAGE + contactNo);
		}

	}

	@Override
	public void getUserDetails(User user) {

		System.out.println(
				"Currently email address: " + user.getEmail() + "\n" + "Currently SMS number: " + user.getContactNo());

	}

	@Override
	public void getPackChannelServiceMenu() {

		System.out.println(TvConstants.BLANKS + "Available packs for subscription :\n" + TvConstants.BLANKS
				+ "Silver pack: Zee, Sony, Star Plus: 50 Rs. \n"
				+ "Gold Pack: Zee, Sony, Star Plus, Discovery, NatGeo: 100 Rs. \n" + TvConstants.BLANKS
				+ "Available channels for subscription : \n" + TvConstants.BLANKS + "Zee: 10 Rs. \n" + "Sony: 15 Rs. \n"
				+ "Star Plus: 20 Rs.\n" + "Discovery: 10 Rs. \n" + "NatGeo: 20 Rs. \n" + TvConstants.BLANKS
				+ "Available services for subscription :\n" + TvConstants.BLANKS + "LearnEnglish Service: 200 Rs. \n"
				+ "LearnCooking Service: 100 Rs. ");

	}

	@Override
	public void checkUserDetails(User user) {
		if (user.getContactNo() != null) {
			System.out.println("SMS notification sent successfully ");
		}
		if (user.getEmail() != null) {
			System.out.println("Email notification sent successfully ");
		}

	}
}
