package animalManagement;


/**
 * An IMMUTABLE class that represents a list of animals and a name. 
 * For example, a typical menagerie might be called "Oh My" and might 
 * consist of the list:  1 Lion, 2 Tiger, 1 Panda
 */
public class Menagerie implements Listable {
	/*
	 * STUDENTS:  You may NOT add any other instance variables!
	 */
	private final String name;
	private final SortedListOfImmutables animalList;
	
	/**
	 * Standard constructor.  
	 * To ensure that the Menagerie class remains immutable, this
	 * constructor will make a copy of the list that animalListIn refers to.
	 * (This is necessary because a SortedListOfImmutables is mutable.)
	 * 
	 * @param nameIn desired name for this Menagerie
	 * @param animalListIn desired list of Animal objects for this Menagerie
	 */
	public Menagerie(String nameIn, SortedListOfImmutables animalListIn) {
		this.name = nameIn;
		this.animalList = new SortedListOfImmutables(animalListIn);
	}
	
	/**
	 * Getter for name of Menagerie
	 * 
	 * @return reference to the name of Menagerie
	 */
	public String getName() {
		return (name);
	}
	
	/**
	 *  Getter for animalList for this menagerie.
	 *  
	 *  @return reference to a copy of the animalList for this menagerie
	 */
	public SortedListOfImmutables getAnimalList() {
		// return copy of animalList
		return ( new SortedListOfImmutables(animalList) );
	}
	
	/**
	 * Returns the wholesale cost of the animals in this menagerie
	 * 
	 * @return wholesale cost of the animals in this menagerie
	 */
	public int getWholesaleCost() {
		return (animalList.getWholesaleCost());
	}
	
	/**
	 * Returns the retail value of the animals in this menagerie
	 * 
	 * @return retail value of the animals in this menagerie
	 */
	public int getRetailValue() {
		return (animalList.getRetailValue());
	}
	
	/**
	 * Compares the current object to the parameter and returns true if they
	 * have the same name.
	 * 
	 * @param other Menagerie to be compared to the current object
	 * @return true if the current object and the parameter have the same name, 
	 * false otherwise
	 */
	public boolean equals(Object other) {
		// if reference copies -> return true
		if( this == other ){ return true; }
		// if other Object is null -> return false
		if( other == null ){ return false; }
		// cast Object to Menagerie class
		Menagerie newObj = (Menagerie)other;
		// compare Menagerie instance object and 
		// parameter Menagerie via their names
		if(newObj.getName() == this.getName()){
			return true;
		}else{
			return false;
		}
	}
	
	/* Do not modify this method or you will fail our tests!
	 */
	public String toString() {
		String retValue = "< ";
		for (int i = 0; i < animalList.getSize(); i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += animalList.get(i);
		}
		retValue += " >";
		return retValue;
	}
}
