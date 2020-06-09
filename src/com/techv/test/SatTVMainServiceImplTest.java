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

public class SatTVMainServiceImplTest {
	@InjectMocks
	SatTVMainServiceImpl satTVServiceImpl = new SatTVMainServiceImpl();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void invalidInputGiven() {

		User user = new User();
		user.setAccountBalance(100);
		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("sdg");
		try {
			satTVServiceImpl.mainMenu(user, asker, true);
		} catch (InvalidInputException e) {
			System.out.println(e.getErrorCode() + ":" + e.getErrorMessage());
		}
	}
	
	@Test
	public void invalidNumericInput() {

		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("12");

	}
	
	@Test
	public void systemShouldExit() {

		InputAsker asker = Mockito.mock(InputAsker.class);
		when(asker.askStringValue(TvConstants.CHOOSE_OPTION)).thenReturn("10");

	}
}
