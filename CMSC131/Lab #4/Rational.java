/*
 * You must implement this class.
 */
public class Rational {

	private int numerator, denominator;
	//DATA GOES UP HERE
	
	/**
	 * Note: this method must throw an IllegalArgumentException if the <code>denomIn</code> is
	 * 0. Otherwise, it creates a Rational Number.
	 */
	public Rational(int numerIn, int denomIn) {
	    this.numerator = numerIn;
	    this.denominator = denomIn;
	}
	
	/**
	 * The following is the copy-constructor.
	 * @return
	 */
	public Rational( Rational other ) {
		this.numerator = other.numerator;
		this.denominator = other.denominator;
	}
	
	public int getNumer() {
	   return this.numerator;
	}
	
	public int getDenom() {
	    return this.denominator;
	}
	
	public String toString() {
		return (this.numerator+"/"+this.denominator);
	}
	
	public Rational reciprocal() {
	    return new Rational(this.denominator, this.numerator);
	   
	}
	
	public static Rational multiply(Rational a, Rational b) {
	   return new Rational(a.numerator*b.numerator, a.denominator*b.denominator);
	}
	
	public Rational divide(Rational a) {
		return new Rational(this.numerator*a.denominator, this.denominator*a.numerator);
	
	}
	
	public Rational add(Rational a) {
		return new Rational( ((a.numerator*this.denominator) + (this.numerator*a.denominator)), (this.denominator*a.denominator));
	}
	private static int gcd(int a, int b){
		int r = a % b;
		while (r != 0){
			a = b;
			b = r;
			r = a % b;	
		}
		return b;
	}
	
	public Rational reduce() {
		int testGCD = gcd(this.numerator, this.denominator);
		this.numerator = (this.numerator/testGCD);
		this.denominator = (this.denominator/testGCD);
		return this;
	}
	public boolean equals(Object other){
		if (other instanceof Object){
			if (other != null){
				if (other instanceof Rational){
					Rational objectRational = (Rational) other;
					if (this.divide(objectRational).numerator == this.divide(objectRational).denominator){
						System.out.println("Rationals are equal");
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
