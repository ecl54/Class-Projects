package animalManagement;

import GUI.View;

/** 
 * Run the main method in this class to try out the Graphical User Interface
 * 
 * @author Fawzi Emad, Evan Golub (C)2007-2011
 */
public class GUIDriver {

	/** Starts up the GUI */
	public static void main(String[] args) {
		
		final PetStore restaurant = new PetStore("Animals R Us", 1234567);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);		
				new View(restaurant);
			}
		});	
	}

}
