package com.techv.prakash.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TvConstants {
	private TvConstants() {
	}

	public static final String ST002 = "ST002";
	public static final String ST002MESSAGE = "Invalid Input- Please insert proper value.";

	public static final String ST003 = "ST003";
	public static final String ST003MESSAGE = "Invalid service name entered: ";
	public static final String ST004 = "ST004";
	public static final String ST004MESSAGE = "Invalid pack name entered: ";
	public static final String ST005 = "ST005";
	public static final String ST005MESSAGE = "Invalid channel name entered: ";
	public static final String ST006 = "ST006";
	public static final String ST006MESSAGE = "Invalid email entered: ";
	public static final String ST007 = "ST007";
	public static final String ST007MESSAGE = "Invalid contact entered: ";
	public static final String ST008 = "ST008";
	public static final String ST008MESSAGE = "Invalid recharge amount entered. Please insert proper value.";
	public static final String ST009 = "ST009";
	public static final String ST009MESSAGE = "Invalid months entered. Please insert proper value.";
	public static final String RS = " Rs. ";
	public static final String CHOOSE_OPTION = "Enter the options";
	public static final String ACCOUNT_BAL = "Account balance: ";
	public static final String CHOOSE_CHANNEL = "Enter channel names to add (separated by commas)";
	public static final String ENTER_PHONE = "Enter phone:  ";
	public static final String ENTER_EMAIL = "Enter the email: ";
	public static final String CHOOSE_PACK = "Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’): ";
	public static final String ENTER_MONTH = "Enter the months:  ";
	public static final String ENTER_SERVICE = "Enter the service name:  ";
	public static final String BLANKS = "-----------------------------------\n";

}
