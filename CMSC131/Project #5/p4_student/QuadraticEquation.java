/**
 * A general representation of a quadratic equation of the form:
 * (a*x^2 + b*x + c)
 * 
 * @author Evan Golub
 * @date March 2013
 */

package p4_student;
/** Name: Eric Lancaster
Section: 0404
TA: Xuetong Sun
Date: 11/06/14
 */


public class QuadraticEquation {
	private final MyDouble a;
	private final MyDouble b;
	private final MyDouble c;
	
	/**
	 * Purpose: Constructor for quadratic class that
	 * intializes a, b, and c terms as zero when
	 * parameters aren't provided
	 * All terms are MyDouble objects
	 */
	public QuadraticEquation() {
		this.a = MyDouble.zero;
		this.b = MyDouble.zero;
		this.c = MyDouble.zero;
	}
	/**
	 * Purpose: Constructor for quadratic class
	 * that initializes a and b terms as zero
	 * and c as cIn paramter
	 * @param cIn: c term coefficient
	 */
	public QuadraticEquation(MyDouble cIn) {
		this.a = MyDouble.zero;
		this.b = MyDouble.zero;
		this.c = new MyDouble(cIn);
	}
	/**
	 * Purpose: constructor for quadratic class
	 * that intializes a term as zero and
	 * c as cIn and b as bIn parameters
	 * @param bIn: b term coefficent
	 * @param cIn: c term coefficent
	 */
	public QuadraticEquation(MyDouble bIn, MyDouble cIn) {
		this.a = MyDouble.zero;
		this.b = new MyDouble(bIn);
		this.c = new MyDouble(cIn);
	}
	/**
	 * Purpose: constructor for quadratic class
	 * that initializes a, b, c and terms as
	 * aIn, bIn, and cIn respectively
	 * @param aIn: a term coefficent
	 * @param bIn: b term coefficient
	 * @param cIn: c term coefficent
	 */
	public QuadraticEquation(MyDouble aIn, MyDouble bIn, MyDouble cIn) {
		this.a = new MyDouble(aIn);
		this.b = new MyDouble(bIn);
		this.c = new MyDouble(cIn);
	}
	/**
	 * Purpose: copy constructor that copies terms
	 * of another quadratic class object
	 * @param other
	 */
	public QuadraticEquation(QuadraticEquation other) {
		this.a = other.a;
		this.b = other.b;
		this.c = other.c;
	}
	/**
	 * Purpose: Get a coefficient as MyDouble object
	 * @return: a term coefficeint
	 */
	public MyDouble getA() {
		return this.a;
	}
	/**
	 * Purpose: Get b coefficent as MyDouble object
	 * @return: b term coefficent
	 */
	public MyDouble getB() {
		return this.b;
	}
	/**
	 * Purpose: Get c coefficent as MyDouble object
	 * @return: c term coefficent
	 */
	public MyDouble getC() {
		return this.c;
	}
	
