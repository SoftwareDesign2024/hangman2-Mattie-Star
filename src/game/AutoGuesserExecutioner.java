// Matilda
package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;

//The AutoGuesserExecutioner class checks if a guess is right.
public class AutoGuesserExecutioner extends Executioner {
	
	// Constructs an AutoGuesserExecutioner. 
	public AutoGuesserExecutioner(HangmanDictionary dictionary, int wordLength) {
		super(dictionary, wordLength);
		mySecretWord = makeSecretWord(dictionary, wordLength);
		myDisplayWord = new DisplayWord(mySecretWord);
	}
	
	// Returns a secret word provided by the user. 
    private String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
		String secretWord = ConsoleReader.promptString("Choose a secret word that is " + wordLength + " letters long: ");
	    while (! dictionary.contains(secretWord, wordLength)) {
	    	secretWord = ConsoleReader.promptString("That word is not recognized, please choose another: ");
	    }
	    return secretWord;
	}
}
