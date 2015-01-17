import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testAdd(){
		Student s = new Student("Abe",1000);
		CourseRoster myCourse = new CourseRoster();
		myCourse.addStudent(s);
		s = new Student("Bob",2000);
		myCourse.addStudent(s);
		String list = myCourse.getNames();
		assertTrue(list.equals("AbeBob"));
		s = new Student("Carl",3000);
		myCourse.addStudent(s);
		list = myCourse.getNames();
		assertTrue(list.equals("AbeBobCarl"));
		assertTrue(myCourse.getSize() == 3);
	}
	@Test
	public void testFind(){
		Student s = new Student("Abe",1000);
		CourseRoster myCourse = new CourseRoster();
		myCourse.addStudent(s);
		s = new Student("Bob",2000);
		myCourse.addStudent(s);
		int posAbe = myCourse.findIndex("Abe");
		assertTrue(posAbe == 0);
		int posBob = myCourse.findIndex("Bob");
		assertTrue(posBob == 1);
		int posAaron = myCourse.findIndex("Aaron");
		assertTrue(posAaron == -1);
		int posCarl = myCourse.findIndex("Fred");
		assertTrue(posCarl == -1);
		s = new Student("Carl",3000);
		myCourse.addStudent(s);
		posAbe = myCourse.findIndex("Abe");
		assertTrue(posAbe == 0);
		posBob = myCourse.findIndex("Bob");
		assertTrue(posBob == 1);
		int posFred = myCourse.findIndex("Fred");
		assertTrue(posFred == -1);
		posCarl = myCourse.findIndex("Carl");
		assertTrue(posCarl == 2);
	}
	@Test
	public void testgetValues(){
		Student s = new Student("Abe",1000);
		CourseRoster myCourse = new CourseRoster();
		myCourse.addStudent(s);
		s = new Student("Bob",2500);
		myCourse.addStudent(s);
		int value = myCourse.getValues();
		assertTrue(value == 3500);
		s = new Student("Carl",3300);
		myCourse.addStudent(s);
		value = myCourse.getValues();
		assertTrue(value == 6800);
	}
	@Test
	public void testGiveMoreAid(){
		Student s = new Student("Abe",1000);
		CourseRoster myCourse = new CourseRoster();
		myCourse.addStudent(s);
		s = new Student("Bob",2500);
		myCourse.addStudent(s);
		s = new Student("Carl",3300);
		myCourse.addStudent(s);
		int value = myCourse.getValues();
		assertTrue(value == 6800);
		int amtGiven = myCourse.giveMoreAid();
		assertTrue(amtGiven==1360);
		int newValue = myCourse.getValues();
		assertTrue(newValue == 8160);
	}
	@Test
	public void testRemoveStudent(){
		Student s = new Student("Abe",1000);
		CourseRoster myCourse = new CourseRoster();
		myCourse.addStudent(s);
		s = new Student("Bob",2500);
		myCourse.addStudent(s);
		s = new Student("Carl",3300);
		myCourse.addStudent(s);
		String list = myCourse.getNames();
		assertTrue(list.equals("AbeBobCarl"));
		assertTrue(myCourse.getSize() == 3);
		assertFalse(myCourse.removeStudent("Fred"));
		list = myCourse.getNames();
		assertTrue(list.equals("AbeBobCarl"));
		assertTrue(myCourse.getSize() == 3);
		assertTrue(myCourse.removeStudent("Bob"));
		list = myCourse.getNames();
		assertTrue(list.equals("AbeCarl"));
		assertTrue(myCourse.getSize() == 2);	
	}
}
