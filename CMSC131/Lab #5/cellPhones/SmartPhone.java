package cellPhones;

public class SmartPhone extends TextMessagingPhone {
	
	public SmartPhone(String ownerIn) {
		//Invoke the super class' copy constructor and send it owner
		
		//NOTE: There's nothing else to do since SmartPhone adds no
		//      new fields.
		super(ownerIn);

	}
	
	public String displayPicture(String pictureSubject) {
		//return a String of the form:
		//    owner's name " now displaying picture of " pictureSubject

		return(this.ownerName + " now displaying picture of " + pictureSubject);
	}
	
	
	/* 
	 * This method OVERRIDES the inherited receiveCall method.
	 * Smartphones "display" a photo of the caller.
	 */
	public String receiveCall(CellPhone sender) {
		//return a String built from:
		//    the result of calling displayPicture with the sender's owner's name 
		//    concatenated with a dash and then concatenated with the
		//    result of invoking the superclass' receiveCall with the sender
		return (this.displayPicture(sender.ownerName) + "-" + super.receiveCall(sender));
	}


		
	public String receivePictureAndTextMessage(
			SmartPhone sender, String messageText, String picDescription) {
		//owner receives messageText from sender with picDescription
		
		//return a String built from:
		//    the result of calling displayPicture with the picDescription 
		//    concatenated with a dash and then concatenated with the
		//    result of invoking the receiveText method with the sender
		//    and the messageText

		return (this.displayPicture(picDescription) + "-" + this.receiveText(sender, messageText));
	}

	

	public String sendPictureAndTextMessage(
			SmartPhone receiver, String messageText, String picDescription) {
		//owner sends messageText to receiver with picDescription
		
		//return a String built by having the receiver invoke the
		//   receivePictureAndTextMessage method, sending in the 
		//   current phone, the messageText, and the picture description

		return (receiver.receivePictureAndTextMessage(this, messageText, picDescription));
	}
}
