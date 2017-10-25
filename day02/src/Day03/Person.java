package Day03;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int Age;
	
	public Person(String name,int Age){
		this.name = name;
		this.Age = Age;
		
	}
	public String toString(){
		return name+"->"+Age;
	}
	
}
