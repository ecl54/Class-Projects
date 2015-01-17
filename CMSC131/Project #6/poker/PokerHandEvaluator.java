package poker;

public class PokerHandEvaluator {
	/** Name: Eric Lancaster
	 *  Purpose: Determine if a players hand
	 *  has a pair, two pairs, three of kind,
	 *  four of kind, flush, straight, 
	 *  straight flush, and full house. (poker hands).
	 * 	TA: Xuetong Sun
	 *	Section: 0404
	**/ 
	
	//YOUR IMPLEMENTATION HERE
	//THE METHODS MUST MATCH THE DESCRIPTIONS EXACTLY
	
	/* An example of a method whose signature satisfies the 
	 * Description provided to you in the documentation.
	 * 
	 * Naturally, you would replace the body of these methods with
	 * your logic ... that is, remove the exception and replace
	 * it with the appropriate logic that tests the incoming
	 * array of Cards for the desired property---in this
	 * case you would return true if and only if the array 
	 * of Cards represented a straight flush.
	 */
	/**
	 * Purpose: Identify if player has a straight flush 
	 * or five consecutive cards of the same suit.
	 * @param cards: Cards array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasStraightFlush(Card[] cards) {
		return (PokerHandEvaluator.hasStraight(cards) && PokerHandEvaluator.hasFlush(cards));
	}
	/**
	 * Purpose: Identify if player has a straight or multiple
	 * consecutive cards (aces count as low or high card).
	 * @param cards: Card array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasStraight(Card [] cards) {
		int consecCardCounter = 0;
		int[] mapValues = PokerHandEvaluator.countValues(cards);
		int aceCount = mapValues[0];
		for( int i = 1; i < 13; i++){
			if( mapValues[i] == 1 && mapValues[i+1] == 1){
				consecCardCounter++;
			}
		}
		// hand consists of 5 consecutive cards
		if( (consecCardCounter >= 4) ){
			return true;
		// hand consists of 4 consecutive cards and 1 ace
		}else if( consecCardCounter == 3 && aceCount >= 1){
			return true;
		// hand consists of 3 consecutive cards and 2 aces
		}else if( consecCardCounter == 2 && aceCount >= 2){
			return true;
		// hand consists of non-consecutive set of 5 cards
		// having more than 2 aces leads non-consecutives leads here
		}else{
			return false;
		}
	}
	/**
	 * Purpose: Identify if player has flush or 5 cards
	 * of same suit.
	 * @param cards: Card array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasFlush(Card[] cards) {
		int[] mapSuits = PokerHandEvaluator.countSuits(cards);
		for( int i = 0; i < 4; i++){
			if( mapSuits[i] >= 5){
				return true;
			}
		}
		return false;
	}
	/**
	 * Purpose: Identify is a player has four cards of
	 * the same value.
	 * @param cards: Card array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasFourOfAKind(Card[] cards) {
		// Arary representing values 1 - 13 
				// Indexes are 0-12
				int[] mapValues = PokerHandEvaluator.countValues(cards);
				for( int i = 0; i < mapValues.length; i++){
					// exists three of same value
					if ( mapValues[i] >= 4){
						return true;
					}
				}
				return false;
	}
	/**
	 * Purpose: Identify if player's hand consists of
	 * 3 cards of same value and other 2 cards of different value.
	 * @param cards: Cards array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasFullHouse(Card[] cards) {
		// It's not enough to call hasTheeOfAKind and 
		// hasPair because they may identify the same cards
		int[] mapValues = PokerHandEvaluator.countValues(cards);
		int threeOfKindsOrGreater = 0;
		int singlePairs = 0;
		for( int i = 0; i < mapValues.length; i++){
			// Exists three cards of same value
			if ( mapValues[i] >= 3){
				threeOfKindsOrGreater++;
			// Exists two cards of same value
			}else if (mapValues[i] == 2){
				singlePairs++;
			}
		}
		// Exits at least one three of kind or greater
		// And, exists at least a single pair or greater separately
		if( threeOfKindsOrGreater >=1 && (threeOfKindsOrGreater + singlePairs) >= 2){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Purpose: Identify if player has three cards
	 * of same value in hand.
	 * @param cards: Card array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasThreeOfAKind(Card[] cards) {
		// Arary representing values 1 - 13 
		// Indexes are 0-12
		int[] mapValues = PokerHandEvaluator.countValues(cards);
		for( int i = 0; i < mapValues.length; i++){
			// exists three of same value
			if ( mapValues[i] >= 3){
				return true;
			}
		}
		return false;
	}
	/**
	 * Purpose: Identify whether a player's hand
	 * has two pairs of different values or not.
	 * @param cards: Card array or hand.
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasTwoPair(Card[] cards) {
		int[] mapValues = PokerHandEvaluator.countValues(cards);
		int pairCounter = 0; // count how many pairs appear
		for( int i = 0; i < mapValues.length; i++){
			// exists two of same value
			if ( mapValues[i] >= 2){
				pairCounter++;
			}
		}
		// exists at least two pairs
		// representing different values
		if ( pairCounter >= 2 ){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Purpose: Identify whether a player's hand
	 * has a pair of two values or not.
	 * @param cards: Card array or hand
	 * @return: true/false based on player's hand.
	 */
	public static boolean hasPair(Card[] cards) {
		int[] mapValues = PokerHandEvaluator.countValues(cards);
		for( int i = 0; i < mapValues.length; i++){
			if ( mapValues[i] >= 2){
				return true;
			}
		}
		return false;
	}
	/**
	 * Purpose: Create an array that counts how
	 * often any one value appears in an hand
	 * @param cards: Card array or hand
	 * @return: Array of counted values
	 */
	private static int[] countValues(Card[] cards){
		// Important: Indexes 0-12 represent values 1-13
		// Refer to Card class for 1-13 value representations
		int[] mapValues = new int[13];
		for ( int i = 0; i < cards.length; i++){
			mapValues[cards[i].getValue()-1]++;
		}
		return mapValues;
	}
	/**
	 * Purpose: Create an array that counts how often
	 * any one suit appears in a hand
	 * @param cards: Card array or hand
	 * @return: Array of counted suits
	 */
	private static int[] countSuits(Card[] cards){
		int[] mapSuits = new int[4];
		for( int i = 0; i < cards.length; i++){
			mapSuits[cards[i].getSuit()]++;
		}
		return mapSuits;
	}
	
}


