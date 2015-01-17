package animalManagement;


import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Image;

/*
 * STUDENTS:  DO NOT MODIFY THIS CLASS! 
 */

/** 
 * An IMMUTABLE class that represents an item that might be part of an menagerie
 * in a pet store.  (For example, Lion or Tiger.)
 * 
 * An animal object has a name (String), a wholesale cost give in pennies (int),
 * a retail price given in pennies (int), and a small picture that depicts
 * the item (java.awt.Image). <br><br>
 * 
 * Note that the constructor is private, so the only available Animal objects
 * are those that are found in the public static array of Animal objects called
 * ANIMAL_OBJECTS.  (You cannot use "new" to instantiate a Animal object, you 
 * must use the ones that are already in the ANIMAL_OBJECTS array.)
 */
public class Animal implements Listable {

	private final String name;
	private final int wholesaleCost;
	private final int retailCost;
	private final Image image;
	
	/**
	 * This array is populated with Animal items that are available for use.
	 * 
	 * Use this array any time you need a Animal object.  The constructor for
	 * the Animal class is private, so the elements of this array are the only
	 * Animal objects available.  (You cannot create new ones.)
	 */
	public static final Animal[] ANIMAL_OBJECTS = 
	{ new Animal("Chipmunk", 8900, 18500, "Chipmunk.jpg"), 
		new Animal("Cockatoo", 17800, 35000, "Cockatoo.jpg"),
		new Animal("Firefox", 4700, 8900, "Firefox.jpg"),
		new Animal("Flamingo", 7700, 19900, "Flamingo.jpg"),
		new Animal("Lion", 5200, 17900, "Lion.jpg"),
		new Animal("Lioness", 6600, 12500, "Lioness.jpg"),
		new Animal("Orangutan", 12700, 19500, "Orangutan.jpg"),
		new Animal("Owl", 17900, 35000, "Owl.jpg"),
		new Animal("Panda", 6700, 12500, "Panda.jpg"),
		new Animal("Tamarin", 12900, 27500, "Tamarin.jpg"),
		new Animal("Tiger", 8900, 12900, "Tiger.jpg"),
		new Animal("Toucan", 9800, 15900, "Toucan.jpg"),
		new Animal("Vulture", 19500, 27500, "Vulture.jpg"),
		new Animal("Zebra", 10600, 12500, "Zebra.jpg")
	};

	private Animal(
			String name, 
			int wholesaleCost, int retailCost, 
			String imageName) 
	{
		this.name = name;
		this.wholesaleCost = wholesaleCost;
		this.retailCost = retailCost;
		this.image = Toolkit.getDefaultToolkit().getImage(imageName);
		
		/*  Java normally loads images in a background thread.
		 *  This waits for the image to finish loading before moving on with
		 *  the rest of the program.  That helps to keep things
		 *  synchronized properly.
		 */
		try {
			MediaTracker tracker = new MediaTracker(new Panel());
			tracker.addImage(image, 0);
			tracker.waitForID(0);
			if (tracker.statusID(0,true) != MediaTracker.COMPLETE) { 
				throw new RuntimeException("Unable to load " + imageName);
			}
		} catch(InterruptedException e) {
			// won't be interrupted, so no worries :-)
		}
	}

	/**
	 * Getter for the Image associated with this animal.  (It's a very small
	 * picture of the animal.)
	 * 
	 * @return a picture representing this item
	 */
	public Image getImage() {
		return image;
		//NOTE: this is a privacy leak but simplifies some issues 
		//      with Image that we haven't seen yet
	}

	/**
	 * Getter for the name of this animal.
	 * 
	 * @return the name of this animal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the wholesale cost of this animal, measured in pennies.
	 * 
	 * @return wholesale cost for this animal in pennies.
	 */
	public int getWholesaleCost() {
		return wholesaleCost;
	}

	/**
	 * Getter for the retail cost of this animal, measured in pennies.
	 * 
	 * @return retail cost for this animal in pennies.
	 */
	public int getRetailValue() {
		return retailCost;
	}

	/**
	 * Checks if the current object is equal to the parameter.  Note:
	 * only the NAMES of the animals are compared.  If the two animals have
	 * the same name, they are considered equal!
	 * 
	 * @param other Animal item to be compared with the current object
	 * @return true if the two Animal have the same name, false otherwise
	 */
	public boolean equals(Object other) {
		if (other == null) return false;
		
		if (this.getClass() != other.getClass()) return false;
		
		return (name.equals(((Animal)other).name));
	}

	/**
	 * Returns the name of the animal.
	 * 
	 * @return the name of the animal
	 */
	public String toString() {
		return name;
	}
}
