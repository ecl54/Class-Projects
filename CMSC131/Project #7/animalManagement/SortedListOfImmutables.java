package animalManagement;

/**
 * A SortedListOfImmutables represents a sorted collection of immutable objects 
 * that implement the Listable interface.  
 * 
 * An array of references to Listable objects is used internally to represent 
 * the list.  
 * 
 * The items in the list are always kept in alphabetical order based on the 
 * names of the items.  When a new item is added into the list, it is inserted 
 * into the correct position so that the list stays ordered alphabetically
 * by name.
 */
public class SortedListOfImmutables {

	/*
	 * STUDENTS:  You may NOT add any other instance variables to this class!
	*/
	private Listable[] items;

	/**
	 * This constructor creates an empty list by creating an internal array
	 * of size 0.  (Note that this is NOT the same thing as setting the internal
	 * instance variable to null.) 
	 */
	public SortedListOfImmutables() {
		// default constructor with items length equal to zero
		this.items = new Listable[0];
	}

	/**
	 *  Copy constructor.  The current object will become a copy of the
	 *  list that the parameter refers to.  
	 *  
	 *  The copy must be made in such a way that future changes to
	 *  either of these two lists will not affect the other. In other words, 
	 *  after this constructor runs, adding or removing things from one of 
	 *  the lists must not have any effect on the other list.
	 *  
	 *  @param other the list that is to be copied
	 */
	public SortedListOfImmutables(SortedListOfImmutables other) {
		// Objects entering the list are immutable
		// no need for a deep constructor
		this.items = new Listable[other.getSize()];
		for( int index = 0; index < other.getSize(); index++){
		// Loop through list and copy all elements over
			items[index] = other.get(index);
		}
	}

	/**
	 * Returns the number of items in the list.
	 * @return number of items in the list
	 */
	public int getSize() {
		return (items.length);
	}
	
	/**
	 * Returns a reference to the item in the ith position in the list.  (Indexing
	 * is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		return (items[i]);
	}
	
	/**
	 * Adds an item to the list.  This method assumes that the list is already
	 * sorted in alphabetical order based on the names of the items in the list.
	 * 
	 * The new item will be inserted into the list in the appropriate place so
	 * that the list will remain alphabetized by names.
	 * 
	 * In order to accommodate the new item, the internal array must be re-sized 
	 * so that it is one unit larger than it was before the call to this method.
	 *  
	 * @param itemToAdd refers to a Listable item to be added to this list
	 */
	public void add(Listable itemToAdd) {
		// Copy the current list and add a null element to the end of it
		Listable[] newItemsList = new Listable[this.getSize() + 1];
		for( int i = 0; i < this.getSize(); i++){
			newItemsList[i] = this.items[i];
		}
		items = newItemsList;
		
		// Set the new items default index to be the end of the list
		int placerIndex = (this.getSize() - 1);
		// Compare the new element to every other element in the list besides the null
		for( int i = 0; i < this.getSize() - 1; i++){
			// Lexographical comparisons done via compareTo (String) method
			if( items[i].getName().compareToIgnoreCase(itemToAdd.getName()) >= 0 ){
				placerIndex = i;
				break;
			}
		}
		for( int i = (this.getSize() - 1); i > placerIndex; i--){
		// Move all elements up one because of newly introduced element
			items[i] = items[i - 1];
		}
		this.items[placerIndex] = itemToAdd;
	}

	/**
	 * Adds an entire list of items to the current list, maintaining the 
	 * alphabetical ordering of the list by the names of the items.
	 * 
	 * @param listToAdd a list of items that are to be added to the current object
	 */
	public void add(SortedListOfImmutables listToAdd) {
		// Add each list item by calling the add function
		for(Listable item: listToAdd.items){
			this.add(item);
		}
	}
	
