package com.techv.test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.techv.prakash.beans.User;
import com.techv.prakash.exceptions.InvalidInputException;
import com.techv.prakash.service.SatTVMainServiceImpl;
import com.techv.prakash.utils.InputAsker;
import com.techv.prakash.utils.TvConstants;

public class OptionServiceImplTest {

	@InjectMocks
	SatTVMainServiceImpl satTVServiceImpl = new SatTVMainServiceImpl();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAccountBalance() {

		User user = new User();
		user.setAccountBalance(100);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("1");
		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void validRecharge() {

		User user = new User();
		user.setAccountBalance(100);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("2");
		when(asker.askStringValue("Enter the amount to recharge: ")).thenReturn("9000");
		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void viewAvailableOptions() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("3");
		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void validPackAddition() {

		User user = new User();
		user.setAccountBalance(1000);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("4");
		when(asker.askStringValue(TvConstants.CHOOSE_PACK)).thenReturn("S");
		when(asker.askStringValue(TvConstants.ENTER_MONTH)).thenReturn("3");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void validChannelAdded() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("5");
		when(asker.askStringValue(TvConstants.CHOOSE_CHANNEL)).thenReturn("zee");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void validServiceAdded() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("6");
		when(asker.askStringValue(TvConstants.ENTER_SERVICE)).thenReturn("learnenglish");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void viewSubscriptionDetails() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("7");
		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void validContactAdded() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("8");
		when(asker.askStringValue(TvConstants.ENTER_EMAIL)).thenReturn("emailbol@bolmail.com");
		when(asker.askStringValue(TvConstants.ENTER_PHONE)).thenReturn("9876543211");
		satTVServiceImpl.mainMenu(user, asker, true);

	}



	@Test
	public void validPackGiven() {

		User user = new User();
		user.setAccountBalance(1000);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("4");
		when(asker.askStringValue(TvConstants.CHOOSE_PACK)).thenReturn("G");
		when(asker.askStringValue(TvConstants.ENTER_MONTH)).thenReturn("3");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void invalidPackGiven() {

		User user = new User();

		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("4");
		when(asker.askStringValue(TvConstants.CHOOSE_PACK)).thenReturn("h");
		when(asker.askStringValue(TvConstants.ENTER_MONTH)).thenReturn("3");
		try {
			satTVServiceImpl.mainMenu(user, asker, true);
		} catch (InvalidInputException e) {
			System.out.println(e.getErrorCode() + ":" + e.getErrorMessage());
		}

	}

	@Test
	public void invalidEmailGiven() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("8");
		when(asker.askStringValue(TvConstants.ENTER_EMAIL)).thenReturn("emailbol");
		when(asker.askStringValue(TvConstants.ENTER_PHONE)).thenReturn("9876543911");
		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void serviceShouldGetAdded() {

		User user = new User();
		user.setAccountBalance(1000);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("6");
		when(asker.askStringValue(TvConstants.ENTER_SERVICE)).thenReturn("learnenglish");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void packShouldGetAdded() {

		User user = new User();
		user.setAccountBalance(-1);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("4");
		when(asker.askStringValue(TvConstants.CHOOSE_PACK)).thenReturn("S");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void channelShouldBeAdded() {

		User user = new User();
		user.setAccountBalance(9999);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("5");
		when(asker.askStringValue(TvConstants.CHOOSE_CHANNEL)).thenReturn("zee");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void channelAdditionShouldFail() {

		User user = new User();
		user.setAccountBalance(9999);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("5");
		when(asker.askStringValue(TvConstants.CHOOSE_CHANNEL)).thenReturn("cartoonNetwork");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void serviceAdditionShouldFail() {

		User user = new User();
		user.setAccountBalance(1000);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("6");
		when(asker.askStringValue(TvConstants.ENTER_SERVICE)).thenReturn("learnHindi");

		satTVServiceImpl.mainMenu(user, asker, true);

	}

	@Test
	public void invalidNumberGiven() {

		User user = new User();
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("8");
		when(asker.askStringValue(TvConstants.ENTER_EMAIL)).thenReturn("emailbol@bolmail.com");
		when(asker.askStringValue(TvConstants.ENTER_PHONE)).thenReturn("987654321");
		satTVServiceImpl.mainMenu(user, asker, true);

	}




	@Test
	public void viewUsersDetails() {

		User user = new User();
		user.setContactNo("8876543211");
		user.setEmail("user@mail.com");
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("9");
		satTVServiceImpl.mainMenu(user, asker, true);

	}

}
