/*
 * You must implement this class.
 */
public class Rational {

	private int numer, denom;
	//DATA GOES UP HERE
	
	/**
	 * Note: this method must throw an IllegalArgumentException if the <code>denomIn</code> is
	 * 0. Otherwise, it creates a Rational Number.
	 */
	public Rational(int numerIn, int denomIn) {
		if ( denomIn == 0 ){
			throw new IllegalArgumentException("Denominator is Zero");
		}
	    this.numer = numerIn;
	    this.denom = denomIn;
	}
	
	public int getNumer() {
	    return this.numer;
	}
	
	public int getDenom() {
	    return this.denom;
	}
	
	public String toString() {
	    return (this.numer+"/"+this.denom);
	}
	
	public Rational reciprocal() {
	    return new Rational(this.denom, this.numer);
	}
	
	public static Rational multiply(Rational a, Rational b) {
	    return new Rational((a.numer*b.numer), (a.denom*b.denom));
	}
	
	public Rational divide(Rational a) {
	    return new Rational((this.numer*a.denom),(this.denom*a.numer));
	}
	
	public Rational add(Rational a) {
	    return new Rational( ((a.numer*this.denom) + (a.denom*this.numer)), (this.denom*a.denom));
	}
	
}
