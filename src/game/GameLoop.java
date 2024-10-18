// Matilda 
package game;

import java.util.Scanner;
import util.HangmanDictionary;

// Initiates the hangman game until Q is entered. 
public class GameLoop {
	public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;

	// Constants for GameLoop.
	private static String OPTIONS = "OCAQ";
	
	// Constructs a GameLoop. 
	public GameLoop() {
		System.out.println("\nWelcome to Hangman!");
		String userChoice = askForUserChoice();
		while(!userChoice.equals("Q")) {
			if(userChoice.equals("A")) {
				new HangmanGameAutoGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES, userChoice).play();
			
			}else {
				new HangmanGame(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES, userChoice).play();
			}
			userChoice = askForUserChoice();
		}
		System.out.print("Thanks for playing!");
	}

	// Prompts the user to select an option until a valid option is provided. 
    public String askForUserChoice() {
    	System.out.print("\nEnter an option below to start:" +
    			"\n 	Enter O to play the original HangmanGame" +
    			"\n 	Enter C to play The HangmanGame aginst a cheating executioner" +
    			"\n 	Enter A to watch an auto guesser play HangmanGame" +
    			"\n 	Enter Q to stop playing HangmanGame\n" + 
    			"Selected option: ");
    	
    	String userChoice = "";
    	boolean validOption = false;
    	while(!validOption) {
    		try {
    			Scanner selectedOption = new Scanner(System.in);
        		userChoice = selectedOption.next().replace(" ", "").toUpperCase().substring(0,1);
        		if (OPTIONS.contains(userChoice)) {
        			validOption = true; 
        		}
        	}catch (Exception notAnOption) {
        		System.out.println("Please enter a valid option.");
        	}
    	}
    	return userChoice;
    }
}