	/**
	 * Purpose: evaluate quadratic equation as point x
	 * @param x: point to evaluate
	 * @return: evaluated MyDouble form
	 */
	public MyDouble evaluate(MyDouble x) {
		MyDouble firstTermVal = (x.square()).multiply(this.a);
		MyDouble secondTermVal = (x.multiply(this.b));
		MyDouble thirdTermVal = this.c;
		MyDouble sum = firstTermVal.add(secondTermVal);
		return sum = sum.add(thirdTermVal);
		
	}
	/**
	 * Purpose: add quadratic equations
	 * @param quadIn: other quadratic equation
	 * @return: new sum quadratic equation
	 */
	public QuadraticEquation add(QuadraticEquation quadIn) {
		MyDouble firstTermSum = this.a.add(quadIn.a);
		MyDouble secondTermSum = this.b.add(quadIn.b);
		MyDouble thirdTermSum = this.c.add(quadIn.c);
		return new QuadraticEquation(firstTermSum, secondTermSum, thirdTermSum);
	}
	/**
	 * Purpose: subtract quadratic equations
	 * @param quadIn: other quadratic equation
	 * @return: new subtracted quadratic equation
	 */
	public QuadraticEquation subtract(QuadraticEquation quadIn) {
		MyDouble firstTermSum = this.a.subtract(quadIn.a);
		MyDouble secondTermSum = this.b.subtract(quadIn.b);
		MyDouble thirdTermSum = this.c.subtract(quadIn.c);
		return new QuadraticEquation(firstTermSum, secondTermSum, thirdTermSum);
	}
	/**
	 * Purpose: multiply quadratic equations
	 * @param quadIn: other quadratic equation
	 * @return: new multiplied quadratic equation
	 */
	public QuadraticEquation limitedMultiply(QuadraticEquation quadIn) {
		MyDouble firstTerm;
		MyDouble secondTerm;
		MyDouble thirdTerm;
		// Can handle forms: (ax^2 + bx + c) * c and (ax^2 + bx) * c and (ax^2) * c
		// (bx + c)(bx+c) and (bx)(bx) and (bx+c)*c and c*c
		
		if ( (this.a.isZero() == true) && (quadIn.a.isZero() == true) ){
			// both a terms are zero
			// providing: (bx + c)(bx + c) where any coefficient can equal 
			firstTerm = (this.b.multiply(quadIn.b));
			secondTerm = (this.b.multiply(quadIn.c)).add(this.c.multiply(quadIn.b));
			thirdTerm = (this.c.multiply(quadIn.c));
			return new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		}else if ( (this.a.multiply(quadIn.a)).isZero() && (this.b.multiply(quadIn.b)).isZero() ){
			// product of a terms equal zero and product of b terms zero
			// (ax^2 + bx + c) * c
			if ( this.a.isZero() && this.b.isZero() && !(this.c.isZero()) ){
				// current object is of form: c
				firstTerm = quadIn.a.multiply(this.c);
				secondTerm = quadIn.b.multiply(this.c);
				thirdTerm = quadIn.c.multiply(this.c);
				return new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
			}else{
				// parameter object is of form: c
				firstTerm = this.a.multiply(quadIn.c);
				secondTerm = this.b.multiply(quadIn.c);
				thirdTerm = this.c.multiply(quadIn.c);
				return new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
			}
		}else{
			return null;
		}
	}
	/**
	 * Purpose: derive quadratic equation
	 * @return: new derived quadratic equation
	 */
	public QuadraticEquation derivative() {
		MyDouble secondTerm = this.a.multiply(new MyDouble(2.0));
		MyDouble thirdTerm = this.b;
		return new QuadraticEquation(MyDouble.zero, secondTerm, thirdTerm);
	}
	/**
	 * Purpose: normalize a quadratic equation
	 * according to equation sqrt(a^2 + b^2 + c^2)
	 * @return: new normalized quadratic equation
	 */
	public MyDouble normalize() {
		MyDouble sumDouble = new MyDouble(this.a.square().add(this.b.square()));
		sumDouble = sumDouble.add(this.c.square());
		sumDouble = sumDouble.sqrt();
		return sumDouble;
	}

	/**
	 * Purpose: compare quad equations looking for equality
	 * @return: return ints -1,0,1 for less than, equal to,
	 * and greater than (current object vs. parameter object)
	 */
	public int compareTo(QuadraticEquation quadIn) {
		MyDouble firstNormalize = this.normalize();
		MyDouble secondNormalize = quadIn.normalize();
		return firstNormalize.compareTo(secondNormalize);
	}
	
	/**
	 * Purpose: convert quad equation to string
	 * @return: string version of quad equation
	 */
	public String toString() {
		String firstTerm = this.a.toString() + "x^2";
		String secondTerm = this.b.toString() + "x";
		String thirdTerm = this.c.toString();
		
		boolean firstTermZero = this.a.isZero();
		boolean secondTermZero = this.b.isZero();
		boolean thirdTermZero = this.c.isZero();
		
		if ( firstTermZero && secondTermZero && thirdTermZero){
			return "0";
		}else if ( !(firstTermZero) && secondTermZero && thirdTermZero ){
			return (firstTerm);
	
		}else if ( firstTermZero && !(secondTermZero) && thirdTermZero){
			return (secondTerm);
		
		}else if (firstTermZero && secondTermZero && !(thirdTermZero)){
			return (thirdTerm);
			
		}else if ( !(firstTermZero) && !(secondTermZero) && thirdTermZero){
			if( (this.b.compareTo(MyDouble.zero)) == 1){
				secondTerm = "+" + secondTerm;
			}
			return (firstTerm + secondTerm);
			
		}else if ( !(firstTermZero) && secondTermZero && !(thirdTermZero)){
			if ( (this.c.compareTo(MyDouble.zero)) == 1 ){
				thirdTerm = "+" + thirdTerm;
			}
			return (firstTerm + thirdTerm);
			
		}else if( firstTermZero && !(secondTermZero) && !(thirdTermZero)){
			if ( (this.c.compareTo(MyDouble.zero)) == 1 ){
				thirdTerm = "+" + thirdTerm;
			}
			return (secondTerm + thirdTerm);
			
		}else {
			// ( !(firstTermZero) && !(secondTermZero) && !(thirdTermZero ) 
			if( (this.b.compareTo(MyDouble.zero)) == 1 ){
				secondTerm = "+" + secondTerm;
			}
			if( (this.c.compareTo(MyDouble.zero)) == 1){
				thirdTerm = "+" + thirdTerm;
			}
			return (firstTerm + secondTerm + thirdTerm);
		}
	}
		
