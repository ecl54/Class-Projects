package cellPhones;

import java.util.ArrayList;

public class SimpleMain {

	public static void main(String[] args) {
		//First let's use regular phones...
		CellPhone fred = new CellPhone("Fred");
		CellPhone charlie = new CellPhone("Charlie");
		System.out.println(fred.call(charlie));

		System.out.println();
		
		//Next let's use text-messaging phones...
		TextMessagingPhone cindy = new TextMessagingPhone("Cindy's text phone");
		TextMessagingPhone betsy = new TextMessagingPhone("Betsy's text phone");
		System.out.println(cindy.call(fred));
		System.out.println(cindy.call(betsy)); 
		System.out.println(cindy.sendText(betsy, "What r u doing?"));

		System.out.println();
		
		//Finally let's use camera phones...
		SmartPhone pete = new SmartPhone("Pete's camera phone");
		SmartPhone susan = new SmartPhone("Susan's camera phone");
		System.out.println(pete.sendPictureAndTextMessage(susan, "LOL.", "FunnyPic"));
		System.out.println(susan.sendText(betsy, "ROFL"));
		System.out.println(susan.call(fred));
		System.out.println(fred.call(susan));  
		//We pretend that CameraPhones will show a photo of any caller
		
		System.out.println();
		
		//Now let's make a list of phones and use them each to call charlie
		ArrayList<CellPhone> listOfPhones = new ArrayList<CellPhone>();
		listOfPhones.add(fred);
		listOfPhones.add(cindy);
		listOfPhones.add(susan);
		for (CellPhone currPhone: listOfPhones) {
			System.out.println(currPhone.call(charlie));
		}

	}

}
