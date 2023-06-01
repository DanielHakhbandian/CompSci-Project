package pkg;
import java.util.Scanner;
import java.util.Random;


public class Pokemon {
	String name;
	String number;
	String type1;
	String type2;
	public Pokemon(String name,String number, String type1, String type2) {
		this.name = name;
		this.number = number;
		this.type1 = type1;
		this.type2 = type2;
	}
	public Pokemon(String name,String number, String type1) {
		this.name = name;
		this.number = number;
		this.type1 = type1;
		type2 = "none";
	}
	public String getName(){
		return name;
	}
	public String getNumber(){
		return number;
	}
	public String getType1(){
		return type1;
	}
	public String getType2(){
		return type2;
	}
}