	/**
	 * Purpose: convert string to quadratic equation
	 * @return: quadratic equation object
	 */
	public static QuadraticEquation parseQuadratic(String str) {
		str = str.replace(" ", "");
		String firstTerm;
		String secondTerm;
		String thirdTerm;
		
		if ( (str.indexOf("x") == -1) && (str.indexOf("x^2") == -1)){
			// Exists no x in equation --> form: c
			return new QuadraticEquation(MyDouble.parseDouble(str));
		}else if ( (str.indexOf("x^2") == -1) && (str.indexOf("x") != -1) ){
			// Exists only a bx --> forms: bx, bx +c
			secondTerm = str.substring(0, str.indexOf("x"));
			if ( (str.indexOf("x")) != (str.length()-1) ){
				// bx is not last index --> form: bx + c
				thirdTerm = str.substring(str.indexOf("x") + 1);
				thirdTerm = thirdTerm.replace("+", "");
				return new QuadraticEquation(MyDouble.zero, MyDouble.parseDouble(secondTerm), 
						MyDouble.parseDouble(thirdTerm));
			}else{
				// form: bx
				return new QuadraticEquation((MyDouble.zero), MyDouble.parseDouble(secondTerm), MyDouble.zero);
			}
		}else{
			// Eliminated forms: bx + c, bx, c
			// Exists x^2 -> forms: x^2, x^2+bx+c, x^2+bx, x^2+c
			
			// Store term of x^2 in firstTerm
			firstTerm = str.substring(0, str.indexOf("x^2"));
			
			// last index is x^2 -> forms: x^2
			if ( (str.indexOf("x^2") + 2) == (str.length() - 1)  ){
				return new QuadraticEquation(MyDouble.parseDouble(firstTerm), MyDouble.zero, MyDouble.zero);
			}
			// Exists both an x^2 and bx -> forms: (x^2 + bx), (x^2 + bx + c)
			if ( str.indexOf("x^2") != str.lastIndexOf("x") && str.lastIndexOf("x") != -1 ){
				secondTerm = str.substring(str.indexOf("x^2")+3, str.lastIndexOf("x"));
				
				// Exists c term -> forms: x^2 + bx + c
				if( (str.lastIndexOf("x")) != (str.length()-1)){
					thirdTerm = str.substring(str.lastIndexOf("x")+1); 
					secondTerm = secondTerm.replace("+", "");
					thirdTerm = thirdTerm.replace("+", "");
					return new QuadraticEquation((MyDouble.parseDouble(firstTerm)), (MyDouble.parseDouble(secondTerm)), 
							(MyDouble.parseDouble(thirdTerm)));
				}else{
					// forms: x^2 + bx
					secondTerm = secondTerm.replace("+", "");
					return new QuadraticEquation((MyDouble.parseDouble(firstTerm)), (MyDouble.parseDouble(secondTerm)), (MyDouble.zero));
				}
			}
			// must have x^2 --> eliminated forms x^2, x^2 + bx, x^2 + bx + c 
			// only possible form left --> x^2 + c
			thirdTerm = str.substring(str.indexOf("x^2") + 3);
			thirdTerm = thirdTerm.replace("+", "");
			return new QuadraticEquation(MyDouble.parseDouble(firstTerm), MyDouble.zero, MyDouble.parseDouble(thirdTerm));
			}
	}
	
	//NOTE: THIS IS WRITTEN FOR YOU - DO NOT CHANGE!!!!
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			QuadraticEquation casted = (QuadraticEquation)other;
			return (
					a.equals(casted.a) && 
					b.equals(casted.b) && 
					c.equals(casted.c)
			);
		}
	}
	
	
}