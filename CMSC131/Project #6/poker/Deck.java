package poker;

public class Deck {
	/** Name: Eric Lancaster
	 *  Purpose: Test if the various methods
	 *  in the Deck and PokerHandEvaluator
	 *  class work as their supposed to.
	 * 	TA: Xuetong Sun
	 *	Section: 0404
	**/ 
	
	private Card[] cards;
	
	/**
	 * Purpose: Deck constructor that initializes 
	 * the cards instance variable with 52 different
	 * and fixed cards (a normal deck)
	 */
	public Deck() {
		// A deck contains 52 cards - 4 suits of 13 cards each
		// Run through suits -> Run through numbers
		// Initializing new cards
		
		this.cards = new Card[52];
		int cardCounter = 0; // keep tracks of cards added
		for( int suitNum = 0; suitNum <= 3; suitNum++){
			for( int cardNum = 1; cardNum <= 13; cardNum++){
				this.cards[cardCounter] = new Card( cardNum, suitNum );
				cardCounter++;
				// add one to card counter for each card added
			}
		}
	}
	/**
	 * Purpose: Copy-constructor that creates a shallow copy 
	 * of the Deck passed into the parameter. Since card objects have
	 * immutable instance variables then using reference copies
	 * are akin to creating a deep copy.
	 * @param other: Deck object to copy
	 */
	public Deck(Deck other) {
		// Create new Deck object and copy the references
		// of each Card object in the original array
		this.cards = new Card[other.cards.length];
		for( int cardObj = 0; cardObj < other.cards.length; cardObj++){
			this.cards[cardObj] = other.cards[cardObj];
		}
	}
	/**
	 * Purpose: Return the card object at certain
	 * position in the deck.
	 * @param position: Desired position of card.
	 * @return: Card object at position.
	 */
	public Card getCardAt(int position) {
		return this.cards[position];
	}
	
	/**
	 * Purpose: Get the number of cards in a deck.
	 * @return: The number of cards in a deck.
	 */
	public int getNumCards() {
		return this.cards.length;
	}

	/**
	 * Purpose: Shuffle a deck by diving it into
	 * two packets (lower and upper) and swapping 
	 * them to form a newly ordered Deck.
	 */
	public void shuffle() {
		// firstPacket is the first packet of the deck to shuffle
		// secondPacket is the second packet of the deck to shuffle
		Card[] shuffledCards = new Card[this.cards.length];
		Card[] firstPacket;
		Card[] secondPacket = new Card[(this.cards.length/2)];
		
		if (this.cards.length % 2 == 0 ){
			// If length of deck is even then initialize firstPacket
			// as same length of secondPacket(half)
			firstPacket = new Card[(this.cards.length/2)];
			
			for( int i = 0; i < (this.cards.length/2); i++){
				firstPacket[i] = this.cards[i];
				secondPacket[i] = this.cards[(this.cards.length/2)+i];
			}
		}else{
			// If length of deck is odd then firstPacket size must be one 
			// greater than half of the deck
			// Size of secondPacket is one less because of odd int division
			firstPacket = new Card[( (this.cards.length/2) + 1)];
			
			for( int i = 0; i <= (this.cards.length/2); i++){
				firstPacket[i] = this.cards[i];
			}
			for( int i = 0; i < (this.cards.length/2); i++){
				secondPacket[i] = this.cards[ (this.cards.length/2) + 1 + i ];
			}
		}
		
		int cardCounter = 0;
		// Place firstPacket cards in place of every other
		// card starting from beginning
		for(int i = 0; i < this.cards.length; i = i + 2){
			shuffledCards[i] = firstPacket[cardCounter];
			cardCounter++;
		}
		cardCounter = 0;
		// Place secondPacket cards in place of every other
		// card starting from one from the beginning
		for( int i = 1; i < this.cards.length; i = i + 2){
			shuffledCards[i] = secondPacket[cardCounter];
			cardCounter++;
		}
		this.cards = shuffledCards;
	}
	/**
	 * Purpose: Switch out all the cards from a Deck from
	 * the position (not inclusive) and back into the
	 * the back of the Deck. 
	 * @param position: Position to cut cards from.
	 */
	public void cut(int position) {
		// Create a new array of the cards to be moved
		Card[] cutArray = new Card[position];
		for ( int i = 0; i < position; i++){
			cutArray[i] = cards[i];
		}
		// Move all cards (except those cut) back by 
		// the amount of cards cut (position parameter)
		for ( int i = position; i < (this.cards.length); i++){
			cards[i-position] = cards[i];
		}
		for( int i = (this.cards.length) - position; i < (this.cards.length); i++){
			cards[i] = cutArray[i - (this.cards.length-position)];
		}
	}
	/**
	 * Purpose: Deal out a number of cards
	 * from the front of the deck based on
	 * the given parameter.
	 * @param numCards: Number of cards to deal out.
	 * @return: An array of the dealt cards.
	 */
	public Card[] deal(int numCards) {
		Card[] resizedCards = new Card[(this.cards.length) - numCards];
		Card[] dealtCards = new Card[numCards];
		
		// Put all cards except the dealt ones into a new array
		for( int i = numCards; i < (this.cards.length); i++){
			resizedCards[i-numCards] = cards[i];
		}
		// Put dealt cards into a separate array
		for( int i = 0; i < numCards; i++){
			dealtCards[i] = cards[i];
		}
		this.cards = resizedCards;
		return dealtCards;
	}
 
}
