package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {
	/** Name: Eric Lancaster
	 *  Purpose: Determine whether a players hand
	 *  has a pair, two pairs, three of kind,
	 *  four of kind, flush, straight, 
	 *  straight flush, and full house.
	 * 	TA: Xuetong Sun
	 *	Section: 0404
	**/ 
	
	@Test
	public void testDeckConstructor() {
		Deck testDeck = new Deck();
		assertTrue(testDeck.getNumCards() == 52);
		
		// select suit
		int cardCounter = 0;
		for( int i = 0; i < 4; i++){
			// select card value
			for( int j = 0; j < 13; j++){
				assertTrue(testDeck.getCardAt(cardCounter).getValue() == (j+1));
				assertTrue(testDeck.getCardAt(cardCounter).getSuit() == i);
				cardCounter++;
			}
		}
			
	}
	@Test 
	public void testDeckCopyConstructor(){
		Deck testDeck = new Deck();
		testDeck.shuffle();
		testDeck.deal(5);
		testDeck.shuffle();
		
		Deck copyDeck = new Deck(testDeck);
		assertFalse(testDeck == copyDeck);
		
		assertTrue(copyDeck.getNumCards() == testDeck.getNumCards());
		for(int i = 0; i < testDeck.getNumCards(); i++){
			assertEquals(copyDeck.getCardAt(i), testDeck.getCardAt(i));
			assertEquals(copyDeck.getCardAt(i), testDeck.getCardAt(i));
		}
	}
	@Test
	public void testGetCardAt(){
		Deck testDeck = new Deck();
		Deck newDeck = new Deck(testDeck);
		
		for( int i = 0; i < 52; i++){
			assertEquals(testDeck.getCardAt(i), newDeck.getCardAt(i));
		}
	}
	@Test
	public void testGetNumCards(){
		Deck testDeck = new Deck();
		assertTrue(testDeck.getNumCards() == 52);
		testDeck.deal(25);
		assertTrue(testDeck.getNumCards() == 27);
	}
	
	@Test
	public void testShuffle(){
		Deck testDeck = new Deck();
		Deck regularDeck = new Deck();
		
		testDeck.shuffle();
		int cardCount = 0;
		// test that every other card in deck starting 
		// from first card consists of lower half
		for ( int i = 0; i < (testDeck.getNumCards()); i = i + 2){
			assertEquals(testDeck.getCardAt(i).getValue(), regularDeck.getCardAt(cardCount).getValue());
			cardCount++;
		}
		regularDeck.shuffle();
		testDeck.deal(1);
		regularDeck.deal(1);
		testDeck.shuffle();
		cardCount = 0;
		for ( int i = 0; i < (testDeck.getNumCards()); i = i + 2){
			assertEquals(testDeck.getCardAt(i).getValue(), regularDeck.getCardAt(cardCount).getValue());
			cardCount++;
		}
		
	}
	@Test
	public void testCut(){
		Deck testDeck = new Deck();
		Deck regDeck = new Deck();
		testDeck.cut(4);
		
		for ( int i = 4; i < 48; i++){
			assertTrue(testDeck.getCardAt(i-4).getValue() == regDeck.getCardAt(i).getValue());
		}
		for( int i = 0; i < 4; i++){
			assertTrue(regDeck.getCardAt(i).getValue() == testDeck.getCardAt(48+i).getValue());
		}
	}
	@Test
	public void testDeal(){
		Deck testDeck = new Deck();
		Deck regDeck = new Deck();
		
		Card[] dealtCards = testDeck.deal(4);
		
		for( int i = 0; i < 4; i++){
			assertEquals(regDeck.getCardAt(i).getValue(), dealtCards[i].getValue());
		}
		for( int i = 4; i < 52; i++){
			assertEquals(regDeck.getCardAt(i).getValue(), testDeck.getCardAt(i-4).getValue());
		}
	}
	@Test
	public void testFlush(){
		Card[] testHand = {new Card(1,0), new Card(2,0), new Card(3,0), new Card(4,0), new Card(5,0)};
		Card[] testHand2 = {new Card(1,0), new Card(2,0), new Card(3,0), new Card(4,0), new Card(5,0), new Card(6,0)};
		Card[] testHand3 = {new Card(1,0), new Card(2,0), new Card(3,0), new Card(4,0)};
		assertTrue(PokerHandEvaluator.hasFlush(testHand));
		assertTrue(PokerHandEvaluator.hasFlush(testHand2));
		assertFalse(PokerHandEvaluator.hasFlush(testHand3));
	}
	@Test
	public void testStraight(){
		// 5 consecutive cards
		Card[] testHand = {new Card(2,0), new Card(3,1), new Card(4,3), new Card(5,0),new Card(6,0)};
		assertTrue(PokerHandEvaluator.hasStraight(testHand));
		
		// 1 ace and 4 consecutive cards
		Card[] testHand2 = {new Card(1,0), new Card(2,0), new Card(3,0), new Card(4,0), new Card(5,0)};
		assertTrue(PokerHandEvaluator.hasStraight(testHand2));
		
		// 2 aces and 3 consecutive cards
		Card[] testHand3 = {new Card(1,0), new Card(1,0), new Card(3,0), new Card(4,0), new Card(5,0)};
		assertTrue(PokerHandEvaluator.hasStraight(testHand3));
		
		// 3 aces and 2 consecutive cards (>2 aces)
		Card[] testHand4 = {new Card(1,0), new Card(1,0), new Card(1,0), new Card(4,0), new Card(5,0)};
		assertFalse(PokerHandEvaluator.hasStraight(testHand4));
		
		// >5 consecutive cards and >2 aces (6 consecutive cards and 3 aces)
		Card[] testHand5 = {new Card(1,0), new Card(1,1), new Card(1,2), new Card(3,0),new Card(4,0), new Card(5,0), 
				new Card(6,0), new Card(7,0), new Card(8,0)};
		assertTrue(PokerHandEvaluator.hasStraight(testHand5));
		
	}
	@Test
	public void testStraightFlush(){
		// 5 consecutive cards of same suit
		Card[] testHand = {new Card(2,0), new Card (3,0), new Card(4,0), new Card(5,0), new Card(6,0)};
		assertTrue(PokerHandEvaluator.hasStraightFlush(testHand));
		
		// 5 non-consecutive cards of same suit
		Card[] testHand2 = {new Card(2,0), new Card (3,0), new Card(4,0), new Card(5,0), new Card(7,0)};
		assertFalse(PokerHandEvaluator.hasStraightFlush(testHand2));
		
		// >5 consecutive cards of same suit
		Card[] testHand3 = {new Card(2,0), new Card (3,0), new Card(4,0), new Card(5,0), new Card(6,0), new Card(7,0)};
		assertTrue(PokerHandEvaluator.hasStraightFlush(testHand3));
		
		// 4 consecutive cards of same suit
		Card[] testHand4 = {new Card(2,0), new Card (3,0), new Card(4,0), new Card(5,0)};
		assertFalse(PokerHandEvaluator.hasStraightFlush(testHand4));
		
		// 5 consecutive cards of different suits
		Card[] testHand5 = {new Card(2,0), new Card (3,1), new Card(4,1), new Card(5,2), new Card(6,2)};
		assertFalse(PokerHandEvaluator.hasStraightFlush(testHand5));
		
		// >5 consecutive cards of different suit
		Card[] testHand6 = {new Card(2,0), new Card (3,1), new Card(4,0), new Card(5,2), new Card(6,0), new Card(7,0)};
		assertFalse(PokerHandEvaluator.hasStraightFlush(testHand6));
	}
	@Test
	public void hasFullHouse(){
		// 3 cards of same value and 2 cards of same value
		Card[] testHand = {new Card(2,0), new Card (2,1), new Card(2,1), new Card(3,1), new Card(3,2)};
		assertTrue(PokerHandEvaluator.hasFullHouse(testHand));
		
		// 3 cards of same value and 3 cards of different value
		Card[] testHand2 = {new Card(2,0), new Card (2,1), new Card(2,1), new Card(3,1), new Card(3,2), new Card(3,1)};
		assertTrue(PokerHandEvaluator.hasFullHouse(testHand2));
		
		// 4 cards of same value and 5 cards of different value
		Card[] testHand3 = {new Card(2,0), new Card (2,1), new Card(2,1), new Card(2,1), new Card(3,2), new Card(3,1), 
				new Card(3,1), new Card(3,2), new Card(3,3)};
		assertTrue(PokerHandEvaluator.hasFullHouse(testHand3));
		
		// Multiple double pairs (6 cards)
		Card[] testHand4 = {new Card(2,0), new Card (2,1), new Card(3,1), new Card(3,1), new Card(4,2), new Card(4,1)};
		assertFalse(PokerHandEvaluator.hasFullHouse(testHand4));
		
		// 3 cards of same value and random cards
		Card[] testHand5 = {new Card(2,0), new Card (2,1), new Card(2,1), new Card(1,1), new Card(5,2), new Card(7,1)};
		assertFalse(PokerHandEvaluator.hasFullHouse(testHand5));
		
		// 4 cards with double pairs
		Card[] testHand6 = {new Card(2,0), new Card (2,1), new Card(3,3), new Card(3,2)};
		assertFalse(PokerHandEvaluator.hasFullHouse(testHand6));
		
		
	}
	@Test
	public void testFourOfKind(){
		// 4 cards of same value and 1 differing cards (5 cards)
		Card[] testHand = {new Card(2,0), new Card (2,1), new Card(2,3), new Card(2,1), new Card(5,2)};
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testHand));
		
		// 5 cards of same value and 1 differing card (6 cards)
		Card[] testHand2 = {new Card(2,0), new Card (2,1), new Card(2,1), new Card(2,3), new Card(2,2), new Card(5,1)};
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testHand2));
		
		// 3 Cards of same value and 2 differing cards (5 cards)
		Card[] testHand3 = {new Card(2,0), new Card (2,1), new Card(2,1), new Card(3,1), new Card(5,2)};
		assertFalse(PokerHandEvaluator.hasFourOfAKind(testHand3));
		
		// 4 Cards of same value (4 cards)
		Card[] testHand4 = {new Card(2,0), new Card (2,1), new Card(2,2), new Card(2,1)};
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testHand4));
		
	}
	@Test
	public void testThreeOfKind(){
		// 3 cards of same value and 2 of differing value
		Card[] testHand = {new Card(2,0), new Card (2,3), new Card(2,2), new Card(5,1), new Card(6,1)};
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testHand));
		
		// 3 cards of same value
		Card[] testHand2 = {new Card(2,0), new Card (2,3), new Card(2,2)};
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testHand2));
		
		// 4 cards of same value
		Card[] testHand3 = {new Card(2,0), new Card (2,3), new Card(2,2), new Card(2,1)};
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testHand3));
		
		// 2 cards of same value and random cards
		Card[] testHand4 = {new Card(2,0), new Card (2,3), new Card(6,2), new Card(4,1), new Card(8,1)};
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(testHand4));
	}
	@Test
	public void testPair(){
		// 2 cards of same value and random cards
		Card[] testHand = {new Card(2,0), new Card (2,3), new Card(8,2), new Card(5,1), new Card(6,1)};
		assertTrue(PokerHandEvaluator.hasPair(testHand));
		
		// 3 cards of same value and random cards
		Card[] testHand2 = {new Card(2,0), new Card (2,3), new Card(2,2), new Card(5,1), new Card(6,1), new Card(10,3)};
		assertTrue(PokerHandEvaluator.hasPair(testHand2));
		
		// 2 cards of same value
		Card[] testHand3 = {new Card(2,0), new Card (2,3)};
		assertTrue(PokerHandEvaluator.hasPair(testHand3));
		
		// random cards
		Card[] testHand4 = {new Card(2,0), new Card (3,3), new Card(8,2), new Card(5,1), new Card(6,1)};
		assertFalse(PokerHandEvaluator.hasPair(testHand4));
	}
	@Test
	public void testTwoPair(){
		// 2 pairs of distinct values
		Card[] testHand = {new Card(2,0), new Card (2,3), new Card(3,2), new Card(3,1), new Card(6,1)};
		assertTrue(PokerHandEvaluator.hasTwoPair(testHand));
		
		// 2 pairs of same value (four of kind)
		Card[] testHand2 = {new Card(2,0), new Card (2,3), new Card(2,2), new Card(2,1), new Card(6,1)};
		assertFalse(PokerHandEvaluator.hasTwoPair(testHand2));
		
		// 1 pair and random cards
		Card[] testHand3 = {new Card(2,0), new Card (2,3), new Card(8,2), new Card(9,1), new Card(13,1)};
		assertFalse(PokerHandEvaluator.hasTwoPair(testHand3));
	}

}
