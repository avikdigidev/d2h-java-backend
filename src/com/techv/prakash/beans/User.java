package com.techv.prakash.beans;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class User {

	private int accountBalance;
	private String email;
	private String contactNo;
	private String pack;
	private List<String> channelName;
	private List<String> serviceName;



	public String getPackName() {
		if (pack != null) {
			if (pack.equalsIgnoreCase("S")) {
				return "Silver";
			} else if (pack.equalsIgnoreCase("G") ){
				return "Gold";
			}
		}
		return null;
	}


}
