import java.util.*;
import java.io.*;
import pkg.*;
import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) throws Exception{
		File pokemons = new File("./pokemon.txt");
		Scanner numLines = new Scanner(pokemons);		
        Scanner sc = new Scanner(pokemons);	
		int c;
		for(c = 0;numLines.hasNextLine();c++){
			numLines.nextLine();
        }  
		String [] p = new String[c];		
        for(int i = 0;sc.hasNextLine();i++){	
            String line = sc.nextLine();
            p[i] = line;
        } 
//-------------------------------------------------------------------------------------
		Pokemon [] poke = new Pokemon[c];
		int s1,s2,s3;
		for(int a = 0;a<c;a++){
			s1 = p[a].indexOf("_");
			s2 = p[a].indexOf("_",s1+1);
			if(p[a].indexOf("_",s2+1)>0){
				s3 = p[a].indexOf("_",s2+1);
				poke[a]= new Pokemon(p[a].substring(s1+1,s2),p[a].substring(0,s1), p[a].substring(s2+1,s3),p[a].substring(s3+1));
			}
			else{
				poke[a]= new Pokemon(p[a].substring(s1+1,s2),p[a].substring(0,s1),p[a].substring(s2+1));
			}
		}
//-----------------------------------------------------------------------------------------------------------------------------------------------------
		Scanner guess = new Scanner(System.in);
		Random random = new Random();
		int randomPokemon = random.nextInt(p.length)+1;
		String g;
		int e=0;
		int hint = 1;
		boolean found = false;
		System.out.println("A random pokemon from generations 1-6 has been chosen. Your job is to try and guess it. You will be able to see if the Pokemon number is higher or lower then your guess and see if you got the correct type(s).");
		while(true){
			System.out.println("Guess a pokemon. If you give up type \"quit\" or get a hint with \"hint.\" You get unlimited hints.");
			g = guess.nextLine();
			for (int a=0;a<poke.length;a++) {
				if(poke[a].getName().equalsIgnoreCase(g)) {
                	found = true;
                	e = a;
                	break;
            	}
			}
			if(g.equalsIgnoreCase("quit")||g.equalsIgnoreCase("q")){
				System.out.print("The Pokemon was "+poke[randomPokemon-1].getName());
				break;
			}
			else if(g.equalsIgnoreCase("hint")||g.equalsIgnoreCase("h")){
				if(hint>poke[randomPokemon-1].getName().length()){
					System.out.println("You have no more hints.");
					System.out.println("");
				}
				else{
					System.out.println("The first letter of the Pokemon name is \""+poke[randomPokemon-1].getName().substring(0,hint)+"\"");
					System.out.println("");
					hint++;
				}
			}
			else if(found==false){
				System.out.println("Looks like you made a mistake. You either entered a nonexistant Pokemon or misspelled the name.");
				System.out.println("");
			}
			else if(g.equalsIgnoreCase(poke[randomPokemon-1].getName())){
				System.out.println("");
				System.out.print("Nice! You guessed the Pokemon "+poke[randomPokemon-1].getName());
				break;
			}
			else{
				found = false;
				if(e>randomPokemon){
					System.out.println("Pokemon#: Lower");
				}
				else{
					System.out.println("Pokemon#: Higher");
				}
				
				if(poke[randomPokemon-1].getType1().equalsIgnoreCase(poke[e].getType1())){
					System.out.println("Type 1: Correct-"+poke[randomPokemon-1].getType1());
				}
				else if(poke[e].getType1().equalsIgnoreCase(poke[randomPokemon-1].getType2())){
					System.out.println("Type 1: "+poke[e].getType1()+" is its second type");
				}
				else{
					System.out.println("Type 1: Incorrect");
				}
				
				if(poke[randomPokemon-1].getType2().equalsIgnoreCase(poke[e].getType2())){
					System.out.println("Type 2: Correct-"+poke[randomPokemon-1].getType2());
					System.out.println("");
				}
				else if(poke[e].getType2().equalsIgnoreCase(poke[randomPokemon-1].getType1())){
					System.out.println("Type 2: "+poke[e].getType2()+" is its first type");
					System.out.println("");
				}
				else{
					System.out.println("Type 2: Incorrect");
					System.out.println("");
				}
			}
		}
	}
}