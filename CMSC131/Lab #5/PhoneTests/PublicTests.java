package PhoneTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cellPhones.CellPhone;
import cellPhones.SmartPhone;
import cellPhones.TextMessagingPhone;

public class PublicTests {

	@Test
	public void testRegular() {
		CellPhone fred = new CellPhone("Fred");
		CellPhone charlie = new CellPhone("Charlie");
		assertEquals(
				fred.call(charlie),
				"Charlie is receiving a call from Fred"
		);
	}

	@Test
	public void testTextMessage() {
		CellPhone fred = new CellPhone("Fred");
		TextMessagingPhone cindy = new TextMessagingPhone("Cindy's text phone");
		TextMessagingPhone betsy = new TextMessagingPhone("Betsy's text phone");
		assertEquals(
				cindy.call(fred),
				"Fred is receiving a call from Cindy's text phone"
		);
		assertEquals(
				cindy.call(betsy),
				"Betsy's text phone is receiving a call from Cindy's text phone"
		); 
		assertEquals(
				cindy.sendText(betsy, "What r u doing?"),
				"Betsy's text phone has received TEXT from Cindy's text phone:What r u doing?"
		);
	}

	@Test
	public void testCameraPhone() {
		CellPhone fred = new CellPhone("Fred");
		TextMessagingPhone betsy = new TextMessagingPhone("Betsy's text phone");
		SmartPhone pete = new SmartPhone("Pete's smart phone");
		SmartPhone susan = new SmartPhone("Susan's smart phone");
		assertEquals(
				pete.sendPictureAndTextMessage(susan, "LOL.", "FunnyPic"),
				"Susan's smart phone now displaying picture of FunnyPic-Susan's smart phone has received TEXT from Pete's smart phone:LOL."
		);
		assertEquals(
				susan.sendText(betsy, "ROFL"),
				"Betsy's text phone has received TEXT from Susan's smart phone:ROFL"
		);
		assertEquals(
				susan.call(fred),
				"Fred is receiving a call from Susan's smart phone"
		);
		assertEquals(
				fred.call(susan),
				"Susan's smart phone now displaying picture of Fred-Susan's smart phone is receiving a call from Fred"
		);
	}
	
	@Test
	public void testMixedList() {
		ArrayList<CellPhone> listOfPhones = new ArrayList<CellPhone>();

		listOfPhones.add(new CellPhone("Fred"));
		listOfPhones.add(new TextMessagingPhone("Cindy's text phone"));
		listOfPhones.add(new SmartPhone("Susan's camera phone"));
		

		CellPhone charlie = new CellPhone("Charlie");
		assertEquals(
				listOfPhones.get(0).call(charlie),
				"Charlie is receiving a call from Fred"
		);
		assertEquals(
				listOfPhones.get(1).call(charlie),
				"Charlie is receiving a call from Cindy's text phone"
		);
		assertEquals(
				listOfPhones.get(2).call(charlie),
				"Charlie is receiving a call from Susan's camera phone"
		);
		
	}
}
