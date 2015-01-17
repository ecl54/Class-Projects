 
public class Student{
	//This class is already implemented for you and you should  
	// NOT modify this class at all

	private String name;
	private int financialAid;
	
	public Student (){
		this.name = "None";
		financialAid = 0;
	}
	public Student (String name, int financialAid){
		this.name = name;
		this.financialAid = financialAid;
	}
	public Student (Student other){
		this.name = other.name;
		this.financialAid = other.financialAid;
	}
	public String getName(){
		return this.name;
	}
	public int getValue(){
		return financialAid;
	}
	public int giveMoreAid(){
		int oldVal = financialAid;
		double newVal = financialAid;
		newVal *= 1.2;
		financialAid = (int)newVal;
		return financialAid - oldVal;
	}
}