	/**
	 * Removes an item from the list.
	 * 
	 * If the list contains the same item that the parameter refers to, it will be 
	 * removed from the list.  
	 * 
	 * If the item appears in the list more than once, just one instance will be
	 * removed.
	 * 
	 * If the item does not appear on the list, then this method does nothing.
	 * 
	 * @param itemToRemove refers to the item that is to be removed from the list
	 */
	public void remove(Listable itemToRemove) {
		boolean itemAppears = false;
		// Loop through items and determine if itemToRemove exists
		for (int i = 0; i < this.getSize(); i++ ){
			if( items[i].getName() == itemToRemove.getName() ){
				itemAppears = true;
				// Set the removable element to null
				items[i] = null;
				break;
			}
		}
		int modifiedListIndexCounter = 0;
		// itemAppears boolean value
		if( itemAppears ){
			// create list with one less element
			Listable[] modifiedList = new Listable[this.getSize()-1];
			for( Listable item: this.items){
				// Loop through items in list copying them over
				// jump over null removable item
				if( item == null){ 
					continue;
				}else{
					// counter to keep track of elements in modified list
					// and so we null element isn't included
					modifiedList[modifiedListIndexCounter] = item;
					modifiedListIndexCounter++;
				}
			}
			this.items = modifiedList;
		}
	}

	/**
	 * Removes an entire list of items from the current list.  Any items in the
	 * parameter that appear in the current list are removed; any items in the
	 * parameter that do not appear in the current list are ignored.
	 * 
	 * @param listToRemove list of items that are to be removed from this list
	 */
	public void remove(SortedListOfImmutables listToRemove) {
		// Individually remove each item from list using
		// the above remove(Listable...) method
		for(Listable item: listToRemove.items){
			// loop through the items in the list
			this.remove(item);
		}
	}

	/**
	 * Returns the sum of the wholesale costs of all items in the list.
	 * 
	 * @return sum of the wholesale costs of all items in the list
	 */
	public int getWholesaleCost() {
		// Average all the wholesale costs through a 
		// running average counter
		int runningCost = 0;
		for( Listable item: this.items){
			// loop through each animal/menagerie in items list
			runningCost = runningCost + item.getWholesaleCost(); 
		}
		return runningCost;
	}

	/**
	 * Returns the sum of the retail values of all items in the list.
	 * 
	 * @return sum of the retail values of all items in the list
	 */
	public int getRetailValue() {
		// Average all the wholesale costs through a 
		// running average counter
		int runningRetailValue = 0;
		for( Listable item: this.items){
			// loop through each animal/menagerie in items list
			runningRetailValue = runningRetailValue + item.getRetailValue(); 
		}
		return runningRetailValue;
	}

	/**
	 * Checks to see if a particular item is in the list.
	 * 
	 * @param itemToFind item to look for
	 * @return true if the item is found in the list, false otherwise
	 */
	public boolean checkAvailability(Listable itemToFind) {
		for( Listable item: this.items){
			// loop through each animal/menagerie in items list
			if( item == itemToFind ){
				// remove element if found
				this.remove(item);
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a list of items is contained in the current list.
	 *  If the list of items has duplicates then the current list must 
	 *  have that many of the item as well. 
	 * (In other words, this method will return true if ALL of the items in 
	 * the parameter are contained in the current list.  If anything is missing,
	 * then the return value will be false.)
	 * 
	 * @param listToCheck list of items that may or may not be a subset of the
	 * current list
	 * @return true if the parameter is a subset of the current list; false 
	 * otherwise
	 */
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		SortedListOfImmutables copyList = new SortedListOfImmutables(this);
		// create a copy list of the listToCheck so we can remove elements freely
		for( Listable itemToCheckAgainst: listToCheck.items ){
			// loop through items in the list being checked
			if( copyList.checkAvailability(itemToCheckAgainst) == false ){
				return false;
			}
		}
		return true;
	}

	/*
	 * Do not modify this method or you will fail our tests!
	 */
	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}
