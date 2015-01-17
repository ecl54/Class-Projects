package photo;

import javax.swing.JRadioButton;

import p3_student.PhotoTools;

/**
 * Manages photo editing system.  A dialog box is displayed which allows the user
 * to load an image from the local machine or using an internet URL.  Once the image
 * is loaded, it is displayed and the user will be given several options for 
 * editing the image.  After displaying the edited image, the user may choose to 
 * edit the image further, or to load a different image.
 * 
 * @author (c)2007 Fawzi Emad (modified by Evan Golub)
 */
public class PhotoSystem {

	static final int NUM_RADIO_BUTTONS = 9;

	/**
	 * Begin the application.
	 */
	public static void begin(String initialPhoto) {


		JRadioButton[] radioButtons = new JRadioButton[NUM_RADIO_BUTTONS];
		radioButtons[0] = new JRadioButton("Copy");
		radioButtons[3] = new JRadioButton("Grayscale");
		radioButtons[6] = new JRadioButton("Gridded");
		radioButtons[1] = new JRadioButton("Horizontal Stretch");
		radioButtons[4] = new JRadioButton("Vertical Stretch");
		radioButtons[7] = new JRadioButton("Enlarged");
		radioButtons[2] = new JRadioButton("Rotated");
		radioButtons[5] = new JRadioButton("Upside Down");
		radioButtons[8] = new JRadioButton("WeirdCombo");

		ImageSelectionBox isb = new ImageSelectionBox(initialPhoto);


		while(true) {
			isb.setVisible(true);
			try {
				synchronized(isb) {
					isb.wait();
					isb.setVisible(false);
				}
				Photograph photo = new Photograph(isb.getTextValue());
				while(true) {
					synchronized(photo) {
						int[] flag = new int[1];
						new PhotoFrame(flag, radioButtons, photo, isb.getTextValue(), 0, 0);
						photo.wait();
						if (flag[0] == 1)
							break;

					}
					if (radioButtons[0].isSelected()) {
						photo = PhotoTools.copy(photo);
					} else if (radioButtons[3].isSelected()) {
						photo = PhotoTools.makeGrayscale(photo);
					} else if (radioButtons[6].isSelected()) {
						photo = PhotoTools.gridded(photo);
					}  else if (radioButtons[1].isSelected()) {
						photo = PhotoTools.stretched(photo, 0);
					} else if (radioButtons[4].isSelected()) {
						photo = PhotoTools.stretched(photo, 1);
					} else if (radioButtons[7].isSelected()) {
						photo = PhotoTools.enlargement(photo);
					} else if (radioButtons[2].isSelected()) {
						photo = PhotoTools.rotated(photo);
					} else if (radioButtons[5].isSelected()) {
						photo = PhotoTools.upsideDown(photo);
					} else if (radioButtons[8].isSelected()) {
						photo = PhotoTools.weirdCombo(photo);
					} else {
						throw new RuntimeException("error -- no radio button selected");
					}
				}
			}
			catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		} 
	}

}
