
import static org.junit.Assert.*;

import org.junit.Test;


public class StudentTests {
	
	@Test
	public void testPush(){
		MyStack test = new MyStack(1);
		test.push("string");
		String x = (String)test.peek();
		assertTrue(x.equals("string"));
		try{
			test.push("string1");
		}
		catch(StackOverflowError e){
			System.out.println("error caught push");
		}
	}
	
	@Test
	public void testPop(){
		MyStack test = new MyStack(5);
		try{
			test.pop();
		}
		catch(Exception e){
			System.out.println("error caught pop");
		}
		test.push("string");
		test.push("string1");
		test.push("string2");
		test.push("string3");
		test.push("string4");
		String x = (String)test.pop();
		assertTrue(x.equals("string4"));
	}
	// your tests go here

}
